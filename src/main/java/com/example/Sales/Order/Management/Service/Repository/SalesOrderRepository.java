package com.example.Sales.Order.Management.Service.Repository;

import com.example.Sales.Order.Management.Service.Model.SalesOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesOrderRepository extends JpaRepository<SalesOrder, Long> {
}
