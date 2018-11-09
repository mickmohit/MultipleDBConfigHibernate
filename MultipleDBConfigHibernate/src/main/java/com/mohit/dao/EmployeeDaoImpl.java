package com.mohit.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mohit.model.Employee;

public class EmployeeDaoImpl implements IEmployeeDAO {
    SessionFactory sessionFactory1 = new  Configuration().configure("oracleconfig.cfg.xml").buildSessionFactory();
    SessionFactory sessionFactory2 = new Configuration().configure("mysql-hibernate.cfg.xml").buildSessionFactory();
    Session session = null;
    Transaction transaction = null;
    public void findAllEmployees() {
        ArrayList<Employee> empList = new ArrayList<Employee>();
               try {
            session = sessionFactory1.openSession();
            transaction = session.beginTransaction();
            transaction.begin();
            Criteria crit = session.createCriteria(Employee.class);
            empList = (ArrayList) crit.list();
             System.out.println("Records from Oracle Database");
            for (Employee emp : empList) {
                System.out.println(emp.getEmpid() + " " + emp.getEmpname() + " " + emp.getSalary());
                
            }
            session.close();
            session = sessionFactory2.openSession();
            Criteria crit1 = session.createCriteria(Employee.class);
            empList = (ArrayList) crit1.list();
            System.out.println("Records from Derby Database");
            for (Employee emp : empList) {
                System.out.println(emp.getEmpid() + " " + emp.getEmpname() + " " + emp.getSalary());
            }
            session.close();
        } catch (Exception he) {
            he.printStackTrace();
        }
    }
	public void insertEmployee(Employee e) {
        try {
            session = sessionFactory1.openSession();
            transaction = session.beginTransaction();
            transaction.begin();
            session.save(e);
            transaction.commit();
            session.close();
            session = sessionFactory2.openSession();
            transaction = session.beginTransaction();
            transaction.begin();
            session.save(e);
            transaction.commit();
            session.close();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }
}
