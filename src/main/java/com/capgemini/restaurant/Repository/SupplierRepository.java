package com.capgemini.restaurant.Repository;

import com.capgemini.restaurant.Models.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SupplierRepository extends CrudRepository<Supplier, Integer> {


}