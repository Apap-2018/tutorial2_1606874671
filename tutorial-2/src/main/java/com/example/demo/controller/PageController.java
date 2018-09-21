package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PageController {
	
	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}
	
	@RequestMapping("/challenge")
	public String challenge(@RequestParam(value = "name") String name, Model model) {model.addAttribute("name", name);
		return "challenge";
	}
	
	@RequestMapping(value = {"/challenge","challenge/{name}"})
	public String challengePath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		}
		else {
			model.addAttribute("name", "KB");
		}
		return "challenge";
	}
	
	@RequestMapping("/generator")
	public String generator(@RequestParam(value = "a", required = false, defaultValue = "0") String a, @RequestParam(value = "b", required = false, defaultValue = "0") String b, Model model) {
		
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		
		if (a.equals("0")) a = "1";
		if (b.equals("0")) b = "1";
		
		int param1 = Integer.parseInt(a);
		int param2 = Integer.parseInt(b);
		
		String m = "";
		for(int i = 0; i < param1; i++) {
			m = m + "m";
		}

		String word = "h" + m;
		String result = "";
		for(int i = 0; i < param2; i++) {
			result += word + " ";
		}
		
		model.addAttribute("hm", result);
		
		return "generator";
	}
	
}
