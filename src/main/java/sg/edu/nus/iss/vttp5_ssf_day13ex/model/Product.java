package sg.edu.nus.iss.vttp5_ssf_day13ex.model;

public class Product {
    private int itemId;
    private String itemName;
    private int itemSold;
    private int itemQuantity;
    private String image;


    // public Product() {
    //     this.image = image;
    //     this.itemId = itemId;
    //     this.itemName = itemName;
    //     this.itemQuantity = itemQuantity;
    //     this.itemSold = itemSold;
    // }
    
    
    public int getItemId() {
        return itemId;
    }
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public int getItemSold() {
        return itemSold;
    }
    public void setItemSold(int itemSold) {
        this.itemSold = itemSold;
    }
    public int getItemQuantity() {
        return itemQuantity;
    }
    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }


}


