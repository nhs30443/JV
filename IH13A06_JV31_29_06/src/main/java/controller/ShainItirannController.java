package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Shain;
import model.ShainDAO;

public class ShainItirannController implements Controller {
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {

	    String method = req.getMethod();

	    if ("GET".equalsIgnoreCase(method)) {
	    	ShainDAO dao = new ShainDAO();
	    	
	        String name = req.getParameter("name");
	        String gender = req.getParameter("gender");
	        String note = req.getParameter("note");
	        String sort = req.getParameter("sort");
	        String order = req.getParameter("order");

	        List<Shain> shainList = dao.search(name, gender, note, sort, order); // DAO 側で条件検索
	        req.setAttribute("shainList", shainList);
	        req.getRequestDispatcher("/WEB-INF/shain_itirann.jsp").forward(req, resp);

	    }
	}
}
