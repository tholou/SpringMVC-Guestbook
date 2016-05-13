package com.guestbook.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guestbook.model.Guest;
import com.guestbook.model.GuestReply;
import com.guestbook.repository.GuestReplyRepository;
import com.guestbook.repository.GuestRepository;


@Controller
//@RequestMapping("/guests")
public class GuestController {
	
	// A special header sent with each AJAX request
		private static final String IS_AJAX_HEADER = "X-Requested-With=XMLHttpRequest";
	
	@Autowired
	GuestRepository repo;
	@Autowired
	GuestReplyRepository repo2;
	
	@RequestMapping("/")
	String index() {
		return "redirect:/guestbook";
	}
	
	@RequestMapping(value = "/guestbook", method = RequestMethod.GET)
	String guestBook(Model model, GuestForm form) {
		
		model.addAttribute("entries", repo.findAll());
		model.addAttribute("form", form);

		return "guestbook";
	}
	
	@RequestMapping(value = "/guestbook", method = RequestMethod.POST)
	String addEntry(@Valid GuestForm form, BindingResult binding, Model model) {

		if (binding.hasErrors()) {
			//model.addAttribute("org.springframework.validation.BindingResult.messageForm", binding);
			model.addAttribute("validationError", "不正な値が入力されました。");
			return guestBook(model, form);
		}

		repo.save(new Guest(form.getName(), form.getEmail(), form.getComment()));
		return "redirect:/guestbook";
	}
	
	@RequestMapping(value = "/guestbook", method = RequestMethod.POST, headers = IS_AJAX_HEADER)
	String addEntry(@Valid GuestForm form, Model model) {
		
		/*if (result.hasErrors()) {
			result.rejectValue("email", "error.email", "Not well formated Email");
			return guestBook(model, form);
		}*/

		model.addAttribute("entry", repo.save(new Guest(form.getName(), form.getEmail(), form.getComment())));
		model.addAttribute("index", repo.count());
		return "guestbook :: entry";
	}
	
	@RequestMapping(value = "/guestreply/{guest_id}", method = RequestMethod.POST, produces="application/json")
	public @ResponseBody String addReply(@RequestBody GuestReply guestReply, @PathVariable("guest_id") Long id ){
		
		//model.addAttribute(arg0, arg1)
		GuestReply gr = new GuestReply();
		gr.setName(guestReply.getName());
		gr.setComment(guestReply.getComment());
		gr.setEmail(guestReply.getEmail());
		Guest guest = repo.findOne(id);
		gr.setGuest(guest);
		repo2.save(gr);
		
		//if(gr.getId().toString() != ""){
			return "redirect:/guestbook";
		//}else {
			//return "redirect:/guestbook";
		//}
	
}
	
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

	
	/*@RequestMapping(value="/guests")
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
			
	}*/

}
