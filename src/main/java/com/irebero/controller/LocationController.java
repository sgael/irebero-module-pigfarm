package com.irebero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.irebero.Domain.District;
import com.irebero.Domain.Province;
import com.irebero.Domain.Sector;
import com.irebero.Service.DistrictService;
import com.irebero.Service.ProvinceService;

@Controller
public class LocationController {

	@Autowired
	private ProvinceService provinceService;
	@Autowired
	private DistrictService districtService;
	
	@RequestMapping(value = "/trackForm", method = RequestMethod.GET)
	public String form(Model model) {
		Province province = new Province();
		model.addAttribute("province", province);
		return "trackForm";
	}
	
	@RequestMapping(value = "/trackForm", method = RequestMethod.POST)
	public String formPost(@ModelAttribute("province") Province province) {
		provinceService.save(province);
		return "redirect:/trackForm";
	}
	
	@RequestMapping(value = "/districtForm", method = RequestMethod.GET)
	public String formdistrict(Model model) {
		List<Province> provincelist = provinceService.findAll();
		District district = new District();
		model.addAttribute("provincelist", provincelist);
		model.addAttribute("district", district);
		return "districtForm";
	}
	
	@RequestMapping(value = "/districtForm", method = RequestMethod.POST)
	public String formdistrictPost(@ModelAttribute("district") District district, @ModelAttribute("province") String province) {
		Province prov = provinceService.findById(Long.parseLong(province));
		district.setProvince(prov);
		districtService.save(district);
		return "redirect:/districtForm";
	}
	
	@RequestMapping(value = "/sectorForm", method = RequestMethod.GET)
	public String formsector(Model model) {
		List<Province> provincelist = provinceService.findAll();
		Sector sector= new Sector();
		model.addAttribute("provincelist", provincelist);
		model.addAttribute("sector", sector);
		return "sectorForm";
	}
	
	@RequestMapping(value = "loadDistrict/{provinceId}", method = RequestMethod.GET)
	@ResponseBody
	public List<District> loadDistrict(Model model, @PathVariable("provinceId") String provinceId) {
			Province province = provinceService.findById(Long.parseLong(provinceId));
			System.out.println(province.getName());
			List<District> districtList = districtService.findAllByProvince(province);
			return districtList;
	}
}
