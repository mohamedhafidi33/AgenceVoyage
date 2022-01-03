package dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import beans.Client;
import beans.Reservation;
import beans.Reservation;
import beans.Reservation;

public class ReservationDao {
private static Session session = HibernateUtil.getSessionFactory().openSession();
	
	public void saveReservation(Reservation reservation) {
		session.beginTransaction();
		session.save(reservation);
		session.getTransaction().commit();
	}
	public List<Reservation> reservationsByClient(Client client) {
		Query req = session.createQuery("select r from Reservation r where r.client like :x");
		req.setParameter("x",client);
		List<Reservation> reservations=req.getResultList();
		return reservations;
}
	public Reservation getReservation(int id) {
		Reservation v = session.find(Reservation.class, id);
		if(v==null)throw new RuntimeException("Reservation introuvable");
		return v ;
	}
	public void deleteReservation(int id) {
		Reservation r = getReservation(id);
		session.beginTransaction();
		session.delete(r);
		session.getTransaction().commit();
	}
	public int countReservationByClient(Client client) {
		Query req = session.createQuery("SELECT COUNT(*) FROM Reservation r where r.client like :x ");
		req.setParameter("x",client);
		return Integer.parseInt(req.getResultList().get(0).toString());
	}
	public List<Reservation> listReservationss() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return	session.createQuery("from Reservation").list();
		
	}
	public int countReservation() {
		Query req = session.createQuery("SELECT COUNT(*) FROM Reservation\r\n"
				+ "");
		return Integer.parseInt(req.getResultList().get(0).toString());
	}
}
