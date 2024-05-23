package com.example.Sales.Order.Management.Service.Service;

import com.example.Sales.Order.Management.Service.Dto.CustomerDto;
import com.example.Sales.Order.Management.Service.Model.SalesOrder;
import com.example.Sales.Order.Management.Service.Repository.SalesOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SalesOrderServiceimpl implements SalesOrderService {

    @Autowired
    private SalesOrderRepository salesOrderRepository;

    @Autowired
    private CustomerManagementClient customerManagementClient;

    @Override
    public SalesOrder createSalesOrder(String customerId, SalesOrder salesOrder) {
        ResponseEntity<CustomerDto> customerResponse = customerManagementClient.getCustomer(customerId);

        if (!customerResponse.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("Customer not found");
        }

        salesOrder.setStatus("Pending");
        return salesOrderRepository.save(salesOrder);
    }

    @Override
    public SalesOrder updateSalesOrder(long orderId, SalesOrder salesOrderDetails) {
        SalesOrder salesOrder = salesOrderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Sales order not found"));

        salesOrder.setCustomerId(salesOrderDetails.getCustomerId());
        salesOrder.setTotalAmount(salesOrderDetails.getTotalAmount());
        salesOrder.setStatus(salesOrderDetails.getStatus());
        salesOrder.setNotes(salesOrderDetails.getNotes());
        salesOrder.setProducts(salesOrderDetails.getProducts());

        return salesOrderRepository.save(salesOrder);
    }

    @Override
    public Optional<SalesOrder> getSalesOrder(long orderId) {
        return salesOrderRepository.findById(orderId);
    }
}
