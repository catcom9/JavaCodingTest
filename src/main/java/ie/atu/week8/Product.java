package ie.atu.week8;

import javax.lang.model.element.Name;

public class Product {
    String productId;
    String name;
    double price;
    int quantity;

    Product(){
        productId = "";
        name = "";
        price = 0;
        quantity = 0;
    }

    String getProductId(){
        return productId;
    }

    String getName(){
        return name;
    }

    double getPrice(){
        return price;
    }

    int getQuantity(){
        return quantity;
    }

    void setProductId(String ToSet){
        productId = ToSet;
    }

    void setName(String ToSet){
        name = ToSet;
    }

    void setPrice(double ToSet){
        price = ToSet;
    }

    void setQuantity(int ToSet){
        quantity = ToSet;
    }
}

