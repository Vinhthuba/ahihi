package vinh.com.new_demo_1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import vinh.com.new_demo_1.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
   public List<Employee> findAllByOrderByLastNameAsc();
   public List<Employee> findByFirstNameContainOrLastNameContainsAllIgnoreCase(String name, String lName);
}
