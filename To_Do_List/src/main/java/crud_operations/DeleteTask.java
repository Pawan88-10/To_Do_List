package crud_operations;

import java.io.IOException;
import java.io.PrintWriter;

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

@WebServlet("/delete")
public class DeleteTask extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
//    private EntityManagerFactory emf;
//
//    @Override
//    public void init() throws ServletException {
//        super.init();
//        emf = Persistence.createEntityManagerFactory("To_Do_List");
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter pw = response.getWriter();
        int id = Integer.parseInt(request.getParameter("id"));
//        changes by sagar
     
        Pawan pawan = new Pawan();
        RequestDispatcher successDispatcher = request.getRequestDispatcher("viewdata");
//        pw.println("hello");
        if(pawan.removeToDo(id)) {
        	System.out.println("hi");
        	successDispatcher.forward(request, response);
        }
       
       
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction et = em.getTransaction();
//        
//        try {
//            // Begin transaction
//            et.begin();
//            
//            
//            // Find the task entity by ID
//            Task task = em.find(Task.class, id);
//            
//            // Check if the task exists
//            if (task != null) {
//                em.remove(task);
//                et.commit();
//                RequestDispatcher success = request.getRequestDispatcher("pawan");
//                success.forward(request, response);
////                pw.println("Task with ID " + id + " has been deleted successfully.");
//            } else {
//            	 em.remove(task);
//                 et.commit();
//                pw.println("Task with ID " + id + " does not exist.");
//            }
//        } catch (Exception e) {
//            // Rollback transaction in case of any exception
//            if (et != null && et.isActive()) {
//                et.rollback();
//            }
//            pw.println("Error deleting task with ID " + id + ": " + e.getMessage()+", ");
//            e.printStackTrace();
//        } finally {
//            // Close EntityManager
//            em.close();
//        }
//    }
//    
//    @Override
//    public void destroy() {
//        super.destroy();
//        if (emf != null) {
//            emf.close();
//        }
//    }
        
    }
 
}
