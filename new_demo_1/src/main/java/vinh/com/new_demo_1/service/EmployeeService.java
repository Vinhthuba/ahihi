package vinh.com.new_demo_1.service;

import vinh.com.new_demo_1.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();
    public Employee findById(int theId);
    public void save(Employee theEmployee);
    public void deleteById(int theId);
    public List<Employee> searchBy(String theName);

}
