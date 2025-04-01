package model;

import java.time.LocalDate;

public class Product {

    private Long      productId;
    private String    name;
    private LocalDate dateSupplied;
    private int       quantityStock;
    private double    unitPrice;

    public Product(Long productId, String name, LocalDate dateSupplied, int quantityStock, double unitPrice) {
        this.productId = productId;
        this.name = name;
        this.dateSupplied = dateSupplied;
        this.quantityStock = quantityStock;
        this.unitPrice = unitPrice;
    }

    public Product(Long productId, String name){
        this.productId = productId;
        this.name = name;
    }

    public Product(){
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateSupplied() {
        return dateSupplied;
    }

    public void setDateSupplied(LocalDate dateSupplied) {
        this.dateSupplied = dateSupplied;
    }

    public int getQuantityStock() {
        return quantityStock;
    }

    public void setQuantityStock(int quantityStock) {
        this.quantityStock = quantityStock;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
               "productId=" + productId +
               ", name='" + name + '\'' +
               ", dateSupplied=" + dateSupplied +
               ", quantityStock=" + quantityStock +
               ", unitPrice=" + unitPrice +
               '}';
    }


    public String getJson(){
        return String.format("{\"productId\": %d," +
                             "\"name\": %s," +
                             "\"dateSupplied\": %s," +
                             "\"quantityStock\": %d," +
                             "\"unitPrice\": %s }", productId,name,dateSupplied,quantityStock,unitPrice);
    }

    public String getXml(){
        return String.format("<product " +
                                "productId=\"%d\" " +
                                "name=\"%s\" " +
                                "dateSupplied=\"%s\" " +
                                "quantityInStock=\"%d\" " +
                                "unitPrice=\"%s\" />", productId,name,dateSupplied,quantityStock,unitPrice);
    }

    public String getCsv(){
        return String.format("%d, %s, %s, %d, %s", productId,name,dateSupplied,quantityStock,unitPrice);
    }
}
