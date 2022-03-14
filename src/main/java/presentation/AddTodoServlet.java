package presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Todo;
import business.DefaultServices;
import business.Services;

@WebServlet("/add")
@MultipartConfig
public class AddTodoServlet extends HttpServlet{
	private Services services;
	@Override
	public void init() throws ServletException {
		services=DefaultServices.getInstance();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		setUpCross(resp);
	
		String nom=req.getParameter("name");
		String desc=req.getParameter("desc");
		System.out.println(nom+desc);
		Todo todo=new Todo(nom, desc);
		if(services.add(todo)==null)
		resp.getWriter().append("0");
		else
		resp.getWriter().append("1");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	private void setUpCross(HttpServletResponse resp) {
		resp.addHeader("Access-Control-Allow-Origin", "*");
		resp.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		resp.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
		resp.addHeader("Access-Control-Max-Age", "1728000");
	}
}
