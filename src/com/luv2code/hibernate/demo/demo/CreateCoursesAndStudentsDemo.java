package com.luv2code.hibernate.demo.demo;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesAndStudentsDemo {
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

            //create a course
            Course tempCourse=new Course("Pacman - how to score one million points");
            //add some students
            Student student1=new Student("John","Doe","John@luv2code.com");
            Student student2=new Student("Mary","Public","Mary@luv2code.com");

            tempCourse.addStuden(student1);
            tempCourse.addStuden(student2);

            System.out.println("Saving students");
            session.save(student1);
            session.save(student2);
            System.out.println("Saved students : "+tempCourse.getStudents());

            //save the course... also saved students
            System.out.println("Saving course");
            session.save(tempCourse);
            session.getTransaction().commit();

            System.out.println("Done!");

        }
        finally {
            session.close();
            factory.close();
        }




    }
}
