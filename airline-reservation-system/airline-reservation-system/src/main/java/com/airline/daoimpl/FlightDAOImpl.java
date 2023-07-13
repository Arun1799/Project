package com.airline.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.airline.config.HibernateUtil;
import com.airline.dao.FlightDAO;
import com.airline.entity.Flight;

public class FlightDAOImpl implements FlightDAO{

	@Override
	public void saveFlight(Flight flight) {
		try(Session session=HibernateUtil.getSession())
		{
			session.beginTransaction();
			
			session.save(flight);
			
			session.getTransaction().commit();
			
			session.clear();
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Flight> checkFlights(String source, String dest) {
		try(Session session=HibernateUtil.getSession())
		{
			String q = "from Flight where source=:s and destination=:d";
			Query query = session.createQuery(q);
			
			query.setParameter("s", source);
			query.setParameter("d", dest);
			
			List<Flight> flights = query.list();
			
			return flights;
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
