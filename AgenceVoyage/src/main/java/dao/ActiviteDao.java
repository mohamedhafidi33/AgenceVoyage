package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import beans.Activite;
import beans.Client;
import beans.Transport;
import beans.Voyage;

public class ActiviteDao {
	private static Session session = HibernateUtil.getSessionFactory().openSession();
	
	public void saveActivite(Activite a) {
		session.beginTransaction();
		session.save(a);
		session.getTransaction().commit();
	}

	public List<Activite> listActivites() {
		return	session.createQuery("from Activite").list();
		
	}
	public List<Activite> activitesByVoyage(Voyage v){
		Query req = session.createQuery("select a from Activite a where a.voyage like :x");
		req.setParameter("x",v);
		List<Activite> activites=req.getResultList();
		return activites;
	}
	
}
