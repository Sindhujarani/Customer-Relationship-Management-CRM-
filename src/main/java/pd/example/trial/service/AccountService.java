package pd.example.trial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pd.example.trial.model.Account;
import pd.example.trial.model.Contact;
import pd.example.trial.repository.AccountRepository;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;


    public List<Account> getAccount(){
        return accountRepository.findAll();
    }
    public Account saveAccount(Account account){
        return accountRepository.save(account);
    }
    public Account updateAccount(Account account){
        return accountRepository.save(account);
    }
}
