package pd.example.trial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pd.example.trial.exception.ResourceNotFoundException;
import pd.example.trial.model.Company;
import pd.example.trial.model.Employee;
import pd.example.trial.repository.CompanyRepository;
import pd.example.trial.service.CompanyService;
import pd.example.trial.service.EmployeeService;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/company")
public class CompanyController {
    @Autowired
    private  CompanyService companyService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CompanyRepository companyRepository;



    @GetMapping("/home")
    public String homePage(){
        saveCompanyProfileDetails();
        return"admin_dashboard";
    }

    public void saveCompanyProfileDetails(){
        if(companyRepository.count()==0) {
            Company company = new Company("0012", "Prodevans Technologies",
                    "Banglore", "BTM Lake", "Koramangala", "Karnataka", "India",
                    "Rupee", "9865210045", "6398562300",
                    "prodevans@gmail.com", null, null, 0);
            companyRepository.save(company);
        }
    }

    @GetMapping("/view-company")
    public String viewCompany(Model model){
        List<Company> companyList = companyService.getCompany();
        model.addAttribute("listAll", companyList);
        return "view-company-profile";

    }
    @GetMapping("/add-employee")
    public String showEmployeeCreationForm(Model model) {
        return "create_employee";
    }

    @PostMapping("/add-employee")
    public String addEmployee(@ModelAttribute Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/api/company/home";
    }
    @GetMapping("/view-employee")
    public String viewEmployee(Model model){
        List<Employee> employeeList = employeeService.getAllEmployees();
        model.addAttribute("listAll", employeeList);
        return "view-employee-profile";

    }
    @GetMapping("/add-target")
    public String showCompanyTargetForm(Model model) {
        return "company_target";
    }

    @PostMapping("/add-target")
    public String addTarget(@ModelAttribute Company target) {
        String companyId = "0012";
        Company details = companyService.findByCompanyId(companyId);
        details.setFromDate(target.getFromDate());
        details.setToDate(target.getToDate());
        details.setTarget(target.getTarget());
        companyService.saveCompany(details);
        return "redirect:/api/company/home";
    }
    @GetMapping("/sales-target")
    public String addSalesTarget(Model model){
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees",employees);
        return "sales_target";
    }
    @PostMapping("/sales-target")
    public String setSalesTarget(@ModelAttribute Employee employee){
        Employee employees = employeeService.findByEmployeeId(employee.getEmployeeId());
        employees.setTargetDate(employee.getTargetDate());
        employees.setTargetValue(employee.getTargetValue());
        employeeService.saveEmployee(employees);
        return "redirect:/api/company/home";
    }
    @GetMapping("/login")
    public String login(){
        return "homepage";
    }


}
