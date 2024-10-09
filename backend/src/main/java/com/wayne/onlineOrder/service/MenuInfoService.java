package com.wayne.onlineOrder.service;

import com.wayne.onlineOrder.dao.MenuInfoDao;
import com.wayne.onlineOrder.entity.MenuItem;
import com.wayne.onlineOrder.entity.Restaurant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuInfoService {

  @Autowired
  private MenuInfoDao menuInfoDao;

  public List<Restaurant> getRestaurants() {
    return menuInfoDao.getRestaurants();
  }

  public List<MenuItem> getAllMenuItem(int restaurantId) {
    return menuInfoDao.getAllMenuItem(restaurantId);
  }

  public MenuItem getMenuItem(int id) {
    return menuInfoDao.getMenuItem(id);
  }
}
