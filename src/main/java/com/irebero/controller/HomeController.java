
package com.irebero.controller;


import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.irebero.Dao.RoleDao;
import com.irebero.Dao.UserDao;
import com.irebero.Domain.PenTable;
import com.irebero.Domain.PigFarmingUsers;
import com.irebero.Domain.Pigsty;
import com.irebero.Domain.User;
import com.irebero.Security.Role;
import com.irebero.Security.UserRole;
import com.irebero.Service.OwnerService;
import com.irebero.Service.PenService;
import com.irebero.Service.PigstyService;
import com.irebero.Service.UserService;

@Controller
public class HomeController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserDao userDao;
	@Autowired
	private OwnerService ownerservice;
	@Autowired
	private PigstyService pigstyservice;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private BCryptPasswordEncoder passencrypt;
	@Autowired
	private RoleDao roleService;
	@Autowired
	private PenService penservice;
	
	private static final Logger logger = LoggerFactory.getLogger(PigstyController.class);

	@RequestMapping("/")
	public String home() {
		return "redirect:/index";
	}

	@RequestMapping("/index")
	public String index(Principal principal) {
		return "index";
	}

	@RequestMapping(value = "/CheckEmail")
	public String email(Principal principal) {

		return "/CheckEmail";
	}

	@RequestMapping(value = "/CheckEmail", method = RequestMethod.POST)
	public String changepassword(@ModelAttribute("user") User user, Model model, BindingResult bindingResult)
			throws Exception {

		try {
			if (bindingResult.hasErrors()) {
				return "redirect:/CheckEmail?flagsaved";
			} else if (userService.checkEmailExists(user.getEmail())) {
				User use = userService.findByEmail(user.getEmail());
				use.setCode(UUID.randomUUID().toString());
				use.setEnabled(false);
				userService.save(use);
				// userService.SendNotification(use);
				return "index";
			} else {

				model.addAttribute("emailnotexist", true);
				return "redirect:/CheckEmail?error";
			}
		} catch (Exception e) {
			// TODO: handle exception
			return "redirect:/CheckEmail?error";
		}
	}

	@RequestMapping(value = "/ConfirmPassword", method = RequestMethod.GET)
	public String renewpasswd(@ModelAttribute("idy") String id, Model model, Authentication auth, Principal principal,
			User user) {
		User us = userService.findBycode(id);
		System.out.println("here the id" + us.getCode());
		if (us.getCode().equals(null)) {
			return "index";
		} else {
			model.addAttribute("users", us);
			return "/ConfirmPassword";
		}
	}

	@RequestMapping(value = "/ConfirmPassword", method = RequestMethod.POST)
	public String passwdrenew(@ModelAttribute("idy") String id, @ModelAttribute("user") @Valid User user,
			BindingResult bindingResult

			, Model model, Authentication auth, Principal principal) {

		User use1 = userService.findBycode(id);
		use1.setCode(UUID.randomUUID().toString());
		use1.setEnabled(true);
		System.out.println("==============================" + user.getPassword());
		String encryptp = passencrypt.encode(user.getPassword());

		use1.setPassword(encryptp);
		userService.save(use1);
		return "redirect:/index";
	}

	@RequestMapping(value = "/BranchForm")
	public String gCl(Principal principal, Model model, Authentication auth) {

		return "/BranchForm";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model, Authentication auth, Principal principal) {
		User user = new User();
		List<Role> allRoles = roleDao.findAllRoles();
		model.addAttribute("allRoles", allRoles);
		model.addAttribute("user", user);
		// viewRoles(model, auth, principal);
		return "signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signupPost(@ModelAttribute("user") User user, @ModelAttribute("dte") String da,
			@ModelAttribute("jdte") String jda, @ModelAttribute("roleType") String roleType, Model model)
			throws Exception {

		try {
			if (userService.checkUserExists(user.getUsername(), user.getEmail())) {
				if (userService.checkEmailExists(user.getEmail())) {
					model.addAttribute("emailExists", true);
				}

				else if (userService.checkUsernameExists(user.getUsername())) {
					model.addAttribute("usernameExists", true);

				}
				return "signup";
			} else {
				Set<UserRole> userRoles = new HashSet<>();
				System.out.println("ngiyi role" + roleType);
				//we use it 
				userRoles.add(new UserRole(user, roleDao.findByName(roleType)));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//				user.setRole(roleType);
				user.setJoindate(sdf.parse(jda));
				user.setDob(sdf.parse(da));
				userService.createUser(user, userRoles);
				return "redirect:/";

			}

		} catch (Exception e) {
			System.out.println("here-==========0=--------------------------" + user.getRole());
			return e.getMessage();

		}

	}

	public void viewRoles(Model model, Authentication auth, Principal principal) {
		String role = userService.userRole(auth);
		String name = principal.getName();
		// System.out.println(role);
		model.addAttribute("name", name);
		model.addAttribute("role", role);
		
	}

	@RequestMapping("/ViewUsers")
	public String viewuser(Model model) {
		List<User>users=userService.listusers();
		model.addAttribute("users", users);
		return "ViewUsers";
	}
	@RequestMapping(value = "/newRole", method = RequestMethod.GET)
	public String getRole(Model model, Role role) {
		model.addAttribute("role", role);
		return "newRole";
	}

	@RequestMapping(value = "/createRole", method = RequestMethod.POST)
	public String createRole(@ModelAttribute("role") Role role, @ModelAttribute("roleId") String roleId,
			Principal principal, Model model, Authentication auth) {
		viewRoles(model, auth, principal);
		role.setRoleId(Integer.parseInt(roleId));
		roleService.save(role);
		return "redirect:/signup";
	}

	@RequestMapping(value = "/deleteRole")
	public String updateRole(@RequestParam("name") String name, Principal principal, Model model, Authentication auth) {
		viewRoles(model, auth, principal);
		Role role = roleService.findByName(name);
		roleService.delete(role);
		return "redirect:/newRole";
	}
	@RequestMapping("/dashboard")
	public String dashboard(Principal principal, Model model, Authentication auth) {
		User user = userService.findByUsername(auth.getName());
		String role = userService.userRole(auth);
		model.addAttribute("role", role);
		model.addAttribute("user", user);
		logger.info(user.getFname()+' '+user.getLname());
		//list to populate the size of data content available in our database
		List<PenTable> pens=penservice.findpen();
		String pencount=pens.size()+"";
		model.addAttribute("pencount",pencount);
		List<PigFarmingUsers>owners=ownerservice.findowner();
		String usercount=owners.size()+"";
		model.addAttribute("usercount",usercount);
		List<Pigsty>pigsts=pigstyservice.listall();
		String pigstycount=pigsts.size()+"";
		model.addAttribute("pigstycount",pigstycount);
		return "dashboard";
	}
	
	//method to update user of the system
	@RequestMapping(value = "/userprofile", method = RequestMethod.GET)
	public String profile(Principal principal, Model model, Authentication auth) {
		//get the logged username
		User user = userService.findByUsername(principal.getName());
		//get the userrole
		user = userService.findByUsername(auth.getName());
		String role = userService.userRole(auth);
		model.addAttribute("role", role);
		model.addAttribute("user", user);

		return "/userpro";
	}

	@RequestMapping(value = "/userprofile", method = RequestMethod.POST)
	public String profilePost(@ModelAttribute("user") User newUser, Model model, RedirectAttributes redirectAttributes) {
		System.out.println("=======================================================");
		try {
			User user = userService.findByUsername(newUser.getUsername());
			user.setUsername(newUser.getUsername());
			user.setFname(newUser.getFname());
			user.setLname(newUser.getLname());
			user.setEmail(newUser.getEmail());
			user.setPassword(newUser.getPassword());
			user.setCode(UUID.randomUUID().toString());
			model.addAttribute("user", user);

			userService.saveuser(user);
			logger.info("well saved");
			redirectAttributes.addFlashAttribute("info", "well done");
			return "redirect:/index";
		} catch (Exception e) {
			return "redirect:/index?error";
		}

	}
	
	@RequestMapping(value = "enable")
	public String enable(@RequestParam("id") Long userID, Principal principal, Model model,
			Authentication auth) {
		User user = userDao.findByid(userID);
		user.setEnabled(true);
		userService.save(user);
		return "redirect:/ViewUsers";
	}
	
	@RequestMapping(value = "disable")
	public String disable(@RequestParam("id") Long userID, Principal principal, Model model,
			Authentication auth) {
		User user = userDao.findByid(userID);
		user.setEnabled(false);
		userService.save(user);
		return "redirect:/ViewUsers";
	}
}
