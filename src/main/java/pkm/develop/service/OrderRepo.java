package pkm.develop.service;


import org.springframework.data.repository.CrudRepository;
import pkm.develop.model.Order;
public interface OrderRepo extends CrudRepository<Order, Integer> {
    
}
 