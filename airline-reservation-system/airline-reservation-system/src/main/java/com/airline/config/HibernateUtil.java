package com.airline.config;

import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.airline.entity.Admin;
import com.airline.entity.Airline;
import com.airline.entity.Flight;
import com.airline.entity.Passenger;
import com.airline.entity.TicketBooking;
import com.airline.entity.User;

public class HibernateUtil {

	public static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory()
	{
		if(sessionFactory==null)
		{
			try {
				Configuration cfg = new Configuration();
				
				// hibernate.cfg.xml property
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/airline_hibernate");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "1234");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
				settings.put(Environment.HBM2DDL_AUTO, "update");
				settings.put(Environment.SHOW_SQL, "false");
				
				cfg.setProperties(settings);
				
				cfg.addAnnotatedClass(Passenger.class);
				cfg.addAnnotatedClass(User.class);
				cfg.addAnnotatedClass(Admin.class);
				cfg.addAnnotatedClass(Airline.class);
				cfg.addAnnotatedClass(Flight.class);
				cfg.addAnnotatedClass(TicketBooking.class);
				
				ServiceRegistry service = new StandardServiceRegistryBuilder().
						applySettings(cfg.getProperties()).build();
				sessionFactory = cfg.buildSessionFactory(service);
				return sessionFactory;
				
			}
			catch(HibernateException e)
			{
				System.out.println(e);
			}
		}
		return sessionFactory;
	}
	
	//get session object
	public static Session getSession()
	{
//		Session session = getSessionFactory().openSession();
//		return session;
		
		return getSessionFactory().openSession();
		
	}
	
}
