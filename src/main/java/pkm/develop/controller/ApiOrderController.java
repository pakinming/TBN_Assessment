package pkm.develop.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pkm.develop.model.Account;
import pkm.develop.model.Menu;
import pkm.develop.model.Order;
import pkm.develop.service.AccountRepo;
import pkm.develop.service.MenuRepo;
import pkm.develop.service.OrderRepo;

@RestController
@RequestMapping("/api")
public class ApiOrderController {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private AccountRepo accountRepo;
    @Autowired
    private MenuRepo menuRepo;

    @GetMapping("/order/{orderId}")
    public ResponseEntity<Order> getOrder(@PathVariable("orderId") int orderId) {
        try {
            return ResponseEntity.ok(orderRepo.findById(orderId).get());
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/order")
    public ResponseEntity<Iterable<Order>> getOrder() {
        try {
            return ResponseEntity.ok(orderRepo.findAll());
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        }
    }

    @PostMapping("/createOrder")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        try {

            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = myDateObj.format(myFormatObj);

            Account account = accountRepo.findById(order.getAccountId()).get();
            Menu menu = menuRepo.findById(order.getMenuId()).get();
            order.setAccountId(account.getUserId());
            order.setOrderDate(formattedDate);
            order.setMenuId(menu.getMenuId());
            return ResponseEntity.ok(orderRepo.save(order));

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/updateOrder")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order) {
        try {

            Account account = new Account();

            if (orderRepo.existsById(order.getOrderId())) {

                account = accountRepo.findById(order.getAccountId()).get();
                var orderResult = orderRepo.findById(order.getOrderId()).get();

                orderResult.setOrderStatus(order.getOrderStatus());
                orderResult.setTotalAmount(order.getTotalAmount());
                orderResult.setAccountId(account.getUserId());
                System.out.println("order lastupdate" + orderResult);

                return ResponseEntity.ok(orderResult);

            }
            System.out.println(account.getUserId() == 0);
            return ResponseEntity.badRequest().body(order);

        } catch (Exception e) {
            System.out.println("[ERROR] updateOrder:$ " + e.getMessage());
            return ResponseEntity.badRequest().build();
        }

    }

}
