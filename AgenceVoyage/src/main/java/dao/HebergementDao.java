package dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import beans.Activite;
import beans.Client;
import beans.Hebergement;
import beans.Transport;

public class HebergementDao {
	private static Session session = HibernateUtil.getSessionFactory().openSession();

	public void saveHeberement(Hebergement h) {
		session.beginTransaction();
		session.save(h);
		session.getTransaction().commit();
	}
	
	public List<Hebergement> listHebergements() {
		return	session.createQuery("from Hebergement").list();
		
	}
	public Hebergement getHebergementByName(String nom) {
		Query req = session.createQuery("select h from Hebergement h where h.nom like :x");
		req.setParameter("x",nom);
		List<Hebergement> hebergements=req.getResultList();
		return hebergements.get(0);
	}
}
