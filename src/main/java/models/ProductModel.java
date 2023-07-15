package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductModel {
    String link;
    String price;
    String size;
    String color;
    byte rating;
    int reviewCount;
}
