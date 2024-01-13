package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CoffeeModel {
    String name;
    String price;
    String items;
    String total;
}
