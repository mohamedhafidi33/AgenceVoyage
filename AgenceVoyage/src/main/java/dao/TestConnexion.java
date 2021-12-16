package dao;

import java.sql.Date;
import java.util.ArrayList;

import java.util.List;

import org.hibernate.Session;

import beans.Activite;
import beans.Client;
import beans.Confort;
import beans.Difficulte;
import beans.Role;
import beans.Theme;
import beans.TypeVoyage;
import beans.User;
import beans.Voyage;


public class TestConnexion {
	
    
    public static void main(String[] args) 
    {
    	ClientDao clientService=new ClientDao();
    	VoyageDao voyageDao=new VoyageDao();
    	UserDao usrdao=new UserDao();
    	ReservationDao dao=new ReservationDao();
    	 Session session = HibernateUtil.getSessionFactory().openSession();
         session.beginTransaction();
         Voyage voyage = new Voyage();
         Client client = new Client();
         //client.setNom("mohamed");
         //client.setEmail("hafidi@gmail.com");
         //User user=new User();
         //user.setUsername("hafidi123");
        // user.setPassword("salam");
         //user.setRole(Role.client);
         //user.setId(1);
         //Activite activite=new Activite();
        client.setId(1);
        voyage.setId(1);
        dao.saveReservation(client, voyage);
        // System.out.println(voyageDao.countVoyage());
        
         //clientService.saveClient(client);
         //usrdao.updateUser(user);
         //clientService.deleteClient(1);
         // Save Account
         //session.save(client);
  
         session.getTransaction().commit();
         HibernateUtil.shutdown();
    }
}
