package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CompleteController implements Controller {
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {

	    String method = req.getMethod();

	    if ("GET".equalsIgnoreCase(method)) {
	        req.getRequestDispatcher("/WEB-INF/complete.jsp").forward(req, resp);

	    }
	}
}
