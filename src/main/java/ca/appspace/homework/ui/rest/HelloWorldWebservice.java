package ca.appspace.homework.ui.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldWebservice {
	
	protected static final String GET_TEXT_URL = "getText";
	
	@RequestMapping(value=GET_TEXT_URL, method={RequestMethod.POST}, produces={"text/plain"})
	public @ResponseBody String getText(@RequestBody(required=true) String input) {
		return input;
	}

}
