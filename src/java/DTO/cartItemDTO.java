/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Admin
 */
public class cartItemDTO {

    private int cartItemId;
    private int cartId;
    private int orderQuantity;
    private String size;
    private String color;
    private productDTO product;
    
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public cartItemDTO(int cartItemId, int cartId, int orderQuantity, String size, String color, productDTO product) {
        this.cartItemId = cartItemId;
        this.cartId = cartId;
        this.orderQuantity = orderQuantity;
        this.size = size;
        this.color = color;
        this.product = product;
    }

    public cartItemDTO(int cartItemId, int cartId, int orderQuantity, productDTO product) {
        this.cartItemId = cartItemId;
        this.cartId = cartId;
        this.orderQuantity = orderQuantity;
        this.product = product;
    }

    public cartItemDTO() {
    }

    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public productDTO getProduct() {
        return product;
    }

    public void setProduct(productDTO product) {
        this.product = product;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    @Override
    public String toString() {
        return "cartItemDTO{" + "cartItemId=" + cartItemId + ", cartId=" + cartId + ", orderQuantity=" + orderQuantity + ", product=" + product + '}';
    }

}
