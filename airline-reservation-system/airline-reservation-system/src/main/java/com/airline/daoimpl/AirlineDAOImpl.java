package com.airline.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.airline.config.HibernateUtil;
import com.airline.dao.AirlineDAO;
import com.airline.entity.Airline;
import com.airline.entity.Flight;

public class AirlineDAOImpl implements AirlineDAO{

	@Override
	public String saveAirline(Airline airline) {
		try(Session session=HibernateUtil.getSession())
		{
			session.beginTransaction();
			
			session.save(airline);
			
			session.getTransaction().commit();
			
			session.clear();
			return "Airline saved successfully";
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

	@Override
	public void assignAirlineToFlight(int flightId, int airlineId) {
		try(Session session=HibernateUtil.getSession())
		{
			session.beginTransaction();
			
			Flight flight = session.get(Flight.class, flightId);
			Airline airline = session.get(Airline.class, airlineId);
			
//			List<Flight> flights = new ArrayList<>();
//			flights.add(flight);
			
			flight.setAirline(airline);
			airline.setFlights(List.of(flight));
			
			session.saveOrUpdate(airline);
			session.save(flight);
			
			session.getTransaction().commit();
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

}
