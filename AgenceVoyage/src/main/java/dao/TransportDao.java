package dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import beans.Activite;
import beans.Client;
import beans.Hebergement;
import beans.Transport;
import beans.Voyage;

public class TransportDao {
	private static Session session = HibernateUtil.getSessionFactory().openSession();

	public void saveTransport(Transport t) {
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
	}
	
	public List<Transport> listTransports() {
		return	session.createQuery("from Transport").list();
		
	}
	public List<Transport> transportsByVoyage(Voyage v){
		Query req = session.createQuery("select t from Transport t where t.voyage like :x");
		req.setParameter("x",v);
		List<Transport> transports=req.getResultList();
		return transports;
	}
}
