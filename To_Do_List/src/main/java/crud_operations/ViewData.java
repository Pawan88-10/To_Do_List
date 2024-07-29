package crud_operations;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity_classes.Task;

@WebServlet("/viewdata")
public class ViewData extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Pawan p = new Pawan();
		
		PrintWriter pw = resp.getWriter();
		List<Task> tasks = p.viewData();
		pw.print("hello");
		
		RequestDispatcher success = req.getRequestDispatcher("Todolist.jsp");
		if(tasks != null) {
			 req.setAttribute("tasks", tasks);
			success.forward(req, resp);
		}
		
		 
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
