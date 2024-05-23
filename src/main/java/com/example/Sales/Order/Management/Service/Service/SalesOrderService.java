package com.example.Sales.Order.Management.Service.Service;

import com.example.Sales.Order.Management.Service.Model.SalesOrder;

import java.util.Optional;

public interface SalesOrderService {
    public SalesOrder createSalesOrder(String customerId, SalesOrder salesOrder);
    public SalesOrder updateSalesOrder(long orderId, SalesOrder salesOrderDetails);
    Optional<SalesOrder> getSalesOrder(long orderId);
}
