package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.ShainDAO;

public class ShainSakujyo extends HttpServlet {

    private final ShainDAO dao = new ShainDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");

        if (idStr != null) {
            int id = Integer.parseInt(idStr);
            dao.delete(id);  // DAO経由で削除
        }

        req.getSession().setAttribute("flashMessage", "削除が完了しました。");
        req.getSession().setAttribute("flashType", "error");
        resp.sendRedirect(req.getContextPath() + "/shain_itirann");
    }
}
