package com.example.Sales.Order.Management.Service.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SalesOrder {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long orderId;
        private String customerId;
        private double totalAmount;
        private String status;
        private String notes;

        @ElementCollection
    private List<OrderItem> products;

    @Embeddable
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OrderItem {
        private String productId;
        private int quantity;
        private double price;
    }
}
