package Model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Application {
	public static void main(String[]args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Employee emp = new Employee();
		emp.setName("Panjree Dave");
		emp.setEmail("p@gmail.com");
		emp.setContactNo(9825948428L);
		emp.setSalary(20000);
		emp.setAddress("RT Nagar,Bangalore");
		session.save(emp);
		tx.commit();
		
		
	
	}
}
