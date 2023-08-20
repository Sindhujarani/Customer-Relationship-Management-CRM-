package pd.example.trial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pd.example.trial.model.Employee;
import pd.example.trial.model.Lead;
import pd.example.trial.repository.LeadRepository;
import pd.example.trial.service.LeadService;

import java.util.List;

@Controller
@RequestMapping("/lead")
public class LeadController {

    @Autowired
    private LeadService leadService;

    @GetMapping("/create")
    public String createLead(){
        return "lead_create";
    }

    @PostMapping("/create")
    public String leadCreate(@ModelAttribute Lead leads){
        leadService.saveLead(leads);
        return "redirect:/crm/home";
    }
    @GetMapping("/view-leads")
    public String viewLeads(Model model){
        List<Lead> lead = leadService.getLead();
        model.addAttribute("listAll",lead);
        return "view_leads";

    }
}
