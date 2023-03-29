package app.core.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/simple")
@CrossOrigin
public class SimapleController {
	@GetMapping
	public int Random() {
		return (int) (Math.random() * 101);
	}
}
