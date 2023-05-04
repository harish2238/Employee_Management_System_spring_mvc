package mvc_spring.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mvc_spring.dto.Employee;
@Component
public class EmployeeDAO {
	
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("sigma");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	public void saveEmployee(Employee employee) {
		et.begin();
		em.persist(employee);
		et.commit();
	}
	
	public List<Employee> getAllEmployee() {
		Query q=em.createQuery("select e from Employee e");
		List<Employee> l=q.getResultList();
		return l;
	}
	
	public Employee getEmployee(int id) {
		return em.find(Employee.class, id);
	}
	
	public void updateEmployee(Employee employee) {
		et.begin();
		em.merge(employee);
		et.commit();
	}
	
	public void deleteEmployee(Employee employee) {
		et.begin();
		em.remove(employee);
		et.commit();
	}
}
