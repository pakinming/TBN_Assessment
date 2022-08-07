package pkm.develop.service;


import org.springframework.data.repository.CrudRepository;
import pkm.develop.model.Menu;
public interface MenuRepo extends CrudRepository<Menu, Integer> {
    
}
