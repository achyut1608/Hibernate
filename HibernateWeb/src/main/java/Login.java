

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.achyut.Employee;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("txtUsername");
		String password = request.getParameter("txtPassword");
		String emai="";
		String pswd = "";
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Employee emp = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("select email,password from Employeetable where email = :email");
			query.setString("email", username);
			List<Object[]> rows = query.list();
			
			for(Object[] obj: rows) {
				emp = new Employee();
				emp.setEmail(String.valueOf(obj[0]));
				emp.setPassword(String.valueOf(obj[1]));
			}
						
			tx.commit();
		} catch(HibernateException ex) {
			if(tx != null) 
				tx.rollback();
			
			ex.printStackTrace();
		} finally {
			session.close();
		}
		
		if(username.equals(emp.getEmail()) && password.equals(emp.getPassword()))
			System.out.println("Login successful");
		else
			System.out.println("There is some problem while login please try again");
	}
	
	

}
