package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.DBManager;



@WebServlet("/shain_itirann")
public class ShainItirann extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Shain> shainList = new ArrayList<>();

        try (Connection conn = DBManager.getConnection()) {
            String sql = "SELECT ユーザーID, 氏名, 性別, 備考 FROM 社員マスタ ORDER BY ユーザーID";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Shain s = new Shain();
                s.setId(rs.getInt("ユーザーID"));
                s.setName(rs.getString("氏名"));
                s.setGender(rs.getString("性別"));
                s.setRemarks(rs.getString("備考"));
                shainList.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // JSPへ社員リストをセット
        req.setAttribute("shainList", shainList);

        req.getRequestDispatcher("/shain_itirann.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        // 登録完了画面へリダイレクト
        resp.sendRedirect(req.getContextPath() + "/complete.jsp");
    }
}
