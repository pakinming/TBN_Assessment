package pkm.develop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pkm.develop.model.Menu;
import pkm.develop.service.AccountRepo;
import pkm.develop.service.MenuRepo;

@RestController
@RequestMapping("/api")
public class ApiMenuController {
    @Autowired
    private MenuRepo menuRepo;

    @Autowired
    private AccountRepo accountRepo;

    @GetMapping("/menu/{menuId}")
    public ResponseEntity<Menu> getMenu(@PathVariable("menuId") int menuId) {
        try {
            return ResponseEntity.ok(menuRepo.findById(menuId).get());
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/menu")
    public ResponseEntity<Iterable<Menu>> getMenu() {
        try {
            return ResponseEntity.ok(menuRepo.findAll());
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/createMenu")
    public ResponseEntity<Menu> createMenu(@RequestBody Menu menu) {
        try {

            if (accountRepo.existsById(menu.getAccountId()) && menu.getPrice() > 0.0f) {

                return ResponseEntity.ok(menuRepo.save(menu));
            }

            return ResponseEntity.badRequest().body(menu);

        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/updateMenu")
    public ResponseEntity<Menu> updadreMenu(@RequestBody Menu menu) {
        try {

            if (menuRepo.existsById(menu.getMenuId())) {

                return ResponseEntity.ok(menuRepo.save(menu));
            }
            return ResponseEntity.badRequest().body(menu);

        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().build();
        }
    }

}
