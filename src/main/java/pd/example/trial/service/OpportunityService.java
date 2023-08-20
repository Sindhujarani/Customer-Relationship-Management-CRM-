package pd.example.trial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pd.example.trial.model.Opportunity;
import pd.example.trial.repository.OpportunityRepository;

import java.util.List;
@Service
public class OpportunityService {
    @Autowired
    private OpportunityRepository opportunityRepository;
    public List<Opportunity> getOpportunity(){
        return opportunityRepository.findAll();
    }
    public Opportunity saveOpportunity(Opportunity opportunity){
        return opportunityRepository.save(opportunity);
    }
    public Opportunity updateOpportunity(Opportunity opportunity){
        return opportunityRepository.save(opportunity);
    }
}
