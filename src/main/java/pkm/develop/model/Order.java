package pkm.develop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.GenerationType;

@Entity
@Table(name = "tblorder")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    private int accountId;
    private String orderDate;
    private float totalAmount;
    private int orderStatus;
    private int menuId;

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        int _orderStatus = 0;
        switch (orderStatus) {
            case OrderStatus.OFFER_ORDER:
                _orderStatus = OrderStatus.OFFER_ORDER;
                break;
            case OrderStatus.PREPARE_ORDER:
                _orderStatus = OrderStatus.PREPARE_ORDER;
                break;
            case OrderStatus.SENDING:
                _orderStatus = OrderStatus.SENDING;
                break;
            case OrderStatus.RECEIVE:
                _orderStatus = OrderStatus.RECEIVE;
                break;
            default:
                _orderStatus = 0;
                break;
        }
        this.orderStatus = _orderStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + accountId;
        result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
        result = prime * result + orderId;
        result = prime * result + orderStatus;
        result = prime * result + Float.floatToIntBits(totalAmount);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        if (accountId != other.accountId)
            return false;
        if (orderDate == null) {
            if (other.orderDate != null)
                return false;
        } else if (!orderDate.equals(other.orderDate))
            return false;
        if (orderId != other.orderId)
            return false;
        if (orderStatus != other.orderStatus)
            return false;
        if (Float.floatToIntBits(totalAmount) != Float.floatToIntBits(other.totalAmount))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "{accountId:" + accountId + ", orderDate:" + orderDate + ", orderId:" + orderId + ", orderStatus:"
                + orderStatus + ", totalAmount:" + totalAmount + "}";
    }

}
