package com.spring.orm.dao;

import com.spring.orm.entities.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class StudentDao{
    private HibernateTemplate hibernateTemplate;

    @Transactional
    public int insert(Student student){
        int i=(int)this.hibernateTemplate.save(student);
        return i;
    }

    public Student getStudent(int studentId){
        Student student=this.hibernateTemplate.get(Student.class,studentId);
        return student;
    }

    public List<Student> getAllStudent(){
        List<Student> students=hibernateTemplate.loadAll(Student.class);
        return students;
    }

    @Transactional
    public void deleteStudent(int studentId){
        Student student=this.hibernateTemplate.get(Student.class,studentId);
        this.hibernateTemplate.delete(student);
    }

    @Transactional
    public void updateStudent(Student student){
        this.hibernateTemplate.update(student);
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
