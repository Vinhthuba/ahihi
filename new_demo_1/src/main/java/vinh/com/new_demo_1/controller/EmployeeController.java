package vinh.com.new_demo_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import vinh.com.new_demo_1.service.EmployeeService;
import vinh.com.new_demo_1.entity.Employee;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService theEmployeeService)
    {
        employeeService = theEmployeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel)
    {
        List<Employee> theEmployees = employeeService.findAll();

        theModel.addAttribute("employees", theEmployees);
        return "/employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel)
    {
        Employee theEmployee = new Employee();

        theModel.addAttribute("employee", theEmployee);

        return "/employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel)
    {
        Employee theEmployee = employeeService.findById(theId);

        theModel.addAttribute("employee", theEmployee);
        return "/employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee)
    {
        employeeService.save(theEmployee);

        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId)
    {
        employeeService.deleteById(theId);
        return "redirect:/employees/list";
    }
    @GetMapping("/search")
    public String search(@RequestParam("employeeName") String theName, Model theModel)
    {
        List<Employee> theEmployees = employeeService.searchBy(theName);

        theModel.addAttribute("employees", theEmployees);
        return "/employees/list-employees";
    }


}
