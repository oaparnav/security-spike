package security.spike;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
	@RequestMapping("/")
	public String endpoint() {
		return "Hello, world";
	}
}
