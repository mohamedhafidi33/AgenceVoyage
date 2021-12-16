package dao;

import java.util.List;

import org.hibernate.Session;

import beans.Activite;
import beans.Transport;

public class ActiviteDao {
	private static Session session = HibernateUtil.getSessionFactory().openSession();

	public List<Activite> listActivites() {
		return	session.createQuery("from Activite").list();
		
	}
}
