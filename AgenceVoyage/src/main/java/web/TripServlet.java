package web;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.hibernate.Session;

import beans.Activite;
import beans.Client;
import beans.Confort;
import beans.Difficulte;
import beans.Dure;
import beans.Reservation;
import beans.Theme;
import beans.TypeVoyage;
import beans.Voyage;
import dao.ActiviteDao;
import dao.HebergementDao;
import dao.HibernateUtil;
import dao.ReservationDao;
import dao.TransportDao;
import dao.VoyageDao;

/**
 * Servlet implementation class TripServlet
 */

@WebServlet(urlPatterns = {"/addVoyagePage","/panier","/detailVoyage","/reserverVoyage","/chercher","/listVoyages","/addVoyage","/updateVoyagePage","/deleteVoyage","/editVoyage","/editVoyagePage"})
@MultipartConfig(maxRequestSize=1024*1024*5*5)
public class TripServlet extends HttpServlet {
	
	private TransportDao transportDao=new TransportDao();
	private VoyageDao voyageDao=new VoyageDao();
	private ActiviteDao activiteDao=new ActiviteDao();
	private HebergementDao hebergementDao=new HebergementDao();
	ReservationDao reservationDao = new ReservationDao();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TripServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session= request.getSession();
		if(request.getServletPath().equals("/addVoyagePage")) {
			request.setAttribute("transports",transportDao.listTransports());
			request.setAttribute("activites",activiteDao.listActivites());
			request.setAttribute("hebergements",hebergementDao.listHebergements());
			request.getRequestDispatcher("/addVoyage.jsp").forward(request, response);
		}
		
		if(request.getServletPath().equals("/updateVoyagePage")) {
			request.setAttribute("voyages",voyageDao.listVoyages());
			request.getRequestDispatcher("/updateVoyage.jsp").forward(request, response);
		}
		if(request.getServletPath().equals("/panier")) {
			
			request.setAttribute("reservations", reservationDao.reservationsByClient((Client)session.getAttribute("client")));
			request.getRequestDispatcher("/panier.jsp").forward(request, response);
		}
		
		if(request.getServletPath().equals("/deleteVoyage")) {
			voyageDao.deleteVoyage(Integer.parseInt(request.getParameter("id").trim()));
			response.sendRedirect("/AgenceVoyage/updateVoyagePage");
		}
		
		if(request.getServletPath().equals("/editVoyagePage")) {
			System.out.println(voyageDao.getVoyage(Integer.parseInt(request.getParameter("id").trim())).getDescription());
			request.setAttribute("voyage", voyageDao.getVoyage(Integer.parseInt(request.getParameter("id").trim())));
			request.getRequestDispatcher("/editVoyage.jsp").forward(request, response);
		}
		if(request.getServletPath().equals("/detailVoyage")) {
			System.out.println(request.getParameter("id"));
			request.setAttribute("voyage", voyageDao.getVoyage(Integer.parseInt(request.getParameter("id").trim())));
			request.getRequestDispatcher("/details.jsp").forward(request, response);
		}
		if(request.getServletPath().equals("/reserverVoyage")){
			
			
			Reservation reservation = new Reservation();
			reservation.setClient((Client)session.getAttribute("client"));
			reservation.setVoyage(voyageDao.getVoyage(Integer.parseInt(request.getParameter("id").trim())));
			reservationDao.saveReservation(reservation);
			response.sendRedirect("/AgenceVoyage/panier");
		}
		if(request.getServletPath().equals("/listVoyages")) {
			List<Voyage> voyages=voyageDao.listVoyages();
//			
//			Map<Voyage,byte[]> trips=new HashMap<Voyage,byte[]>();
//			for(Voyage voyage:voyages) {
//				try {
//					byte[] b = voyage.getImage().getBytes(1,(int) voyage.getImage().length());
//					trips.put(voyage, b);
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
			request.setAttribute("voyages", voyages);
			//request.setAttribute("trips",trips);
			request.getRequestDispatcher("/voyagesList.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		if(request.getServletPath().equals("/addVoyage")) {
			Voyage voyage=new Voyage();
			voyage.setDescription(request.getParameter("description"));
			voyage.setConfort(Confort.valueOf(request.getParameter("confort")));
			System.out.println(request.getParameter("confort"));
			voyage.setDateDepart(Date.valueOf(request.getParameter("dateDepart")));
			voyage.setDestination(request.getParameter("destination"));
			voyage.setDifficulte(Difficulte.valueOf(request.getParameter("difficulte")));
			voyage.setDure(Dure.valueOf(request.getParameter("duree")));
			voyage.setTheme(Theme.valueOf(request.getParameter("theme")));
			voyage.setNom(request.getParameter("nom"));
			final Part filePart =request.getPart("image");
			if (filePart != null) {
				System.out.println(filePart.getName());
				System.out.println(filePart.getSize());
				System.out.println(filePart.getContentType());}
			Session session = HibernateUtil.getSessionFactory().openSession();
			Blob data = session.getLobHelper().createBlob(filePart.getInputStream(), filePart.getSize());
			voyage.setImage(data);
			voyage.setPrix(Double.parseDouble(request.getParameter("prix")));
			voyage.setTypeVoyage(TypeVoyage.valueOf(request.getParameter("typeVoyage")));
			//List<Activite> activites=new ArrayList<Activite>();
			//request.getParameter("activite");
			//voyage.setActivites();
			//voyage.setActivites(request.getParameter("activite"));
			voyageDao.saveVoyage(voyage);
			response.sendRedirect("/AgenceVoyage/updateVoyagePage");
		}
		
		if(request.getServletPath().equals("/editVoyage")) {
			Voyage voyage=new Voyage();
			voyage.setDescription(request.getParameter("description"));
			voyage.setConfort(Confort.valueOf(request.getParameter("confort")));
			System.out.println(request.getParameter("confort"));
			voyage.setDateDepart(Date.valueOf(request.getParameter("dateDepart")));
			voyage.setDestination(request.getParameter("destination"));
			voyage.setDifficulte(Difficulte.valueOf(request.getParameter("difficulte")));
			voyage.setDure(Dure.valueOf(request.getParameter("duree")));
			voyage.setTheme(Theme.valueOf(request.getParameter("theme")));
			voyage.setNom(request.getParameter("nom"));
			final Part filePart =request.getPart("image");
			if (filePart != null) {
				System.out.println(filePart.getName());
				System.out.println(filePart.getSize());
				System.out.println(filePart.getContentType());}
			Session session = HibernateUtil.getSessionFactory().openSession();
			Blob data = session.getLobHelper().createBlob(filePart.getInputStream(), filePart.getSize());
			voyage.setImage(data);
			voyage.setPrix(Double.parseDouble(request.getParameter("prix")));
			voyage.setTypeVoyage(TypeVoyage.valueOf(request.getParameter("typeVoyage")));
			voyage.setId(Integer.parseInt(request.getParameter("id")));
			voyageDao.updateVoyage(voyage);
			response.sendRedirect("/AgenceVoyage/updateVoyagePage");
		}
		if(request.getServletPath().equals("/chercher")) {
			List <Voyage> voyages=new ArrayList<Voyage>();
			System.out.println("them"+request.getParameter("theme"));
			if(!request.getParameter("theme").equals("0")&&(!request.getParameter("destination").equals("0"))) {
			voyages.addAll(voyageDao.getVoyageByTheme(Theme.valueOf(request.getParameter("theme"))));	
			voyages.addAll(voyageDao.getVoyageByDestination(request.getParameter("destination")));
		}
			for(Voyage voyage:voyages) {
				System.out.println(voyage.getNom());
			}
		}
	}

}
