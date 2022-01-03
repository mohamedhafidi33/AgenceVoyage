package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.activation.DataSource;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import beans.Client;
import beans.User;
import dao.HibernateUtil;

/**
 * Servlet implementation class UsernameAvailability
 */
@WebServlet(name="UsernameAvailability", urlPatterns = {"/UsernameAvailability"})
public class UsernameAvailability extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DataSource dataSource;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsernameAvailability() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query req = session.createQuery("select u from User u where u.username like :x");
		req.setParameter("x",request.getParameter("myuser"));
		List<User> users=req.getResultList();
		if(!users.isEmpty()) {
			System.out.println("already exist");
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.print("already exists");
		}else {
			System.out.println("Validé");
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.print("Validé");
		}
	}

}
