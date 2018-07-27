package com.luv2code.hibernate.demo.demo;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForMaryDemo {
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

            System.out.println("\nStudents courses :"+theStudent.getCourses());
            Course course1=new Course("Rubik's Cube - How to Speed Cube");
            Course course2=new Course("Atari 2600 - Game development");
            course1.addStuden(theStudent);
            course2.addStuden(theStudent);

            System.out.println("Saving courses");
            session.save(course1);
            session.save(course2);



            session.getTransaction().commit();

            System.out.println("Done!");

        }
        finally {
            session.close();
            factory.close();
        }




    }
}
