package com.employee.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.employee.entity.Employee;
import com.employee.model.EmployeePOJO;

public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	public void register(EmployeePOJO emp) {
		// TODO Auto-generated method stub
		System.out.println("hello "+emp.getFirstname() );
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Employee entity = new Employee();
		entity.setFirstname(emp.getFirstname());
		entity.setLastname(emp.getLastname());
		entity.setAddress(emp.getAddress());
		entity.setEmail(emp.getEmail());
		entity.setPhone(emp.getPhone());	
		session.persist(entity);
		tx.commit();
		session.close();
	}
	
	@Override
	public List<EmployeePOJO> listAll() {
		Session session = this.sessionFactory.openSession();
		List<Employee> entityList = session.createQuery("from Employee").list();
		session.close();
		List<EmployeePOJO> pojoList = new ArrayList<EmployeePOJO>();
		for(Employee e:entityList){
			EmployeePOJO ePOJO = new EmployeePOJO();
			ePOJO.setFirstname(e.getFirstname());
			ePOJO.setLastname(e.getLastname());
			ePOJO.setAddress(e.getAddress());
			ePOJO.setEmail(e.getEmail());
			ePOJO.setPhone(e.getPhone());
			pojoList.add(ePOJO);
		}
		return pojoList;	
	}

	@Override
	public EmployeePOJO getEmployee(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
