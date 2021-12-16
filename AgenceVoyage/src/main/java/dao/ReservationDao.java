package dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import beans.Client;
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
	public int countReservationByClient(Client client) {
		Query req = session.createQuery("SELECT COUNT(*) FROM Reservation r where r.client like :x ");
		req.setParameter("x",client);
		return Integer.parseInt(req.getResultList().get(0).toString());
	}
}
