package pkm.develop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;

@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int menuId;
    private String menuName;
    private float price;
    private int menuTypeId;
    private String menuImage;
    private String ingredients;
    private int menuStatus;


    public Menu() {
    }


    public Menu(int menuId, String menuName, float price, int menuTypeId, String menuImage, String ingredients,
            int menuStatus) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.price = price;
        this.menuTypeId = menuTypeId;
        this.menuImage = menuImage;
        this.ingredients = ingredients;
        this.menuStatus = menuStatus;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getMenuTypeId() {
        return menuTypeId;
    }

    public void setMenuTypeId(int menuTypeId) {
        this.menuTypeId = menuTypeId;
    }

    public String getMenuImage() {
        return menuImage;
    }

    public void setMenuImage(String menuImage) {
        this.menuImage = menuImage;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public int getMenuStatus() {
        return menuStatus;
    }

    public void setMenuStatus(int menuStatus) {
        this.menuStatus = menuStatus;
    }

    @Override
    public String toString() {
        return "Menu [ingredients=" + ingredients + ", menuId=" + menuId + ", menuImage=" + menuImage + ", menuName="
                + menuName + ", menuStatus=" + menuStatus + ", menuTypeId=" + menuTypeId + ", price=" + price + "]";
    }

}
