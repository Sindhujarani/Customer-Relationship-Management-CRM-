package pd.example.trial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pd.example.trial.model.Company;
import pd.example.trial.model.Lead;
import pd.example.trial.repository.LeadRepository;

import java.util.List;

@Service
public class LeadService {

    @Autowired
    private LeadRepository leadRepository;
    public List<Lead> getLead(){
        return leadRepository.findAll();
    }
    public Lead saveLead(Lead lead){
        return leadRepository.save(lead);
    }
    public Lead updateLead(Lead lead){
        return leadRepository.save(lead);
    }
}
