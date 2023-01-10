package com.jsp.one_to_many_bimapp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestStudentCourse {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory =Persistence.createEntityManagerFactory("sonam");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		List<Course> course =new ArrayList();
		
		Student student = new Student();
		student.setName("sonam");
		
		
		Course course1=new Course();
		course1.setName("SDLC");
		course1.setDuration("1 months");
		
		Course course2= new Course();
		course2.setName("web technology");
		course2.setDuration("1 month");
		
		course.add(course1);
		course.add(course2);
		student.setCourse(course);
		
		course1.setStudent(student);
		course2.setStudent(student);
		
		entityTransaction.begin();
		entityManager.persist(student);
		entityManager.persist(course1);
		entityManager.persist(course2);
		entityTransaction.commit();
		System.out.println("All good");
		
		
		
		
	}

}
