package presentation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.Todo;
import business.DefaultServices;
import business.Services;

@WebServlet("/list")
public class ListTodoServlet extends HttpServlet{

	private Services services;
	@Override
	public void init() throws ServletException {
		services=DefaultServices.getInstance();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		setUpCross(resp);
		List<Todo> todos=services.getAll();
		Gson gson=new Gson();
		String str=gson.toJson(todos);
		PrintWriter writer= resp.getWriter();
		
		writer.append(str);
	}
	private void setUpCross(HttpServletResponse resp) {
		resp.addHeader("Access-Control-Allow-Origin", "*");
		resp.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		resp.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
		resp.addHeader("Access-Control-Max-Age", "1728000");
	}
}
