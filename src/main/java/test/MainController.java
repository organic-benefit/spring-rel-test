package test;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by DONGCHULKIM on 2016-12-21.
 */
@Controller
public class MainController {

	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping("/guest")
	public String main() throws Exception {
		return "main";
	}

	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping("/user")
	public String main2() throws Exception {
		return "testPage";
	}

	/**
	 * Using Customized authorization annotation
	 *
	 * @return
	 * @throws Exception
	 */
	@AuthorizeTo("ROLE_USER")
	@RequestMapping("/auth")
	@ResponseBody
	public String authorizeTo(boolean hasException) {
		if (hasException)
			throw new RuntimeException("Throwing test with AOP");
		return "testPage";
	}
}
