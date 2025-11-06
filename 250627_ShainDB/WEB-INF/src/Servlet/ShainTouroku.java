package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.DBManager;



@WebServlet("/shain_touroku")
public class ShainTouroku extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 社員登録フォームを表示
        req.getRequestDispatcher("/shain_touroku.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        // フォームのname属性に合わせてパラメータ取得
        String name = req.getParameter("氏名");
        String gender = req.getParameter("性別");
        String remarks = req.getParameter("備考");

        StringBuilder errorMessage = new StringBuilder();

        // 氏名チェック（必須）
        if (name == null || name.trim().isEmpty()) {
            errorMessage.append("氏名を入力してください。<br>");
        }

        // 性別チェック（必須、MかF）
        if (gender == null || !(gender.equals("M") || gender.equals("F"))) {
            errorMessage.append("性別を選択してください。<br>");
        }
        
        if (remarks == null) {
            remarks = "";
        }


        // 備考は任意なのでチェックしない

        if (errorMessage.length() > 0) {
            // エラーあり → フォームに戻る
            req.setAttribute("errorMessage", errorMessage.toString());

            // 入力値保持のため、リクエストスコープにセット
            req.setAttribute("氏名", name);
            req.setAttribute("性別", gender);
            req.setAttribute("備考", remarks);

            req.getRequestDispatcher("/shain_touroku.jsp").forward(req, resp);
            return;
        }

        // ここでDB保存処理等を行う
        try (Connection conn = DBManager.getConnection()) {
            String sql = "INSERT INTO 社員マスタ (氏名, 性別, 備考) VALUES (?, ?, ?)";
            PreparedStatement pStmt = conn.prepareStatement(sql);

		    pStmt.setString(1, name);
		    pStmt.setString(2, gender);
		    pStmt.setString(3, remarks);

		    pStmt.executeUpdate();

			
		}catch (SQLException e) {
			e.printStackTrace();
		}

        // 登録完了画面へリダイレクト
        resp.sendRedirect(req.getContextPath() + "/complete.jsp");
    }
}
