package com.capgemini.restaurant.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public interface Credentials {

    String getUserName();
    String getPassword();
    void setUserName(String username);
    void setPassword(String password);

}
