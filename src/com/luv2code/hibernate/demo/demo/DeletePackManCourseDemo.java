package com.luv2code.hibernate.demo.demo;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeletePackManCourseDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory= (SessionFactory) new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //create session
        Session session=factory.getCurrentSession();
        try {



            session.beginTransaction();
            int courseId=10;
            Course tempCourse=session.get(Course.class,courseId);
            System.out.println("Deleting course"+tempCourse);
            session.delete(tempCourse);




            session.getTransaction().commit();

            System.out.println("Done!");

        }
        finally {
            session.close();
            factory.close();
        }




    }
}
