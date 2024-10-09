package com.wayne.onlineOrder.controller;

import com.wayne.onlineOrder.entity.MenuItem;
import com.wayne.onlineOrder.entity.Restaurant;
import com.wayne.onlineOrder.service.MenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

import java.util.List;

@Controller
public class MenuInfoController {
  @Autowired
  private MenuInfoService menuInfoService;

  @RequestMapping(value = "/restaurants", method = RequestMethod.GET)
  @ResponseBody
  public List<Restaurant> getRestaurants() {
    return menuInfoService.getRestaurants();
  }

  @RequestMapping(value = "/restaurant/{restaurantId}/menu", method = RequestMethod.GET)
  @ResponseBody
  public List<MenuItem> getMenuItems(@PathVariable("restaurantId") int restaurantId) {
    return menuInfoService.getAllMenuItem(restaurantId);
  }
}
