package club.imgurl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@RequestMapping(value = "/")
	public ModelAndView index() {
		return new ModelAndView("/index");
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {
		return new ModelAndView("/about");
	}

}
