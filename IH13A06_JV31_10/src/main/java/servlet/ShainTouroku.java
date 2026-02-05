package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Shain;
import model.ShainDAO;

public class ShainTouroku extends HttpServlet {

    private ShainDAO shainDAO = new ShainDAO(); // DAOのインスタンス作成

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 社員登録フォームを表示
        req.getRequestDispatcher("/WEB-INF/shain_touroku.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        // フォームのname属性に合わせてパラメータ取得
        String name = req.getParameter("氏名");
        String gender = req.getParameter("性別");
        String note = req.getParameter("備考");

        StringBuilder errorMessage = new StringBuilder();

        // 氏名チェック（必須）
        if (name == null || name.trim().isEmpty()) {
            errorMessage.append("氏名を入力してください。<br>");
        }

        // 性別チェック（必須、MかF）
        if (gender == null || !(gender.equals("M") || gender.equals("F"))) {
            errorMessage.append("性別を選択してください。<br>");
        }

        if (note == null) {
        	note = "";
        }

        if (errorMessage.length() > 0) {
            // エラーあり → フォームに戻る
            req.setAttribute("errorMessage", errorMessage.toString());
            req.setAttribute("氏名", name);
            req.setAttribute("性別", gender);
            req.setAttribute("備考", note);
            req.getRequestDispatcher("/WEB-INF/shain_touroku.jsp").forward(req, resp);
            return;
        }

        // DAOを使ってJPA経由で保存
        Shain shain = new Shain();
        shain.setName(name);
        shain.setGender(gender);
        shain.setNote(note);

        shainDAO.save(shain); // データベースに保存

        // 登録完了画面へリダイレクト
        resp.sendRedirect(req.getContextPath() + "/complete");
    }
}
