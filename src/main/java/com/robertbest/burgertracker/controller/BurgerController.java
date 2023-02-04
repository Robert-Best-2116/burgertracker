package com.robertbest.burgertracker.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.robertbest.burgertracker.models.Burger;
import com.robertbest.burgertracker.services.BurgerService;

@Controller
public class BurgerController {
	
	@Autowired
	BurgerService burgerService;
	
	@GetMapping("/") 
		public String index(){
		return "redirect:/burgers";
	}
	
	@GetMapping("/burgers")
		public String burgerHome(Model model, Burger burger) {
		model.addAttribute(burger);
		List<Burger> allBurgers = burgerService.allBurgers();
		model.addAttribute("allBurgers", allBurgers);
		return "index.jsp";
	}
	
	//shows allll the information!!! when theres errors!!! :DDDDD!!!
	@PostMapping("/burger/new")
		public String create(@Valid @ModelAttribute("burger") Burger burger, 
				BindingResult result,Model model ) {
		model.addAttribute(burger);
		List<Burger> allBurgers = burgerService.allBurgers();
		model.addAttribute("allBurgers", allBurgers);
		if (result.hasErrors()) {
			return "index.jsp";
		}
		burgerService.createBurger(burger);
		System.out.println(burger);
		return "redirect:/burgers";
	}
	
    @GetMapping("/burgers/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Burger burger = burgerService.findBurger(id);
        model.addAttribute("burger", burger);
        return "edit.jsp";
    }
    
    @RequestMapping(value="/burgers/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("burger") Burger burger, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            burgerService.updateBurger(burger);
            return "redirect:/";
        }
    }
    
    
	
}
