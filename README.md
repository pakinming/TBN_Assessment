
## Getting Started

### Project Online Food Ordering

First, run the development Mysql server:
```bash
docker compose up -d

```

### run 
run the development Spring boot:

```bash
./mvnw spring-boot:run
```

### data sample 
  
```
############## Menu ##############
GET /api/menu
GET /api/menu/<menuId>

POST /api/createMenu
{
    "menuName": "coffee latte",
    "price": 80,
    "menuImage": "/img/menu/coffee_latte_1.png",
    "ingredients": "coffee, milk, syrup, vanilla",
    "accountId": 1
}

POST /api/updateMenu
{
    "menuId": 1,
    "menuName": "coffee espresso",
    "price": 120,
    "menuImage": "/img/menu/coffee_espresso_1.png",
    "ingredients": "coffee, vanilla",
    "accountId": 1
}


############## Account ##############
GET /api/account
GET /api/account/<userId>

POST /api/createAccount
{
    "firstname": "spring",
    "lastname": "boot",
    "username": "springboot",
    "password": "boot",
    "contact": "address 1000",
 
}

POST /api/updateAccount
{
    "userId": 1,
    "username": "myUser",
    "password": "myPass",
    "firstname": "spring",
    "lastname": "boot",
    "contact": "address 2000",
    "role": 2
}


############## Order ##############
GET /api/order
GET /api/order/<orderId>

POST /api/createOrder
{
    "accountId": 1,
    "totalAmount": 2,
    "menuId": 1
}

POST /api/updateOrder
{
    "orderId": 1,
    "accountId": 1,
    "totalAmount": 1,
    "orderStatus": 4
}
```