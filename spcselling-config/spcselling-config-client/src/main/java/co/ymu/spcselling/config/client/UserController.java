package co.ymu.spcselling.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RefreshScope
@RestController
public class UserController {

	@Value("${logging.config}")
	private String logPath;


	@RequestMapping("/getUserName")
	public String getUserName() {
		return this.logPath;
	}

	@RequestMapping("/sex")
	public String sex() {
		return this.logPath;
	}
}
