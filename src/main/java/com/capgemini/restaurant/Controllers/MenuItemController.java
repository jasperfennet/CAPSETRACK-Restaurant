package com.capgemini.restaurant.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuItemController {

    @RequestMapping("/menuItem/index")
    public String menuItemIndex(){

        return "MenuItem/index";


    }
}
