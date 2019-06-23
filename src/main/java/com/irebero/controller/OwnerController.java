package com.irebero.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.irebero.Domain.PigFarmingUsers;
import com.irebero.Domain.Pigsty;
import com.irebero.Service.OwnerService;

@Controller
public class OwnerController {

	@Autowired
	private OwnerService ownerService;
	
	private static final Logger logger = LoggerFactory.getLogger(OwnerController.class);
	
	@RequestMapping(value="/OwnerForm",method=RequestMethod.GET)
	private String newowner(Model model) {
		
		PigFarmingUsers owner=new PigFarmingUsers();
		model.addAttribute("owner",owner);
		return "/OwnerForm";
		
	}
	@RequestMapping(value="/OwnerForm",method=RequestMethod.POST)
	private String saveOwner(@ModelAttribute("owner") @Valid PigFarmingUsers owner,@ModelAttribute("gender") String gender,BindingResult bindingResult,Model model,RedirectAttributes redirectAttributes) {
		
		if(bindingResult.hasErrors())
		{
			logger.error("something went wrong");
			redirectAttributes.addFlashAttribute("error","something went0 wrong");
			return "/OwnerForm";
			
		}
		
		ownerService.saveowner(owner);
		logger.info("well done");
		redirectAttributes.addFlashAttribute("info","well done");
		return"redirect:/OwnerForm";
		
	}
	
	@RequestMapping(value = "/editown", method = RequestMethod.POST)
	public String update(@ModelAttribute("id") String id, @ModelAttribute("location") String location, @ModelAttribute("address") String address,
			@ModelAttribute("gender") String gender,@ModelAttribute("contact") String contact, Model model) {
		PigFarmingUsers own = ownerService.findById(Long.parseLong(id));
		own.setAddress(address);
		own.setGender(gender);
		own.setPhone(contact);
		ownerService.saveowner(own);
		return "redirect:/ViewOwner";
	}
	
	
	@RequestMapping("/ViewOwner")
	public String viewowner(Model model) {
		List<PigFarmingUsers> list = ownerService.findowner();
		model.addAttribute("list", list);
		return "ViewOwner";
	}
	@RequestMapping("/del")
	public String deny(@RequestParam("id") Long id) {
		PigFarmingUsers ow=ownerService.findOne(id);
		ownerService.delete(ow);
		return "redirect:/ViewOwner";
	}
	
//	@RequestMapping(value = "/findOwn")
//	public String find(@RequestParam("id") Long id) {
//		PigFarmingUsers ow=ownerService.findOne(id);
//		System.out.println("ngaha"+ow.getFirstname());
//		return "redirect:/tables";
//	}
//	@RequestMapping(value = "/findOne", method = RequestMethod.GET)
//    @ResponseBody
//	public PigFarmingUsers finduno(Long id) {
//		logger.error("our Id********************" +id);
//		return ownerService.findOne(id);
//	}
	@RequestMapping("/own/{id}")
	public String owner(@PathVariable("id") Long id, ModelMap model) {
		PigFarmingUsers own=ownerService.findOne(id);
		model.addAttribute("address", own.getAddress());
        model.addAttribute("gender", own.getGender());
        model.addAttribute("contact", own.getPhone());
		 return "ViewOwner :: modalContents";
	}
}

