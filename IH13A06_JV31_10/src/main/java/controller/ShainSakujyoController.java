package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.ShainDAO;

public class ShainSakujyoController implements Controller {
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {

	    String method = req.getMethod();
	    
	    if ("POST".equalsIgnoreCase(method)) {
	    	ShainDAO dao = new ShainDAO();
	    	
	        String idStr = req.getParameter("id");

	        if (idStr != null) {
	            int id = Integer.parseInt(idStr);
	            dao.delete(id);  // DAO経由で削除
	        }

	        req.getSession().setAttribute("flashMessage", "削除が完了しました。");
	        req.getSession().setAttribute("flashType", "error");
	        resp.sendRedirect(req.getContextPath() + "/app/shain_itirann");
	    }
	}
}
