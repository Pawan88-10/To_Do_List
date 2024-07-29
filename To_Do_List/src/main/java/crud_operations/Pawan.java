package crud_operations;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.PublicKey;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

import entity_classes.Task;

@WebServlet("/pawan")
public class Pawan extends HttpServlet{
	EntityManagerFactory emf ;
	EntityManager em;
	EntityTransaction et ;
	
	{
		emf = Persistence.createEntityManagerFactory("To_Do_List");
		em = emf.createEntityManager();
		et = em.getTransaction();
	}
	boolean removeToDo(int id) {
		et.begin();
      
      
      // Find the task entity by ID
      Task task = em.find(Task.class, id);
      System.out.println(task);
      // Check if the task exists
      if (task != null) {
          em.remove(task);
          et.commit();
         return true;
//          pw.println("Task with ID " + id + " has been deleted successfully.");
      } 
      return false;
		
	}
	List<Task>viewData(){
		 List<Task> data = em.createQuery("SELECT t FROM Task t", Task.class).getResultList();
//         req.setAttribute("tasks", tasks);
		 System.out.println(data);
		 return data;
	}
	
	
		
		
	
	
	
}
