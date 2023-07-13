package com.airline.daoimpl;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.airline.config.HibernateUtil;
import com.airline.dao.AdminDAO;
import com.airline.entity.Admin;

public class AdminDAOImpl implements AdminDAO {

	@Override
	public void saveAdmin(Admin admin) {
		try(Session session = HibernateUtil.getSession())
		{
			//adding new passenger details
			session.beginTransaction();
			session.save(admin);
			
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
	public boolean login(String userName, String password) {
		try(Session session = HibernateUtil.getSession())
		{
//			int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Id: ","Type here.."));
//			Admin a = session.get(Admin.class, id);
			String query = "from Admin where userName=:user and password=:pass";
			Query q = session.createQuery(query);
			
			q.setParameter("user", userName);
			q.setParameter("pass", password);
			
			Admin a = (Admin) q.uniqueResult();
			
			if(a.getUserName().equals(userName) && a.getPassword().equals(password) &&
					a.getRole().equalsIgnoreCase("admin"))
			{
				return true;
			}
			else
				return false;
		}
		catch(HibernateException e)
		{
			System.out.println("Hibernate exception is: "+e);
		}
		catch(Exception e)
		{
			System.out.println("Exception is: "+e);
		}
		return false;
	}

}
