package com.airline.daoimpl;

import java.time.LocalDate;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.airline.config.HibernateUtil;
import com.airline.dao.TicketDAO;
import com.airline.entity.Flight;
import com.airline.entity.Passenger;
import com.airline.entity.TicketBooking;
import com.airline.exception.GlobalException;

public class TicketDAOImpl implements TicketDAO {

	@Override
	public TicketBooking bookFlight(int flightId, int passengerId, TicketBooking ticketBooking) {
		try(Session session = HibernateUtil.getSession())
		{
			session.beginTransaction();
			Flight flight =session.get(Flight.class, flightId);
			Passenger pass = session.get(Passenger.class, passengerId);     
			
			if(flight.getSource().equalsIgnoreCase(ticketBooking.getSource()) && 
					flight.getDestination().equalsIgnoreCase(ticketBooking.getDestination()))
			{
				LocalDate bookingDate = ticketBooking.getBookingDate();
				LocalDate fDate = flight.getDate();
				if(!bookingDate.isAfter(fDate))
				{
					if(ticketBooking.getNoOfPassengers()<=flight.getAvailableSeat())
					{
					int availSeat =flight.getAvailableSeat() - ticketBooking.getNoOfPassengers();
					flight.setAvailableSeat(availSeat);
					
					float totalFare = flight.getFare() * ticketBooking.getNoOfPassengers();
					ticketBooking.setTotalFare(totalFare);
					
					ticketBooking.setAirline(flight.getAirline());
					ticketBooking.setFlight(flight);
					ticketBooking.setPassenger(pass);
					
					session.saveOrUpdate(flight);
					session.save(ticketBooking);
					session.getTransaction().commit();
					return ticketBooking;
					}
					else
						throw new GlobalException("No. of passengers is greater than the no. of available seats.");
				}
				else
					throw new GlobalException("You have to book before travel date.");
			}
			else
				throw new GlobalException("Source and destination does not match.");
			
			
		}
		catch (HibernateException e) {
			System.out.println("Hibernate exception: "+e);
		}
		catch (Exception e) {
			System.out.println("Exception: "+e);
		}
		return null;
	}

}
