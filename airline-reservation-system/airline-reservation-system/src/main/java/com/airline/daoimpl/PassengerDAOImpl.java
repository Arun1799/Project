package com.airline.daoimpl;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.airline.config.HibernateUtil;
import com.airline.dao.PassengerDAO;
import com.airline.entity.Passenger;

public class PassengerDAOImpl implements PassengerDAO{

	//this method gets the session to save the new details of passenger
	@Override
	public void savePassenger(Passenger passenger) {
		try(Session session = HibernateUtil.getSession())
		{
			//adding new passenger details
			session.beginTransaction();
			session.save(passenger);
			
			//commit our transaction
			session.getTransaction().commit();
			
			//clear the session
			session.clear();
			
		}
		catch(HibernateException e)
		{
			System.out.println("Hibernate exception is: "+e);
		}
		catch(Exception e)
		{
			System.out.println("Exception is: "+e);
		}
		
	}

	@Override
	public Passenger getPassengerById(int id) {
		try(Session session = HibernateUtil.getSession())
		{
			Passenger passenger = session.get(Passenger.class, id);
			return passenger;
		}
		catch(HibernateException e)
		{
			System.out.println("Hibernate exception is: "+e);
		}
		catch(Exception e)
		{
			System.out.println("Exception is: "+e);
		}
		return null;
	}

	@Override
	public Passenger updatePassengerById(int id, Passenger passenger) {
		try(Session session = HibernateUtil.getSession())
		{
			Passenger existpassenger =session.load(Passenger.class, id);
			
			//update existing details with the new one
			existpassenger.setName(passenger.getName());
			existpassenger.setEmail(passenger.getEmail());
			existpassenger.setPhone(passenger.getPhone());
			existpassenger.setUserName(passenger.getUserName());
			existpassenger.setPassword(passenger.getPassword());
			
			session.beginTransaction();
			session.saveOrUpdate(existpassenger);
			session.getTransaction().commit();
			
			return existpassenger;
		}
		catch(HibernateException e)
		{
			System.out.println("Hibernate exception is: "+e);
		}
		catch(Exception e)
		{
			System.out.println("Exception is: "+e);
		}
		return null;
	}

	@Override
	public void deletePassenger(int id) {
		try(Session session = HibernateUtil.getSession())
		{
			Passenger passenger = session.load(Passenger.class, id);
			
			session.beginTransaction();
			int input =JOptionPane.showConfirmDialog(null, "Do you want to delete?",
					"Press Yes to delete else press No.",JOptionPane.YES_NO_OPTION);
			if(input==0)
			{
				session.delete(passenger);
			}
			else
				JOptionPane.showMessageDialog(null, "User wants to retain it.");
			
			session.getTransaction().commit();
			
		}
		catch(HibernateException e)
		{
			System.out.println("Hibernate exception is: "+e);
		}
		catch(Exception e)
		{
			System.out.println("Exception is: "+e);
		}
		
	}

	@Override
	public Passenger getPassengerByEmail(String email) {
		try(Session session = HibernateUtil.getSession())
		{
			String query = "from Passenger where email=:e";
			Query q = session.createQuery(query);
			
			q.setParameter("e", email);
			
			Passenger p = (Passenger) q.uniqueResult();
			return p;
		}
		catch(HibernateException e)
		{
			System.out.println("Hibernate exception is: "+e);
		}
		catch(Exception e)
		{
			System.out.println("Exception is: "+e);
		}
		return null;
	}

}
