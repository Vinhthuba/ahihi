package vinh.com.new_demo_1.service;
import org.springframework.stereotype.Service;
import java.util.List;
import  java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import vinh.com.new_demo_1.dao.EmployeeRepository;
import vinh.com.new_demo_1.entity.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository)
    {
        employeeRepository = theEmployeeRepository;
    }
    @Override
    public List<Employee> findAll()
    {
        return employeeRepository.findAllByOrderByLastNameAsc();
    }
    @Override
    public Employee findById(int theId)
    {
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;

        if(result.isPresent())
        {
            theEmployee = result.get();
        }
        else {
            throw new RuntimeException("Did not find employee if - = "+theId);
        }
        return theEmployee;
    }
    @Override
    public void save(Employee theEmployee)
    {
        employeeRepository.save(theEmployee);

    }
    @Override
    public void deleteById(int theId)
    {
        employeeRepository.deleteById(theId);
    }
    @Override
    public List<Employee> searchBy(String theName)
    {
        List<Employee> results = null;
        if(theName != null && (theName.trim().length() >0))
        {
            results = employeeRepository.findByFirstNameContainOrLastNameContainsAllIgnoreCase(theName, theName);
        }
        else {
            results=findAll();
        }
        return results;
    }
}
