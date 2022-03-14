package presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.DefaultServices;

/**
 * Servlet implementation class DeleteTodoServlet
 */
@WebServlet("/delete")
@MultipartConfig

public class DeleteTodoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		setUpCross(response);
		String nom = request.getParameter("nom");

		if (DefaultServices.getInstance().delete(nom) == null) {
			response.getWriter().append("0");
		} else {
			response.getWriter().append("1");
		}
	}

	

	private void setUpCross(HttpServletResponse resp) {
		resp.addHeader("Access-Control-Allow-Origin", "*");
		resp.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		resp.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
		resp.addHeader("Access-Control-Max-Age", "1728000");
	}
}
