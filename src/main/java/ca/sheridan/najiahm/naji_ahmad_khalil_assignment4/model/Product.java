package ca.sheridan.najiahm.naji_ahmad_khalil_assignment4.model;

public class Product {
    private int id;
    private int product_code;
    private String brand;
    private int quantity;
    private float unit_price;
    
    public Product() {}
    
    public int getProduct_code() {
        return product_code;
    }
    public void setProduct_code(int product_code) {
        this.product_code = product_code;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public float getUnit_price() {
        return unit_price;
    }
    public void setUnit_price(float unit_price) {
        this.unit_price = unit_price;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }  
}
