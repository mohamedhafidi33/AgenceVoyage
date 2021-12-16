package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SendEmail;

/**
 * Servlet implementation class ContactServlet
 */
@WebServlet(urlPatterns = { "/contact" })
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SendEmail sendEmail=new SendEmail();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		if(request.getServletPath().equals("/contact")) {
			sendEmail.sendMail(request.getParameter("email"), request.getParameter("name"),
					request.getParameter("subject"), request.getParameter("text"), request.getParameter("password"));
			
		}
	}

}
