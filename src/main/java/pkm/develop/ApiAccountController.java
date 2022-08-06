package pkm.develop;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import pkm.develop.model.Account;
import pkm.develop.model.RoleAccount;
import pkm.develop.service.AccountRepo;

@RestController
@RequestMapping("/api")
public class ApiAccountController {
    @Autowired
    private AccountRepo accountRepo;

    @GetMapping("/account")
    public Account getAllAccount(@RequestParam String name) {

        Account account1 = new Account();
        // Account account2 = new Account();

        account1.setRole(RoleAccount.GUEST);

        return account1;
    }

    @GetMapping("/accountName")
    public String getAccountByUsername() {
        // AccountRepo accRepo = new AccountRepo();

        return "new Account()".toString();
    }

    @PostMapping("/createAccount")
    public Account createAccount(@RequestBody Account account) {
        
        accountRepo.save(account);
        return account;
    }

    @PostMapping("/updateAccount")
    public String updateAccount(@RequestParam(value = "name", defaultValue = "World") int name) {
        return String.format("Hello %s!", name);
    }

}