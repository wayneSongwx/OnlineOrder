package com.wayne.onlineOrder.dao;

import com.wayne.onlineOrder.entity.MenuItem;
import com.wayne.onlineOrder.entity.Restaurant;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MenuInfoDao {

  @Autowired
  private SessionFactory sessionFactory;

  // https://www.baeldung.com/hibernate-criteria-queries
  public List<Restaurant> getRestaurants() {
    try (Session session = sessionFactory.openSession()) {
      CriteriaBuilder builder = session.getCriteriaBuilder();
      CriteriaQuery<Restaurant> criteria = builder.createQuery(Restaurant.class);
      criteria.from(Restaurant.class);
      return session.createQuery(criteria).getResultList();
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return new ArrayList<>();
  }



  public List<MenuItem> getAllMenuItem(int restaurantId) {
    try (Session session = sessionFactory.openSession()) {
      Restaurant restaurant = session.get(Restaurant.class, restaurantId);
      if (restaurant != null) {
        return restaurant.getMenuItemList();
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return new ArrayList<>();
  }

  public MenuItem getMenuItem(int menuItemId) {
    try (Session session = sessionFactory.openSession()) {
      return session.get(MenuItem.class, menuItemId);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }
}
