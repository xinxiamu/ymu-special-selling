package co.ymu.spcselling.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController("/user")
public class UserController {

	@Value("${user.username}")
	private String username;

	@RequestMapping("/getUserName")
	public String getUserName() {
		return this.username;
	}
}
