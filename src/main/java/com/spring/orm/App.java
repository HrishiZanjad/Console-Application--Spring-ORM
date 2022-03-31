package com.spring.orm;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("com/spring/orm/configorm.xml");
        StudentDao studentDao=context.getBean("studentDao", StudentDao.class);
//        Student student=new Student(2345,"Hrishi Zanjad","Pune");
//        int r=studentDao.insert(student);
//        System.out.println("Done "+r);
        int ch=0;
        Scanner sc=new Scanner(System.in);
        Student student=new Student();
        System.out.println("***********Welcome to Spring orm Project****************");
        do {

            System.out.println("PRESS 1 for new student");
            System.out.println("PRESS 2 for displaying all student");
            System.out.println("PRESS 3 for getting details of single student");
            System.out.println("PRESS 4 for deleting a student");
            System.out.println("PRESS 5 for updating a student");
            System.out.println("PRESS 6 for exit");
            ch=sc.nextInt();
            switch (ch){
                case 1:
                    System.out.println("Please Enter Student Details");
                    System.out.print("\nStudent Id:");
                    student.setStudentId(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Student Name:");
                    student.setStudentName(sc.nextLine());
                    System.out.println("Student City");
                    student.setStudentCity(sc.nextLine());
                    studentDao.insert(student);
                    System.out.println("Student with Id "+student.getStudentId()+" is created");
                    break;
                case 2:
                    System.out.println("Student Details:");
                    List<Student> students=studentDao.getAllStudent();
                    for (Student s:students
                         ) {
                        System.out.print(s.getStudentId()+"...");
                        System.out.print(s.getStudentName()+"...");
                        System.out.print(s.getStudentCity()+"\n");
                    }
                break;
                case 3:
                    System.out.println("Enter student Id: ");
                    student=studentDao.getStudent(sc.nextInt());
                    sc.nextLine();
                    System.out.print(student.getStudentId()+"...");
                    System.out.print(student.getStudentName()+"...");
                    System.out.print(student.getStudentCity()+"\n");
                break;
                case 4:
                    System.out.println("Enter Student Id to be deleted: ");
                    student.setStudentId(sc.nextInt());
                    sc.nextLine();
                    studentDao.deleteStudent(student.getStudentId());
                    System.out.println("Student with Id "+student.getStudentId()+" is deleted");
                break;
                case 5:
                    System.out.println("Enter student details to be updated");
                    System.out.println("Student Id:");
                    student.setStudentId(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Student Name: ");
                    student.setStudentName(sc.nextLine());
                    System.out.println("Student City: ");
                    student.setStudentCity(sc.nextLine());
                    studentDao.updateStudent(student);
                    System.out.println("Student detail with "+ student.getStudentId()+" updated");
                break;
                default:
                    if(ch==6){
                        System.out.println("Visit Again..!!");
                        break;
                    }
                    System.out.println("Entered wrong input, Try again...");
            }
        }while (ch!=6);
    }
}
