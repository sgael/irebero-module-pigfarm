package com.irebero.controller;

import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.irebero.Domain.Pig;
import com.irebero.Service.PigService;

@Controller
public class PigController {

	@Autowired
	PigService pigService;
	
	private static final Logger logger = LoggerFactory.getLogger(PigController.class);
	
	@RequestMapping(value="/NewPig",method=RequestMethod.GET)
	private String newpig(Model model) {
		Pig pe=new Pig();
		model.addAttribute("pe", pe);
		return "/NewPig";
	}
	@RequestMapping(value="/NewPig",method=RequestMethod.POST)
	private String savepi(@ModelAttribute("pe") @Valid Pig pe , @ModelAttribute("dte") String da,Model model,BindingResult result,RedirectAttributes redirectattributes) {
		try {
			if(result.hasErrors()) {
				logger.error("something wrong");
				redirectattributes.addFlashAttribute("error", "verify well something went wrong");
				return "/NewPig?error";
			}else {
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");;
				pe.setDob(sdf.parse(da));
				pigService.savepig(pe);
			logger.info("well saved");
			redirectattributes.addFlashAttribute("info","well done");
			return "redirect:/NewPig?flagsaved";
			}
		} catch (Exception e) {
			logger.error("something went wrong");
			redirectattributes.addFlashAttribute("error","something went0 wrong");
			return e.getMessage();
		}
		
		
	}
}
