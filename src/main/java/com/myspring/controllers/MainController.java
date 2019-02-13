package com.myspring.controllers;
import com.myspring.classes.DBUtil;
import com.myspring.classes.Items;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class MainController {

    @RequestMapping(value = {"index", "/"})
    public ModelAndView indexPage(){

        DBUtil dbUtil = new DBUtil();
        ArrayList<Items> arrayList = dbUtil.getAllList();

        return new ModelAndView("index").addObject("list", arrayList);
    }

    @RequestMapping(value = "editPage", method = RequestMethod.GET)
    public ModelAndView editPage(@RequestParam(name = "id") Long id){

        DBUtil dbUtil = new DBUtil();
        Items items = dbUtil.getItemById(id);

        return new ModelAndView("editPage").addObject("item", items);
    }

    @RequestMapping(value = "addItem", method = RequestMethod.POST)
    public String addItem(@RequestParam(name = "name") String name, @RequestParam(name = "price") double price){

        DBUtil dbUtil = new DBUtil();
        dbUtil.addItem(name, price);
        return "redirect:/index";

    }


}