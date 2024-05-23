package com.example.Sales.Order.Management.Service.Controll;

import com.example.Sales.Order.Management.Service.Model.SalesOrder;
import com.example.Sales.Order.Management.Service.Service.SalesOrderServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class SalesOrderController {

    @Autowired
    private SalesOrderServiceimpl salesOrderService;

    @PostMapping("/create/{customerId}")
    public ResponseEntity<?> createSalesOrder(@PathVariable("customerId") String customerId, @RequestBody SalesOrder salesOrder) {
        try {
            SalesOrder createdOrder = salesOrderService.createSalesOrder(customerId, salesOrder);
            return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{orderId}")
    public ResponseEntity<?> updateSalesOrder(@PathVariable("orderId") int orderId, @RequestBody SalesOrder salesOrderDetails) {
        try {
            SalesOrder updatedOrder = salesOrderService.updateSalesOrder(orderId, salesOrderDetails);
            return ResponseEntity.ok(updatedOrder);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get/{orderId}")
    public ResponseEntity<?> getSalesOrder(@PathVariable("orderId") int orderId) {
        return salesOrderService.getSalesOrder(orderId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
