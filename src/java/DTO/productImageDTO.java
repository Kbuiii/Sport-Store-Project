package DTO;

import java.io.Serializable;

public class productImageDTO implements Serializable {

    private int imageId;
    private String productId;
    private String imageBase64; // hoặc imageURL nếu bạn không lưu base64
    private boolean isMain;

    public productImageDTO() {
    }

    public productImageDTO(int imageId, String productId, String imageBase64, boolean isMain) {
        this.imageId = imageId;
        this.productId = productId;
        this.imageBase64 = imageBase64;
        this.isMain = isMain;
    }

    // getter & setter
    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getImageBase64() {
        return imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }

    public boolean isIsMain() {
        return isMain;
    }

    public void setIsMain(boolean isMain) {
        this.isMain = isMain;
    }
}
