package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.DBManager;

@WebServlet("/shain_hensyuu")
public class ShainHensyuu extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 編集対象の社員IDを取得
        String idStr = req.getParameter("id");

        if (idStr != null) {
            try (Connection conn = DBManager.getConnection()) {
                String sql = "SELECT 氏名, 性別, 備考 FROM 社員マスタ WHERE ユーザーID = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, Integer.parseInt(idStr));
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    req.setAttribute("ユーザーID", idStr);
                    req.setAttribute("氏名", rs.getString("氏名"));
                    req.setAttribute("性別", rs.getString("性別"));
                    req.setAttribute("備考", rs.getString("備考"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // 編集フォームへ転送
        req.getRequestDispatcher("/shain_hensyuu.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String idStr = req.getParameter("ユーザーID");
        String name = req.getParameter("氏名");
        String gender = req.getParameter("性別");
        String remarks = req.getParameter("備考");

        StringBuilder errorMessage = new StringBuilder();

        if (name == null || name.trim().isEmpty()) {
            errorMessage.append("氏名を入力してください。<br>");
        }

        if (gender == null || !(gender.equals("M") || gender.equals("F"))) {
            errorMessage.append("性別を選択してください。<br>");
        }

        if (remarks == null) {
            remarks = "";
        }

        if (errorMessage.length() > 0) {
            // エラー内容と入力内容を戻す
            req.setAttribute("errorMessage", errorMessage.toString());
            req.setAttribute("ユーザーID", idStr);
            req.setAttribute("氏名", name);
            req.setAttribute("性別", gender);
            req.setAttribute("備考", remarks);

            req.getRequestDispatcher("/shain_hensyuu.jsp").forward(req, resp);
            return;
        }

        try (Connection conn = DBManager.getConnection()) {
            String sql = "UPDATE 社員マスタ SET 氏名 = ?, 性別 = ?, 備考 = ? WHERE ユーザーID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, gender);
            stmt.setString(3, remarks);
            stmt.setInt(4, Integer.parseInt(idStr));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 一覧へリダイレクト
        req.getSession().setAttribute("flashMessage", "更新が完了しました。");
        req.getSession().setAttribute("flashType", "success"); 
        resp.sendRedirect(req.getContextPath() + "/shain_itirann");
    }
}
