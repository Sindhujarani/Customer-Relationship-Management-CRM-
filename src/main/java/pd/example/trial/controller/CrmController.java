package pd.example.trial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/crm")
public class CrmController {
    @GetMapping("/home")
    public String employeeDashboard(){
        return "CRM_dashboard";
    }
}
