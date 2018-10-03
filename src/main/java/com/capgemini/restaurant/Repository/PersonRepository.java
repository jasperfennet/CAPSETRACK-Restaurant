package com.capgemini.restaurant.Repository;

import com.capgemini.restaurant.Models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PersonRepository<T extends Person> extends CrudRepository<Person, Integer> {
}
