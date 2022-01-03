package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import beans.Activite;
import beans.Client;
import beans.Transport;

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
	
}
