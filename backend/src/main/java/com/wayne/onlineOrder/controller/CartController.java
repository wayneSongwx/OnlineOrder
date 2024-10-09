package com.wayne.onlineOrder.controller;

import com.wayne.onlineOrder.entity.Cart;
import com.wayne.onlineOrder.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CartController {

  @Autowired
  private CartService cartService;

  @RequestMapping(value = "/cart", method = RequestMethod.GET)
  @ResponseBody
  public Cart getCart(){
    return cartService.getCart();
  }
}

