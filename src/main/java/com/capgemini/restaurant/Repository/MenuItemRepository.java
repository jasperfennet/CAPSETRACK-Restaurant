package com.capgemini.restaurant.Repository;

import com.capgemini.restaurant.Models.MenuItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository extends CrudRepository<MenuItem, Integer> {


}
