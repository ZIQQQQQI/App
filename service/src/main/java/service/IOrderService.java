package service;

import domain.Orders;

import java.util.List;

public interface IOrderService {
    List<Orders> findAll(int page,int size);

    Orders findById(String id);
}
