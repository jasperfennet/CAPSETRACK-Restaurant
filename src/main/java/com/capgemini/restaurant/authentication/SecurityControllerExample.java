package com.capgemini.restaurant.authentication;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//dit kan bij de controllers
@RestController
public class SecurityControllerExample {

//    //ROLE_ prefix is verplicht
//    @Secured("ROLE_EMPLOYEE")
//    @RequestMapping("/")
//    //etc etc
}
