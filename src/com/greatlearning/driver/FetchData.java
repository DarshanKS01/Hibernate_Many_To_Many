package com.greatlearning.driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatlearning.entity.Employee;
import com.greatlearning.entity.Project;

public class FetchData {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Project.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {


			int theProjectId=2;// Bus Mgmt Sys
			
			// start transaction
			session.beginTransaction();

			Project tempProject = session.get(Project.class,theProjectId);//BusinessMgmtSys
			
			System.out.println("Project is: "+tempProject);
			System.out.println("Assigned Employee are: "+tempProject.getEmployees()); // Sumanth/Rajani
			
			System.out.println();
			
			int theEmployeeId=2;
			Employee tempEmployee=session.get(Employee.class,theEmployeeId);
			System.out.println("Employee is: "+tempEmployee);
									

			// commit transaction
			session.getTransaction().commit();

		} finally {

			factory.close();
		}

	}

}
