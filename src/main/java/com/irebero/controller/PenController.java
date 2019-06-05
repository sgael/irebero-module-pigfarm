package com.irebero.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.irebero.Domain.PenTable;
import com.irebero.Domain.PigFarmingUsers;
import com.irebero.Service.OwnerService;
import com.irebero.Service.PenService;

@Controller
public class PenController {
	
	@Autowired
	private PenService penService;
	
	@Autowired
	private OwnerService ownerService;
	
	private static final Logger logger = LoggerFactory.getLogger(PenController.class);
	
	@RequestMapping(value="/PenForm",method=RequestMethod.GET)
	private String newpen(Model model) {
		PenTable pe=new PenTable();
		model.addAttribute("pe",pe);
		model.addAttribute("owner",ownerService.findowner());
		return "/PenForm";
	}
	@RequestMapping(value="/PenForm",method=RequestMethod.POST)
	private String savepen(@ModelAttribute("pe") @Valid PenTable pe,@ModelAttribute("own") String owner ,BindingResult result,RedirectAttributes redirectAttributes,Model model) {
		
		try {
			if(result.hasErrors())
			{
				logger.error("something went wrong");
				redirectAttributes.addFlashAttribute("error","something went0 wrong");
				return "/PenForm?error";
				
			}
			else if(!penService.CheckCategoryExist(pe.getCategory())) 
			{
				penService.savepen(pe);
				logger.info("well done");
				redirectAttributes.addFlashAttribute("info","well done");
				
			}else {
				return "redirect:/PenForm?already";
			}
			return"redirect:/PenForm?flagsaved";
			
			
			
		} catch (Exception e) {
			logger.error("something went wrong");
			redirectAttributes.addFlashAttribute("error","something went0 wrong");
			return e.getMessage();
			
		}
		
		
	}
	
	@RequestMapping(value = "/editpen", method = RequestMethod.POST)
	public String update(@ModelAttribute("id") Long id, @ModelAttribute("size") String size, @ModelAttribute("category") String category,Model model) {
		PenTable pen=penService.findById(id);
		
		model.addAttribute("category",category);
		model.addAttribute("size",size);
		penService.savepen(pen);
		return "redirect:/ViewPen";
	}
	
	@RequestMapping("/ViewPen")
	public String viewpen(Model model) {
		List<PenTable> list = penService.findpen();
		model.addAttribute("list", list);
		return "ViewPen";
	}

	@RequestMapping("/delet")
	public String removepen(@RequestParam("id") Long id) {
		PenTable pen=penService.findOne(id);
		penService.delete(pen);
		return "redirect:/ViewPen";
	}
}
