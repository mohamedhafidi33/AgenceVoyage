package dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;

import beans.Client;
import beans.User;

public class ClientDao  {

private static Session session = HibernateUtil.getSessionFactory().openSession();
	
	public void saveClient(Client c) {
		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();
	}
	
	@Transactional
	public List<Client> listClients() {
		return	session.createQuery("from Client").list();
		
	}
	
	public Client getClient(int id) {
		Client c = session.find(Client.class, id);
		if(c==null)throw new RuntimeException("Produit introuvable");
		return c ;
	}
	public Client getClientByUser(User user) {
		Query req = session.createQuery("select c from Client c where c.user.id like :x");
		req.setParameter("x",user.getId());
		List<Client> clients=req.getResultList();
		return clients.get(0);
	}
	public void deleteClient(int id) {
		Client c = getClient(id);
		session.beginTransaction();
		session.delete(c);
		session.getTransaction().commit();
	}
	
	public void updateClient(Client c) {
		session.beginTransaction();
		session.update(c);
		session.getTransaction().commit();
	}
	public int countClients() {
		Query req = session.createQuery("SELECT COUNT(*) FROM Client\r\n"
				+ "");
		return Integer.parseInt(req.getResultList().get(0).toString());
	}

}
