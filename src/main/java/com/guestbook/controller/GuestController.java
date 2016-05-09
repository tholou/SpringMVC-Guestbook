package com.guestbook.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.guestbook.model.Guest;
import com.guestbook.repository.GuestRepository;


@Controller
//@RequestMapping("/guests")
public class GuestController {
	
	@Autowired
	GuestRepository repo;
	
	/*public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @RequestMapping(value="/", method=RequestMethod.GET)
    public String showForm(GuestForm guestForm) {
        return "form";
    }

    @RequestMapping(value="/", method=RequestMethod.POST)
    public String checkPersonInfo(@Valid GuestForm guestForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "form";
        }

        return "redirect:/results";
    }*/

	
	@RequestMapping(value="/guests")
	public String listGuests(Model model){
		model.addAttribute("guests", repo.findAll());
		//model.addAttribute("form", form);
		return "guests/list";		
	}
	
	@RequestMapping(value="/guests/form")
	public String form(Model model){
		model.addAttribute("guest", new Guest());
		return "guests/create";		
	}
	
	@RequestMapping(value="/guests", method=RequestMethod.POST)
	public String addGuests(@Valid Guest guest, BindingResult result){
		if(result.hasErrors()) {
            return "guests/create";
        }
		repo.saveAndFlush(guest);
	    return "redirect:/guests";
			
	}

}
