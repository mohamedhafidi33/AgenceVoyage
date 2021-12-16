package web;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Client;
import beans.Role;
import beans.User;
import dao.ClientDao;
import dao.ReservationDao;
import dao.UserDao;
import dao.VoyageDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = { "/loginPage","/login","/HomeAdmin","/logout","/registerPage","/register","/HomeClient" })
public class LoginServlet extends HttpServlet {
	
	private UserDao userDao = new UserDao();
	private ClientDao clientDao = new ClientDao();
	private VoyageDao voyageDao = new VoyageDao(); 
	ReservationDao reservationDao = new ReservationDao();
	
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		if (request.getServletPath().equals("/loginPage")) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		if (request.getServletPath().equals("/registerPage")) {
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
		if (request.getServletPath().equals("/HomeClient")) {
			
			request.getRequestDispatcher("/homeClient.jsp").forward(request, response);
		}
if (request.getServletPath().equals("/HomeAdmin")) {
			
			request.getRequestDispatcher("/homeAdmin.jsp").forward(request, response);
		}
if (request.getServletPath().equals("/logout")) {
	HttpSession session= request.getSession();
	System.out.println("looooginout");
	session.removeAttribute("admin");
	session.removeAttribute("client");
	session.invalidate();
	System.out.println(99);
	request.getRequestDispatcher("/login.jsp").forward(request, response);
}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		HttpSession session= request.getSession();
		session.setMaxInactiveInterval(3600);
		
		
		
		
		
		if (request.getServletPath().equals("/login")) {
			
			
			
			User user=new User();
			user.setUsername(request.getParameter("username"));
			
			if(userDao.isExist(user)==false) {
				if(userDao.getPassword(user).equals(request.getParameter("password"))) {
					user.setPassword(request.getParameter("password"));
					user.setRole(userDao.getUser(userDao.getId(user)).getRole());
					if(user.getRole().equals(Role.admin)) {
						request.setAttribute("countVoyages",voyageDao.countVoyage());
						request.setAttribute("countClients",clientDao.countClients());
						session.setAttribute("admin", user);
						request.getRequestDispatcher("/homeAdmin.jsp").forward(request, response);
					}
					if(user.getRole().equals(Role.client)) {
						user.setId(userDao.getId(user));
						session.setAttribute("client", clientDao.getClientByUser(user));
						request.setAttribute("count", reservationDao.countReservationByClient(clientDao.getClientByUser(user)));
						response.sendRedirect("/AgenceVoyage/HomeClient");
					}
				}
				else
					if(!userDao.getPassword(user).equals(request.getParameter("password"))) {
						String wrong ="mot de passe incorrect réssayer!";
						request.setAttribute("wrong", wrong);
						System.out.println(wrong);
						request.getRequestDispatcher("/login.jsp").forward(request, response);
					}}
			else {
				System.out.println("makaynch f bd");
				String notExist="ce compte n'existe pas. Veuillez creér un";
				request.setAttribute("notExist", notExist);
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			}
			
			//request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		if (request.getServletPath().equals("/register")) {
			Client client=new Client();
			User user=new User();
			client.setDateNaissance(Date.valueOf(request.getParameter("dateNaissance")));
			client.setEmail(request.getParameter("email"));
			client.setNom(request.getParameter("nom"));
			client.setPrenom(request.getParameter("prenom"));
			client.setPays(request.getParameter("pays"));
			client.setTelephone(request.getParameter("telephone"));
			user.setUsername(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));
			user.setRole(Role.client);
			userDao.saveUser(user);
			client.setUser(user);
			clientDao.saveClient(client);
			response.sendRedirect("/AgenceVoyage/loginPage");
			
		}
		
	}

}
