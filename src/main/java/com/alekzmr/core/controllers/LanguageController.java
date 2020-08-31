package com.alekzmr.core.controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.LocaleResolver;

@RestController
@RequestMapping("/lang")
public class LanguageController {
	
	@Autowired
	private LocaleResolver lr;
	
	@Autowired
	private HttpServletRequest servletRequest;
	
	@Autowired
	private HttpServletResponse servletResponse;
	
	@GetMapping("/{loc}")
	public ResponseEntity<Void> ChangeLocale(@PathVariable("loc") String loc){
		Locale  uLocale = null;
		
		switch (loc) {
		case "en":
			uLocale = Locale.ENGLISH;
			break;

		default:
			uLocale = Locale.ROOT;
			break;
		}
		
		lr.setLocale(servletRequest, servletResponse, uLocale);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
