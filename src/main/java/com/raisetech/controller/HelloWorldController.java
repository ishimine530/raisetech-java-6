package com.raisetech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.raisetech.form.Form;

@Controller
public class HelloWorldController {
	@ModelAttribute
	public Form setUpForm() {
		return new Form();
	}

	@GetMapping("/")
	public String helloWorld(Model model) {
		model.addAttribute("message", "Hello World");
		return "index";
	}

	@PostMapping("/")
	public String confirmView(@Validated Form form, BindingResult bindingResult, Model model) {
		model.addAttribute("message", "Hello World");

		if (bindingResult.hasErrors()) {
			return "index";
		}
		
		model.addAttribute("message", "登録完了");
		return "confirm";
	}
}
