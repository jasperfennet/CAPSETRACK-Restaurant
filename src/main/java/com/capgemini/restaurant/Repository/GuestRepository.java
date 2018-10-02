package com.capgemini.restaurant.Repository;

import com.capgemini.restaurant.Models.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GuestRepository extends CrudRepository<Guest, Integer> {


}
