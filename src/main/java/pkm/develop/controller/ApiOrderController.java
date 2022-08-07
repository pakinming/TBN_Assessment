package pkm.develop.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import pkm.develop.model.Account;
import pkm.develop.model.HttpResponse;
import pkm.develop.model.Order;
import pkm.develop.service.AccountRepo;
import pkm.develop.service.OrderRepo;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api")
public class ApiOrderController {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private AccountRepo accountRepo;

    @GetMapping("/order/{orderId}")
    public Order getOrder(@PathVariable("orderId") int orderId) {
        try {
            return orderRepo.findById(orderId).get();
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/order")
    public Iterable<Order> getOrder() {
        try {
            return orderRepo.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/createOrder")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        try {

            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = myDateObj.format(myFormatObj);

            Account account = accountRepo.findById(order.getAccountId()).get();
            order.setAccountId(account.getUserId());
            order.setOrderDate(formattedDate);
            order.setTotalAmount(0.0f);
            return ResponseEntity.ok(orderRepo.save(order));

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/updateOrder")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order) {
        try {

            Account account = new Account();
            System.out.println("orderRepo.existsById " + orderRepo.existsById(order.getOrderId()));
            System.out.println("order.getAccountId " + order.getAccountId());

            if (orderRepo.existsById(order.getOrderId())) {
              
                account = accountRepo.findById(order.getAccountId()).get();

                System.out.println("getById " + account);
                order.setAccountId(account.getUserId());
                System.out.println("order lastupdate" + order);

                return ResponseEntity.ok(order);
               
            }
            System.out.println(account.getUserId() == 0);
            return ResponseEntity.badRequest().body(order);

        } catch (Exception e) {
            System.out.println("[ERROR] updateOrder:$ " + e.getMessage());
            return ResponseEntity.badRequest().build();
        }

    }

}
