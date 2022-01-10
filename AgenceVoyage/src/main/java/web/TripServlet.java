package web;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import beans.Hebergement;
import beans.Reservation;
import beans.Theme;
import beans.Transport;
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
												
@WebServlet(urlPatterns = {"/addVoyagePage","/annulerReservation","/displayImage","/panier","/cancelReservation","/detailVoyage","/listReservations","/reserverVoyage","/chercher","/listVoyages","/addVoyage","/updateVoyagePage","/deleteVoyage","/editVoyage","/editVoyagePage"})
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session= request.getSession();
		if(request.getServletPath().equals("/addVoyagePage")) {
			//request.setAttribute("transports",transportDao.listTransports());
			//request.setAttribute("activites",activiteDao.listActivites());
			//request.setAttribute("hebergements",hebergementDao.listHebergements());
			request.getRequestDispatcher("/addVoyage.jsp").forward(request, response);
		}
		
		if(request.getServletPath().equals("/updateVoyagePage")) {
			request.setAttribute("voyages",voyageDao.listVoyages());
			request.getRequestDispatcher("/updateVoyage.jsp").forward(request, response);
		}
		if(request.getServletPath().equals("/panier")) {
			List<Reservation> clientReservations= reservationDao.reservationsByClient((Client)session.getAttribute("client"));
			double amount=0;
			for(Reservation reservation:clientReservations) {
			amount+=voyageDao.getVoyage(reservation.getVoyage().getId()).getPrix();
			System.out.println("somme "+amount);
			}
			request.setAttribute("amount",amount );
			request.setAttribute("reservations",clientReservations );
			request.getRequestDispatcher("/panier.jsp").forward(request, response);
		}
		if(request.getServletPath().equals("/cancelReservation")) {
			reservationDao.deleteReservation(Integer.parseInt(request.getParameter("id").trim()));
			response.sendRedirect("/AgenceVoyage/listReservations");
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
			request.setAttribute("hebergements", hebergementDao.hebergementsByVoyage(voyageDao.getVoyage(Integer.parseInt(request.getParameter("id").trim()))).get(0));
			request.setAttribute("activites", activiteDao.activitesByVoyage(voyageDao.getVoyage(Integer.parseInt(request.getParameter("id").trim()))));
			request.setAttribute("transports", transportDao.transportsByVoyage(voyageDao.getVoyage(Integer.parseInt(request.getParameter("id").trim()))));
			request.setAttribute("voyage", voyageDao.getVoyage(Integer.parseInt(request.getParameter("id").trim())));
			request.getRequestDispatcher("/details.jsp").forward(request, response);
		}
		if(request.getServletPath().equals("/reserverVoyage")){
			
			
			Reservation reservation = new Reservation();
			reservation.setClient((Client)session.getAttribute("client"));
			reservation.setVoyage(voyageDao.getVoyage(Integer.parseInt(request.getParameter("id").trim())));
			long millis=System.currentTimeMillis();  
	        java.sql.Date date=new java.sql.Date(millis);  
			reservation.setDateReservation(date);
			reservationDao.saveReservation(reservation);
			response.sendRedirect("/AgenceVoyage/panier");
		}
		if(request.getServletPath().equals("/listReservations")) {
			
			request.setAttribute("reservations",reservationDao.listReservationss());
			request.getRequestDispatcher("/reservations.jsp").forward(request, response);
		}
		if(request.getServletPath().equals("/listVoyages")) {
			List<Voyage> voyages=voyageDao.listVoyages();
			if(voyageDao.listVoyages().size()>=4) {
				for(int i=0;i<4;i++) {voyages.add(voyageDao.listVoyages().get(i));}
				request.setAttribute("PopVoyages",voyages);}
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
			
			//System.out.println((Voyage)request.getAttribute("voyages"));
			request.getRequestDispatcher("/voyagesList.jsp").forward(request, response);
		}
		if(request.getServletPath().equals("/displayImage")) {
			Blob image=voyageDao.getVoyage(Integer.parseInt(request.getParameter("id").trim())).getImage();
			System.out.println("hellooooo"+Integer.parseInt(request.getParameter("id").trim()));
			byte[] byteArray = null;
			try {
				byteArray=image.getBytes(1, (int) image.length());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.setContentType("image/gif");
			OutputStream os=response.getOutputStream();
			os.write(byteArray);
			os.flush();
			os.close();
			
		}									
		if(request.getServletPath().equals("/annulerReservation")) {
			reservationDao.deleteReservation((Integer.parseInt(request.getParameter("id").trim())));
			response.sendRedirect("/AgenceVoyage/panier");
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
			voyage.setDescription(request.getParameter("description"));
			voyage.setDifficulte(Difficulte.valueOf(request.getParameter("difficulte")));
			voyage.setDure(Dure.valueOf(request.getParameter("duree")));
			voyage.setTheme(Theme.valueOf(request.getParameter("theme")));
			voyage.setNom(request.getParameter("nom"));
			voyage.setDepart(request.getParameter("depart"));
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
			
			voyageDao.saveVoyage(voyage);
			//int idVoyage=voyage.getId();

			System.out.println("first id"+voyage.getId());
			List<Activite> activites=new ArrayList<Activite>();
			String[] list1=request.getParameterValues("activite");
			if(list1!=null) {
			for (String i:list1) {
				Activite activite=new Activite();
					activite.setNom(i);
					activite.setVoyage(voyage);
					activites.add(activite);
			}
			voyage.setActivites(activites);
			for(Activite activite:activites) {
			activiteDao.saveActivite(activite);}
			}
			//=================+++++++++++++++++++++++++++++++++++++++++++======================================//
			//voyage=voyageDao.getVoyage(idVoyage);
			System.out.println("second id"+voyage.getId());
			List<Hebergement> hebergements=new ArrayList<Hebergement>();
			String[] list3=request.getParameterValues("hebergement");
			if(list3!=null) {
			for (String i:list3) {
				Hebergement hebergement=new Hebergement();
					hebergement.setNom(i);
					hebergement.setVoyage(voyage);
					hebergements.add(hebergement);
			}
			voyage.setHebergements(hebergements);
			for(Hebergement hebergement:hebergements) {
				hebergementDao.saveHeberement(hebergement);}
			}
			//=================+++++++++++++++++++++++++++++++++++++++++++======================================//
			//voyage=voyageDao.getVoyage(idVoyage);

			System.out.println("third id"+voyage.getId());
			List<Transport> transports=new ArrayList<Transport>();
			String[] list2=request.getParameterValues("transport");
			if(list2!=null) {
			for (String i:list2) {
				Transport transport=new Transport();
					transport.setNom(i);
					transport.setVoyage(voyage);
					transports.add(transport);
			}
			voyage.setTransports(transports);
			for(Transport transport:transports) {
			transportDao.saveTransport(transport);}
			}
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
			if(!request.getParameter("destination").equals("-")){
				voyages.addAll(voyageDao.getVoyageByDestination(request.getParameter("destination")));
			}
			if(!request.getParameter("theme").equals("-")){
				voyages.addAll(voyageDao.getVoyageByTheme(Theme.valueOf(request.getParameter("theme"))));
			}
			if(!request.getParameter("date").equals("")){
				System.out.println("date"+request.getParameter("date"));
				voyages.addAll(voyageDao.getVoyageByDate(Date.valueOf(request.getParameter("date"))));
			}
			if(!request.getParameter("confort").equals("-")){
				voyages.addAll(voyageDao.getVoyageByConfort(Confort.valueOf(request.getParameter("confort"))));
			}
			if(!request.getParameter("dure").equals("-")){
				voyages.addAll(voyageDao.getVoyageByDure(Dure.valueOf(request.getParameter("dure"))));
			}
			if(!request.getParameter("difficulte").equals("-")){
				voyages.addAll(voyageDao.getVoyageByDifficulte(Difficulte.valueOf(request.getParameter("difficulte"))));
			}
			if(!request.getParameter("prix").equals("-")){
				if(request.getParameter("prix").equals("1")) {
					voyages.addAll(voyageDao.getVoyageByPrix(1000,2500));
				}else
				if(request.getParameter("prix").equals("2")) {
					voyages.addAll(voyageDao.getVoyageByPrix(2500,4000));
				}else
				if(request.getParameter("prix").equals("3")) {
					voyages.addAll(voyageDao.getVoyageByPrix(4000,6000));
				}else
				if(request.getParameter("prix").equals("4")) {
					voyages.addAll(voyageDao.getVoyageByPrix(6000,8000));
				}
				
				
			}
			List<Voyage> finalList=removeDuplicates(voyages);
			if(finalList.isEmpty()) {
				request.setAttribute("NoTrip","Il n'y a aucun voyage avec ces critères");
			}
			request.setAttribute("voyages",finalList);
			request.getRequestDispatcher("/voyagesList.jsp").forward(request, response);
			
		}
		
	}
	// Function to remove duplicates from an ArrayList
    public static <T> List<T> removeDuplicates(List<T> list)
    {
  
        // Create a new ArrayList
        List<T> newList = new ArrayList<T>();
  
        // Traverse through the first list
        for (T element : list) {
  
            // If this element is not present in newList
            // then add it
            if (!newList.contains(element)) {
  
                newList.add(element);
            }
        }
  
        // return the new list
        return newList;
    }
}
