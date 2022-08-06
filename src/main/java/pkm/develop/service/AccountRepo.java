package pkm.develop.service;

import org.springframework.data.repository.CrudRepository;

import pkm.develop.model.Account;

public interface AccountRepo extends CrudRepository<Account, Integer> {

}
