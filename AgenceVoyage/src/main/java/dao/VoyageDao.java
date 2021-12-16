package dao;

import java.sql.Date;
import java.util.List;

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
	
	public void updateVoyage(Voyage v) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(v);
		session.getTransaction().commit();
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
	public int countVoyage() {
		Query req = session.createQuery("SELECT COUNT(*) FROM Voyage\r\n"
				+ "");
		return Integer.parseInt(req.getResultList().get(0).toString());
	}
}

