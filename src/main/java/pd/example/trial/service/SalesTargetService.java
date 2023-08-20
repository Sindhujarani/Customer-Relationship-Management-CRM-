package pd.example.trial.service;

import org.springframework.stereotype.Service;
import pd.example.trial.model.SalesTarget;
import pd.example.trial.repository.SalesTargetRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SalesTargetService {
    private final SalesTargetRepository salesTargetRepository;

    public SalesTargetService(SalesTargetRepository salesTargetRepository) {
        this.salesTargetRepository = salesTargetRepository;
    }
    public List<SalesTarget> getAllSalesTargets() {
        return salesTargetRepository.findAll();
    }

    public Optional<SalesTarget> getSalesTargetById(String id) {
        return salesTargetRepository.findById(id);
    }

    public SalesTarget saveSalesTarget(SalesTarget salesTarget) {
        return salesTargetRepository.save(salesTarget);
    }

    public void deleteSalesTargetById(String id) {
        salesTargetRepository.deleteById(id);
    }
}
