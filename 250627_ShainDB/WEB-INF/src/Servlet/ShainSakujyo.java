package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.DBManager;

@WebServlet("/shain_sakujyo")
public class ShainSakujyo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 編集対象の社員IDを取得
        String idStr = req.getParameter("id");

        if (idStr != null) {
            try (Connection conn = DBManager.getConnection()) {
                String sql = "DELETE FROM 社員マスタ WHERE ユーザーID = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, Integer.parseInt(idStr));
                stmt.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // 一覧ページにリダイレクト
        req.getSession().setAttribute("flashMessage", "削除が完了しました。");
        req.getSession().setAttribute("flashType", "error");
        resp.sendRedirect(req.getContextPath() + "/shain_itirann");
    }
}
    