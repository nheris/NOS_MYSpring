package com.winter.app.counties;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/country/*")//
public class CountryController {
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list() {
		return "country/list";
	}
}
