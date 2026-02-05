package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Shain;
import model.ShainDAO;

public class ShainItirann extends HttpServlet {

    private final ShainDAO dao = new ShainDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String note = req.getParameter("note");
        String sort = req.getParameter("sort");
        String order = req.getParameter("order");

        List<Shain> shainList = dao.search(name, gender, note, sort, order); // DAO 側で条件検索
        req.setAttribute("shainList", shainList);
        req.getRequestDispatcher("/WEB-INF/shain_itirann.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.sendRedirect(req.getContextPath() + "/WEB-INF/complete.jsp");
    }
}
