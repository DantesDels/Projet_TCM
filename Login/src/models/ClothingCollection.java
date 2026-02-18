package models;

import java.util.ArrayList;

public class ClothingCollection {
    private String clothingCollectionName;
    private ArrayList<Product> clothingCollection;

    public ClothingCollection(String clothingCollectionName) {
        this.clothingCollectionName = clothingCollectionName;
        this.clothingCollection = new ArrayList<>();
    }

    public void setClothingCollectionName(String clothingCollectionName) {
        this.clothingCollectionName = clothingCollectionName;
    }

    public String getClothingCollectionName() {
        return clothingCollectionName;
    }
}
