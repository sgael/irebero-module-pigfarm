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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.irebero.Domain.PenTable;
import com.irebero.Domain.PigFarmingUsers;
import com.irebero.Domain.Pigsty;
import com.irebero.Service.DistrictService;
import com.irebero.Service.OwnerService;
import com.irebero.Service.PenService;
import com.irebero.Service.PigstyService;
import com.irebero.Service.ProvinceService;

import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PigstyController {

	@Autowired
	private PigstyService pigstyService;

	@Autowired
	private OwnerService ownerService;
	@Autowired
	private PenService penService;
	// @Autowired
	// private ProvinceService provinceService;
	// @Autowired
	// private DistrictService districtService;

	private static final Logger logger = LoggerFactory.getLogger(PigstyController.class);

	@RequestMapping(value = "/BranchForm", method = RequestMethod.GET)
	public String newreg(ModelMap model) {
		Pigsty pi = new Pigsty();
		model.addAttribute("pi", pi);
		model.addAttribute("owner", ownerService.findowner());
		model.addAttribute("pen", penService.findpen());
		// model.addAttribute("prov", provinceService.findAll());
		model.addAttribute("sect", pigstyService.findSect());
		return "BranchForm";
	}

	@RequestMapping(value = "/BranchForm", method = RequestMethod.POST)
	public String save(@ModelAttribute("pi") @Valid Pigsty pi, @ModelAttribute("own") String user,
			@ModelAttribute("pe") String pentable, @ModelAttribute("sect") String sect,
			@ModelAttribute("prov") String prov, @ModelAttribute("distr") String distr, BindingResult result,
			ModelMap model, RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			logger.error("something went wrong");
			redirectAttributes.addFlashAttribute("error", "something went0 wrong");
			return "/BranchForm";

		}
		pigstyService.savepig(pi);
		logger.info("well saved");
		redirectAttributes.addFlashAttribute("info", "well done");
		return "redirect:/tables";
	}

	@RequestMapping("/tables")
	public String viewpigsty(Model model) {
		List<Pigsty> list = pigstyService.listall();
		// , @RequestParam("") Long id
		model.addAttribute("list", list);
		return "tables";
	}

	// @RequestMapping(value = "/tables/{id}")
	// public String edit(@PathVariable Long id, ModelMap model) {
	// Pigsty pig = pigstyService.findByid(id);
	// logger.error("ngiyi" + pig.getOwner());
	// model.addAttribute("pig",pig);
	// return "tables";
	// }

	@RequestMapping(value = "/editOwner", method = RequestMethod.POST)
	public String saveUpdate(@ModelAttribute("id") String id, @ModelAttribute("location") String location, @ModelAttribute("meters") String meters) throws Exception {
		 Pigsty pig = pigstyService.findById(Long.parseLong(id));
		 pig.setMeters(Double.parseDouble(meters));
		 pig.setLocation(location);
		 pigstyService.savepig(pig);
		return "redirect:/tables";
	}

	@RequestMapping(value = "/delete")
	public String disable(@RequestParam("id") Long id) {
		Pigsty pig = pigstyService.findOne(id);
		System.out.println("ngiyi" + pig.getOwner());
		pigstyService.delete(pig);
		return "redirect:/tables";
	}

	// @RequestMapping(value = "/findOne")
	// @ResponseBody
	// public String findOne(@RequestParam("id") Long id) {
	// Pigsty pig = pigstyService.findByid(id);
	// System.out.println("nguyu------------------------>>>>>>>"+pig.getOwner());
	// pigstyService.findOne(id);
	// return "redirect:/tables";
	// }

	@RequestMapping(value = "/findOne", method = RequestMethod.GET)
	@ResponseBody
	public Pigsty findOne(Long id) {
		logger.error("our Id********************" + id);
		return pigstyService.findOne(id);

	}

	@RequestMapping("/pigsty/{id}")
	public String pigsty(@PathVariable("id") Long id, ModelMap model) {
		Pigsty pigsty = pigstyService.findOne(id);
		model.addAttribute("owner", pigsty.getOwner());
		model.addAttribute("pen", pigsty.getPen());
		model.addAttribute("meters", pigsty.getMeters());
		model.addAttribute("location", pigsty.getLocation());
		return "tables :: modalContents";
	}
}
