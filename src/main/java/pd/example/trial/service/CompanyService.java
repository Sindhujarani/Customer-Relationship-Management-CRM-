package pd.example.trial.service;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pd.example.trial.model.Company;
import pd.example.trial.repository.CompanyRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    @Autowired
    private  CompanyRepository companyRepository;



    public List<Company> getCompany(){
        return companyRepository.findAll();
    }
    public Company saveCompany(Company company){
        return companyRepository.save(company);
    }
    public Company upadteCompany(Company company){
        return companyRepository.save(company);
    }

    public Company findByCompanyId(String companyId) {
        return companyRepository.findByCompanyId(companyId);
    }
}
