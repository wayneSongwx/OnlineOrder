package com.wayne.onlineOrder.service;

import com.wayne.onlineOrder.dao.OrderItemDao;
import com.wayne.onlineOrder.entity.Customer;
import com.wayne.onlineOrder.entity.MenuItem;
import com.wayne.onlineOrder.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService {

  @Autowired
  private MenuInfoService menuInfoService;

  @Autowired
  private CustomerService customerService;

  @Autowired
  private OrderItemDao orderItemDao;

  public void saveOrderItem(int menuId) {
    OrderItem orderItem = new OrderItem();
    MenuItem menuItem = menuInfoService.getMenuItem(menuId);

    Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
    String username = loggedInUser.getName();
    Customer customer = customerService.getCustomer(username);

    orderItem.setMenuItem(menuItem);
    orderItem.setCart(customer.getCart());
    orderItem.setQuantity(1);
    orderItem.setPrice(menuItem.getPrice());
    orderItemDao.save(orderItem);
  }
}
