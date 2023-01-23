package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dao.IAdmin;
import dao.IBooking;
import dao.IMovies;
import model.Booking;
import model.Movies;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	IAdmin admin;
	@Autowired
	IMovies movies;
	@Autowired
	IBooking booking;
	
	@GetMapping("/")
	public List<Movies> viewMovies(){
		return movies.findAll();
	}
	
	@PostMapping("/movie")
	public String addMovie(@RequestBody Movies m){
		movies.save(m);
		return "Movie Added Successfully";
	}

	@PutMapping("/movie/{mid}")
	public String updateBook(@RequestBody Movies b) {
		movies.findById(b.getMid()).map( update ->{
			update.setMid(b.getMid());
			update.setMname(b.getMname());
			return movies.save(update);
		});
		return "Movie Updated";
	}
	@DeleteMapping("/movie/{mid}")
	public String deleteMovie(@PathVariable("mid") int mid) {
		movies.deleteById(mid);
		return "Movie Deleted";
	}
	
	@PostMapping("/allBooking")
	public List<Booking> allBooking(){	
		return booking.findAll();
	}
	
}
