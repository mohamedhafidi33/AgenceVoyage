package dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.ArrayList;

import java.util.List;

import org.hibernate.Session;

import beans.Activite;
import beans.Client;
import beans.Confort;
import beans.Difficulte;
import beans.Hebergement;
import beans.Role;
import beans.Theme;
import beans.TypeVoyage;
import beans.User;
import beans.Voyage;


public class TestConnexion {
	
    
    public static void main(String[] args) 
    {
//    	ClientDao clientService=new ClientDao();
    	VoyageDao voyageDao=new VoyageDao();
//    	UserDao usrdao=new UserDao();
//    	ReservationDao dao=new ReservationDao();
    	 Session session = HibernateUtil.getSessionFactory().openSession();
         session.beginTransaction();
//         Voyage voyage = new Voyage();
//         Client client = new Client();
//         Activite ac=new Activite();
//         List<Activite> actvs=new ArrayList<Activite>();
         //client.setNom("mohamed");
         //client.setEmail("hafidi@gmail.com");
         //User user=new User();
         //user.setUsername("hafidi123");
        // user.setPassword("salam");
         //user.setRole(Role.client);
         //user.setId(1);
         //Activite activite=new Activite();
//        client.setId(1);
//        voyage.setId(1);
//        dao.saveReservation(client, voyage);
//         ac.setNom("Vélo");
//         Activite ac1=new Activite();
//         ac.setId(8);
//         ac1.setId(3);
//         actvs.add(ac1);
//         actvs.add(ac);
//         ac1.setVoyage(voyage);
//         voyage.setActivites(actvs);
//         ac.setVoyage(voyage);
//         List<Hebergement> hebergements=new ArrayList<Hebergement>();
//         Hebergement hebergement =new Hebergement();
//         hebergement.setId(1);
//         hebergement.setNom("hotel");
//         hebergements.add(hebergement);
//         hebergement.setVoyage(voyage);
//         voyage.setHebergements(hebergements);
        // voyageDao.deleteExpiredVoyages();
        System.out.println(voyageDao.getVoyageByPrix(100, 300).get(0).getDateDepart());
         //clientService.saveClient(client);
         //usrdao.updateUser(user);
         //clientService.deleteClient(1);
         // Save Account
         //session.save(client);
//  
         session.getTransaction().commit();
         HibernateUtil.shutdown();
//    	 String passwordToHash = "admin";
//    	    String generatedPassword = null;

//    	    try 
//    	    {
//    	      // Create MessageDigest instance for MD5
//    	      MessageDigest md = MessageDigest.getInstance("MD5");
//
//    	      // Add password bytes to digest
//    	      md.update(passwordToHash.getBytes());
//
//    	      // Get the hash's bytes
//    	      byte[] bytes = md.digest();
//
//    	      // This bytes[] has bytes in decimal format. Convert it to hexadecimal format
//    	      StringBuilder sb = new StringBuilder();
//    	      for (int i = 0; i < bytes.length; i++) {
//    	        sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
//    	      }
//
//    	      // Get complete hashed password in hex format
//    	      generatedPassword = sb.toString();
//    	    } catch (NoSuchAlgorithmException e) {
//    	      e.printStackTrace();
//    	    }
//    	    System.out.println(generatedPassword);
   	  }
    }
