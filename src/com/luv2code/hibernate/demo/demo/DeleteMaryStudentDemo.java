package com.luv2code.hibernate.demo.demo;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteMaryStudentDemo {
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
            int id=2;
            Student theStudent=session.get(Student.class,id);
            System.out.println("\nLoadedStudent"+theStudent);

            System.out.println(theStudent+"Courses: "+theStudent.getCourses());

            System.out.println("\nDeleting student");
            session.delete(theStudent);


            session.getTransaction().commit();

            System.out.println("Done!");

        }
        finally {
            session.close();
            factory.close();
        }




    }
}
