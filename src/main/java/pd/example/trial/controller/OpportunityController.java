package pd.example.trial.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pd.example.trial.model.Opportunity;
import pd.example.trial.service.OpportunityService;

import java.util.List;

@Controller
@RequestMapping("/opportunity")
public class OpportunityController {
    @Autowired
    private OpportunityService opportunityService;

    @GetMapping("/create")
    public String createOpportunity(){
        return "create_opportunity";
    }

    @PostMapping("/create")
    public String opportunityCreate(@ModelAttribute Opportunity opportunity){
        opportunityService.saveOpportunity(opportunity);
        return "redirect:/crm/home";
    }
    @GetMapping("/view")
    public String viewLeads(Model model){
        List<Opportunity> opportunity = opportunityService.getOpportunity();
        model.addAttribute("listAll",opportunity);
        return "view_opportunity";

    }

}