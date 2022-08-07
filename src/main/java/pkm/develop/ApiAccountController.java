package pkm.develop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.data.repository.query.Param;

import pkm.develop.model.Account;
import pkm.develop.model.HttpResponse;
import pkm.develop.model.RoleAccount;
import pkm.develop.service.AccountRepo;

@RestController
@RequestMapping("/api")
public class ApiAccountController {

    @Autowired
    private AccountRepo accountRepo;

    @GetMapping("/account")
    public Iterable<Account> getAllAccount() {
        try {
            return accountRepo.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/account/{userId}")
    public Account getAccountByUserId(@PathVariable("userId") int userId) {
        try {
            return accountRepo.findById(userId).get();
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/createAccount")
    public HttpResponse createAccount(@RequestBody Account account) {
        try {
            account.setRole(RoleAccount.GUEST);
            account = accountRepo.save(account) ;
            return new HttpResponse(true, account.toString()
                    );
        } catch (Exception e) {
            return new HttpResponse(false, "create account failed");
        }
    }

    @PostMapping("/updateAccount")
    public HttpResponse updateAccount(@RequestBody Account account) {
        try {
            Account resultAccount = accountRepo.findById(account.getUserId()).get();

            resultAccount.setFirstname(account.getFirstname());
            resultAccount.setLastname(account.getLastname());
            resultAccount.setContact(account.getContact());
            accountRepo.save(resultAccount);
            return new HttpResponse(true, "update successfully");

        } catch (Exception e) {
            return new HttpResponse(false, "update your account failed");
        }
    }
}
