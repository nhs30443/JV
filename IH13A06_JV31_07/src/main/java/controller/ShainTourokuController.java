package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Shain;
import model.ShainDAO;

public class ShainTourokuController implements Controller {
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {

	    String method = req.getMethod();

	    if ("GET".equalsIgnoreCase(method)) {
	        // フォーム表示
	        req.getRequestDispatcher("/WEB-INF/shain_touroku.jsp").forward(req, resp);

	    }
	    
	    if ("POST".equalsIgnoreCase(method)) {
	        req.setCharacterEncoding("UTF-8");
	         
	    	ShainDAO shainDAO = new ShainDAO(); // DAOのインスタンス作成

	        String name = req.getParameter("氏名");
	        String gender = req.getParameter("性別");
	        String note = req.getParameter("備考");

	        StringBuilder errorMessage = new StringBuilder();
	        if (name == null || name.trim().isEmpty()) {
	            errorMessage.append("氏名を入力してください。<br>");
	        }
	        if (gender == null || !(gender.equals("M") || gender.equals("F"))) {
	            errorMessage.append("性別を選択してください。<br>");
	        }
	        if (note == null) note = "";

	        if (errorMessage.length() > 0) {
	            req.setAttribute("errorMessage", errorMessage.toString());
	            req.setAttribute("氏名", name);
	            req.setAttribute("性別", gender);
	            req.setAttribute("備考", note);
	            req.getRequestDispatcher("/WEB-INF/shain_touroku.jsp").forward(req, resp);
	            return;
	        }

	        Shain shain = new Shain();
	        shain.setName(name);
	        shain.setGender(gender);
	        shain.setNote(note);

	        shainDAO.save(shain);

	        resp.sendRedirect(req.getContextPath() + "/app/complete");
	    }
	}
}
