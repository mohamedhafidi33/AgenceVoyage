package dao;

import java.util.List;

import org.hibernate.Session;

import beans.Client;
import beans.Transport;

public class TransportDao {
	private static Session session = HibernateUtil.getSessionFactory().openSession();

	public List<Transport> listTransports() {
		return	session.createQuery("from Transport").list();
		
	}
}
