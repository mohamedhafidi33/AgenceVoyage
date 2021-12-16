package dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import beans.Client;
import beans.User;
import beans.Voyage;

public class UserDao {
private static Session session = HibernateUtil.getSessionFactory().openSession();
	
	public void saveUser(User u) {
		session.beginTransaction();
		session.save(u);
		session.getTransaction().commit();
	}
	
	public void updateUser(User u) {
		session.beginTransaction();
		session.update(u);
		session.getTransaction().commit();
	}
	
	public void deleteUser(int id) {
		User u = getUser(id);
		session.beginTransaction();
		session.delete(u);
		session.getTransaction().commit();
	}
	public int getId(User u) {
		Query req = session.createQuery("select u from User u where u.username like :x and u.password like :y");
		req.setParameter("x",u.getUsername());
		req.setParameter("y",u.getPassword());
		List<User> users=req.getResultList();
		return users.get(0).getId();
	}
	
	public User getUser(int id) {
		User u = session.find(User.class, id);
		if(u==null)throw new RuntimeException("introuvable");
		return u ;
	}
	
	public String getPassword(User u) {
		Query req = session.createQuery("select u from User u where u.username like :x");
		req.setParameter("x",u.getUsername());
		List<User> users=req.getResultList();
		String nul="null";
		if(users.isEmpty()==true) {return nul;}
		else {
		return users.get(0).getPassword();}
	}
	public boolean isExist(User u) {
		Query req = session.createQuery("select u from User u where u.username like :x");
		req.setParameter("x",u.getUsername());
		List<User> users=req.getResultList();
		String nul="null";
		return users.isEmpty();
	}
}
