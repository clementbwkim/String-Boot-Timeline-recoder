package com.apress.spring.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apress.spring.domain.Journal;
import com.apress.spring.repository.JournalRepository;

@Controller
public class JournalController {
	@Autowired
	JournalRepository repo;
	
	@RequestMapping("/")
	public String index(Model model) {
		//repo.findAll() = jpaRepository를 상속한 interface라서 부모가 물려준 method를 가지고 있음
		model.addAttribute("journal",repo.findAll());
		
		return "index";
	}

	@RequestMapping(value="/journal", produces= {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody List<Journal> getJournal(){
		return repo.findAll();
	}
	
}
