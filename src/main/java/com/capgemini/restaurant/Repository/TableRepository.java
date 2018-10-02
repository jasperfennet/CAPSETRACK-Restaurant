package com.capgemini.restaurant.Repository;

import com.capgemini.restaurant.Models.Table;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TableRepository extends CrudRepository<Table, Integer> {

}
