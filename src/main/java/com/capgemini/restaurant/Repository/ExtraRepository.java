package com.capgemini.restaurant.Repository;

import com.capgemini.restaurant.Models.Extra;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtraRepository extends CrudRepository<Extra, Integer> {
}
