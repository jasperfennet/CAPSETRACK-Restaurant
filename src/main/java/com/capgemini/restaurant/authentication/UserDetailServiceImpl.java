package com.capgemini.restaurant.authentication;

//import com.capgemini.restaurant.Models.Employee;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//
//public class UserDetailServiceImpl implements UserDetailsService {
//
////    @Autowired
////    private PersonRepository personRepository;
//
//
////    //zowel guest als employee gemaakt worden
////    @Override
//    public User loadUserByUsername(String username) {
////        Employee employee = personRepository.getSinglePerson(username);
////        //to be made
////        return mapPersonToUser(person);
//        return null;
//    }
////    //Arrays.asList(new SimpleGrantedAuthority()) voegt rollen toe.
////    private User mapPersonToUser(Person person){
////        return new User(person.getMail(), person.getPassword(), Arrays.asList(new SimpleGrantedAuthority(person.getRole())));
////    }
//}
