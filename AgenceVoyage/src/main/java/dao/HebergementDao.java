package dao;

import java.util.List;

import org.hibernate.Session;

import beans.Transport;

public class HebergementDao {
	private static Session session = HibernateUtil.getSessionFactory().openSession();

	public List<Transport> listHebergements() {
		return	session.createQuery("from Hebergement").list();
		
	}
}
