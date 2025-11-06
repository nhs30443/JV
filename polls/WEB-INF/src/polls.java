import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/polls")
public class polls extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // フォーム表示
        req.getRequestDispatcher("/polls.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String[] interests = req.getParameterValues("interest");
        String age = req.getParameter("age");

        StringBuilder errorMessage = new StringBuilder();

        // 名前チェック（必須）
        if (name == null || name.trim().isEmpty()) {
            errorMessage.append("名前を入力してください。<br>");
        }

        // 性別チェック（必須）
        if (gender == null || (!gender.equals("male") && !gender.equals("female"))) {
            errorMessage.append("性別を選択してください。<br>");
        }

        // 年齢チェック（必須）
        if (age == null || age.trim().isEmpty()) {
            errorMessage.append("年齢を選択してください。<br>");
        }

        // 興味のある分野は必須じゃないのでチェックしないが、必要なら追加可能

        if (errorMessage.length() > 0) {
            // エラーあり
            req.setAttribute("errorMessage", errorMessage.toString());

            // 入力値を保持するためにパラメータはリクエストにそのまま残るので、JSP側でrequest.getParameter等で取得可能
            req.getRequestDispatcher("/polls.jsp").forward(req, resp);
            return;
        }

        // エラーなし：ここでDB保存や他処理を行う

        // 完了画面やサンクスページへリダイレクト
        resp.sendRedirect(req.getContextPath() + "/complete.jsp");

    }
}
