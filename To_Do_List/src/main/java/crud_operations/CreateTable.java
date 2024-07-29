package crud_operations;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity_classes.Task;

@WebServlet("/todolist")
public class CreateTable extends HttpServlet {

    private EntityManagerFactory emf;

    @Override
    public void init() throws ServletException {
        super.init();
        emf = Persistence.createEntityManagerFactory("To_Do_List");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();

        
        // Data fetching from todolist.jsp
        String taskname = req.getParameter("task");
        String assignee = req.getParameter("assignee");
        String status = req.getParameter("status");

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();


        try {
            
            // Retrieve tasks from the database after persisting
//            List<Task> tasks = em.createQuery("SELECT t FROM Task t", Task.class).getResultList();
//            req.setAttribute("tasks", tasks);

			/* resp.sendRedirect("Todolist.jsp"); */
            et.begin();

            Task task = new Task(taskname, assignee, status);
            em.persist(task);

            et.commit();

            RequestDispatcher rd = req.getRequestDispatcher("viewdata");
            rd.forward(req, resp);

        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
                
            }
            e.printStackTrace();
            pw.println("Error: " + e.getMessage());
        } finally {
            em.close();
           
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
	
	/*
	 * @Override protected void doGet(HttpServletRequest req, HttpServletResponse
	 * resp) throws ServletException, IOException { // TODO Auto-generated method
	 * stub doPost(req, resp); }
	 */
	 
	 
}
