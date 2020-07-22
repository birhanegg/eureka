package edu.miu.cs544;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

	@Autowired
	private MovieSerivceClient service;

	@GetMapping("/movie")
	public List<MovieResponse> getMovie() {
		return service.getMovie();
	}
}
