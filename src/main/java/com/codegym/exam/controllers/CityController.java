package com.codegym.exam.controllers;

import com.codegym.exam.model.City;
import com.codegym.exam.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CityController {
    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService){
        this.cityService = cityService;
    }

    @GetMapping
    public ModelAndView showHomePage(){
        ModelAndView modelAndView = new ModelAndView("index");
        List<City> cityList = cityService.findAll();
        modelAndView.addObject(cityList);
        return modelAndView;
    }

    @GetMapping("/viewDetail/{id}")
    public ModelAndView showDetail(@PathVariable("id")long id){
        City city = cityService.findById(id);
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("city", city);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        City city = new City();
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("city", city);
        return modelAndView;
    }

    @PostMapping("/created")
    public ModelAndView creatNewCity(@Valid @ModelAttribute("city") City city, BindingResult bindingResult){
        ModelAndView modelAndView =null;
        if (bindingResult.hasFieldErrors()) {
            modelAndView = new ModelAndView("create");
        } else {
            cityService.save(city);
            modelAndView = showHomePage();
        }
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable("id")long id){
        City city = cityService.findById(id);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("city", city);
        return modelAndView;
    }

    @PostMapping("/edited/{id}")
    public ModelAndView updateCity(@PathVariable("id")long id, @Valid @ModelAttribute("city") City city, BindingResult bindingResult){
        ModelAndView modelAndView = null;
        if (bindingResult.hasFieldErrors()) {
            modelAndView = new ModelAndView("/edit");
        } else {
            cityService.save(city);
            modelAndView = showHomePage();
        }
        return modelAndView;
    }


    @GetMapping("/delete/{id}")
    public RedirectView deleteCity(@PathVariable("id")long id){
        cityService.remove(id);
        return new RedirectView("/");
    }

}
