package com.greatlearning.driver;

import java.util.HashSet;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatlearning.entity.Employee;
import com.greatlearning.entity.Project;

public class InsertEmployeeAndProjects {

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

					
					// start transaction
					session.beginTransaction();

					// create the objects
					Employee tempEmployee1 = new Employee("Sumanth", "Kumar", "sumanth@greatlearning.com");
					
					Employee tempEmployee2 = new Employee("Rajani", "Mehta", "rajani@greatlearning.com");
					
					Project project1 = new Project("BusinessMgmtSystem");
					Project project2 = new Project("ReservationSystem");
					
					session.save(project1);
					session.save(project2);
					
					
					Set <Project> projectList1=new HashSet<>();
					projectList1.add(project1);
					projectList1.add(project2);
					
					tempEmployee1.setProjects(projectList1);
					
					// save the Employee
					session.save(tempEmployee1);
					
					Set<Project> projectList2=new HashSet<>();
					projectList2.add(project1);
					
					tempEmployee2.setProjects(projectList2);
					// save the Employee
					session.save(tempEmployee2);
				
					

					// commit transaction
					session.getTransaction().commit();
					
					System.out.println("Completed Successfully");

				} finally {

					factory.close();
				}

	}

}
