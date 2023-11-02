package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}


	@GetMapping()
	public String getUsers(ModelMap model) {
		model.addAttribute("users", userService.getUsers());
		return "/users/index";
	}

	@GetMapping(value = "/user")
	public String getUser(ModelMap model, @RequestParam(value = "id", required = false) Long id) {
		model.addAttribute("user", userService.getUserById(id));
		return "/users/show";
	}

	@GetMapping("/new")
	public String newUser(ModelMap model) {
		model.addAttribute("newUser", new User());
		return "/users/new";
	}

	@PostMapping("/create")
	public String createUser(@ModelAttribute("user") User user) {
		userService.createUser(user);
		return "redirect:/";
	}

	@GetMapping("/edit")
	public String editUser(Model model, @RequestParam(value = "id", required = false) Long id) {
		model.addAttribute("editUser", userService.getUserById(id));
		return "/users/edit";
	}

	@DeleteMapping("/delete")
	public String deleteUser(@ModelAttribute("user") User user) {
		userService.removeUser(user);
		return "redirect:/";
	}

	@PatchMapping("/update")
	public String updateUser(@ModelAttribute("user") User user) {
		userService.updateUser(user);
		return "redirect:/";
	}

}