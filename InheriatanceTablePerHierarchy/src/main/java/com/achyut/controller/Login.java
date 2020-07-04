package com.achyut.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.achyut.model.ContractualEmployee;
import com.achyut.model.RegularEmployee;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("txtUsername");
		String password = request.getParameter("txtPassword");
		
		/*
		 * Session session = null; Transaction transaction = null; Employee
		 * employee=null; SessionFactory sessionFactory = null; try { sessionFactory =
		 * new AnnotationConfiguration().configure().buildSessionFactory(); session =
		 * sessionFactory.openSession(); transaction = session.beginTransaction(); Query
		 * query = session.
		 * createQuery("select email,password from employeetable where email = :email");
		 * query.setString("email", username); List<Object[]>list = query.list();
		 * for(Object[]object:list) { employee = new Employee();
		 * employee.setEmail(String.valueOf(object[0]));
		 * employee.setPassword(String.valueOf(object[1])); } transaction.commit(); }
		 * catch(HibernateException he) { if(transaction != null) transaction.commit();
		 * he.printStackTrace(); } finally { session.close(); }
		 * if(employee.getEmail().equals(username)&&(employee.getPassword().equals(
		 * password))) System.out.println("Login successfully"); else
		 * System.out.println("There is some problem while login");
		 */
		
		RegularEmployee employee = new RegularEmployee();
		//employee.setId(1);
		employee.setName("Achyut Thaker");
		employee.setEmail("a@a.com");
		employee.setAddress("Bangalore");
		employee.setDepartment("IT");
		employee.setPassword("testing");
		employee.setContactNo(9925948428L);
		employee.setSalary(2000000);
		employee.setBonus(200000);
		
		ContractualEmployee cEmployee = new ContractualEmployee();
		//cEmployee.setId(2);
		cEmployee.setName("Panjree Dave");
		cEmployee.setEmail("p@p.com");
		cEmployee.setAddress("Mithapur");
		cEmployee.setDepartment("Mechanical");
		cEmployee.setPassword("testing");
		cEmployee.setContactNo(9408503350L);
		cEmployee.setContractDuration("3 year");
		cEmployee.setPayPerHour(1500);
		
		
		Session session= null;
		SessionFactory  sessionFactory = null;
		Transaction transaction = null;
		try {
			sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(employee);
			session.save(cEmployee);
			transaction.commit();
		} catch(HibernateException he) {
			if(transaction != null)
				transaction.rollback();
			he.printStackTrace();
		}
	}

}
