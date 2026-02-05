package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Shain;
import model.ShainDAO;

public class ShainHensyuu extends HttpServlet {

    private final ShainDAO dao = new ShainDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        if (idStr != null) {
            int id = Integer.parseInt(idStr);
            Shain shain = dao.findById(id);
            if (shain != null) {
                req.setAttribute("ユーザーID", shain.getId());   // ← エンティティのフィールド名に合わせる
                req.setAttribute("氏名", shain.getName());
                req.setAttribute("性別", shain.getGender());
                req.setAttribute("備考", shain.getNote());
            }
        }
        req.getRequestDispatcher("/WEB-INF/shain_hensyuu.jsp").forward(req, resp);
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
            req.setAttribute("errorMessage", errorMessage.toString());
            req.setAttribute("ユーザーID", idStr);
            req.setAttribute("氏名", name);
            req.setAttribute("性別", gender);
            req.setAttribute("備考", remarks);
            req.getRequestDispatcher("/WEB-INF/shain_hensyuu.jsp").forward(req, resp);
            return;
        }

        int id = Integer.parseInt(idStr);
        Shain shain = dao.findById(id);
        if (shain != null) {
            shain.setName(name);
            shain.setGender(gender);
            shain.setNote(remarks);
            dao.update(shain);
        }

        req.getSession().setAttribute("flashMessage", "更新が完了しました。");
        req.getSession().setAttribute("flashType", "success");
        resp.sendRedirect(req.getContextPath() + "/shain_itirann");
    }
}
