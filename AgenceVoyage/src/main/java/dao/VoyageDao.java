package dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;

import beans.Confort;
import beans.Difficulte;
import beans.Dure;
import beans.Theme;
import beans.TypeVoyage;
import beans.Voyage;

public class VoyageDao {
	private static Session session = HibernateUtil.getSessionFactory().openSession();
	public void saveVoyage(Voyage v) {
		session.beginTransaction();
		session.save(v);
		session.getTransaction().commit();
	}
	
	
	public List<Voyage> listVoyages() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return	session.createQuery("from Voyage").list();
		
	}
	
	public Voyage getVoyage(int id) {
		Voyage v = session.find(Voyage.class, id);
		if(v==null)throw new RuntimeException("Voyage introuvable");
		return v ;
	}
	
	public void deleteVoyage(int id) {
		Voyage v = getVoyage(id);
		session.beginTransaction();
		session.delete(v);
		session.getTransaction().commit();
	}
	
	public void deleteExpiredVoyages() {
		List<Voyage> listVoyages=listVoyages();
		for(Voyage item:listVoyages) {
			if(item.getDateDepart().before(new java.sql.Date(System.currentTimeMillis()))) {
				deleteVoyage(item.getId());
			}
		}
	}
	
	public void updateVoyage(Voyage v) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(v);
		session.getTransaction().commit();
	}
	public List<Voyage> getTwoRandomVoyages(){
		  Random rand = new Random();
		  System.out.println(listVoyages().get(listVoyages().size()-1).getId());
	      int random1 = ThreadLocalRandom.current().nextInt(listVoyages().get(0).getId(), listVoyages().get(listVoyages().size()-1).getId());
	      int random2 = ThreadLocalRandom.current().nextInt(listVoyages().get(0).getId(), listVoyages().get(listVoyages().size()-1).getId());
	      System.out.println(random1);
	      
	      
	      List<Voyage> voyages=new ArrayList<Voyage>();
	      voyages.add(getVoyage(random1));
	      voyages.add(getVoyage(random2));
	      return voyages;
	}
	public List<Voyage> getVoyageByDestination(String dest) {
		Query req = session.createQuery("select v from Voyage v where v.destination like :x");
		req.setParameter("x",dest);
		List<Voyage> voyages=req.getResultList();
		return voyages;
	}
	public List<Voyage> getVoyageByDate(Date date) {
		Query req = session.createQuery("select v from Voyage v where v.dateDepart like :x");
		req.setParameter("x",date);
		List<Voyage> voyages=req.getResultList();
		return voyages;
	}
	
	public List<Voyage> getVoyageByType(TypeVoyage type) {
		Query req = session.createQuery("select v from Voyage v where v.typeVoyage like :x");
		req.setParameter("x",type);
		List<Voyage> voyages=req.getResultList();
		return voyages;
	}
	public List<Voyage> getVoyageByConfort(Confort conf) {
		Query req = session.createQuery("select v from Voyage v where v.confort like :x");
		req.setParameter("x",conf);
		List<Voyage> voyages=req.getResultList();
		return voyages;
	}
	
	public List<Voyage> getVoyageByDifficulte(Difficulte dif) {
		Query req = session.createQuery("select v from Voyage v where v.difficulte like :x");
		req.setParameter("x",dif);
		List<Voyage> voyages=req.getResultList();
		return voyages;
	}
	
	public List<Voyage> getVoyageByDure(Dure dure) {
		Query req = session.createQuery("select v from Voyage v where v.dure like :x");
		req.setParameter("x",dure);
		List<Voyage> voyages=req.getResultList();
		return voyages;
	}
	
	public List<Voyage> getVoyageByTheme(Theme theme) {
		Query req = session.createQuery("select v from Voyage v where v.theme like :x");
		req.setParameter("x",theme);
		List<Voyage> voyages=req.getResultList();
		return voyages;
	}
	public List<Voyage> getVoyageByPrix(double min,double max) {
		Query req = session.createQuery("select v from Voyage v where v.prix between :x and :y");
		req.setParameter("x",min);
		req.setParameter("y", max);
		List<Voyage> voyages=req.getResultList();
		return voyages;
	}
	public int countVoyage() {
		Query req = session.createQuery("SELECT COUNT(*) FROM Voyage\r\n"
				+ "");
		return Integer.parseInt(req.getResultList().get(0).toString());
	}
}

