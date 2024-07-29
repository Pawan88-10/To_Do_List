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

@WebServlet("/edit")
public class EditTask extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get PrintWriter for writing responses
        PrintWriter pw = resp.getWriter();

        // Get task details from request parameters
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("task");
        String assignee = req.getParameter("assignee");
        String status = req.getParameter("status");

        // Create EntityManagerFactory and EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("To_Do_List");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        // Find the task with the given id
        Task task = em.find(Task.class, id);

        // If task with given id exists, update its details
        if (task != null) {
            et.begin();
            // Update task details
            task.setName(name);
            task.setAssignee(assignee);
            task.setStatus(status);
            em.merge(task); // Persist changes to the database
            et.commit();

            // Retrieve tasks from the database after persisting
            List<Task> tasks = em.createQuery("SELECT t FROM Task t", Task.class).getResultList();
            req.setAttribute("tasks", tasks);

			/* resp.sendRedirect("Todolist.jsp"); */
            RequestDispatcher rd = req.getRequestDispatcher("Todolist.jsp");
            rd.forward(req, resp);

        } else {
            // If task with given id doesn't exist
            pw.println("Task with ID " + id + " not found.");
        }

        // Close EntityManager and EntityManagerFactory
        em.close();
        emf.close();
    }
}
