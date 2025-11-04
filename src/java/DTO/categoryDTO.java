package DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class categoryDTO {
    private String categoryId;
    private String categoryName;

    public categoryDTO() {
    }



    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public categoryDTO(String categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "categoryDTO{" + "categoryId=" + categoryId + ", categoryName=" + categoryName + '}';
    }
    
    
}
