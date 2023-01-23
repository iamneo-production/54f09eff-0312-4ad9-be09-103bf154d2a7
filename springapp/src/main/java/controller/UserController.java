package controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dao.IBooking;
import dao.IMovies;
import dao.IUser;
import model.Booking;
import model.Movies;
import model.User;

@RestController
public class UserController {

	@Autowired
	IUser user;
	@Autowired
	IBooking booking;
	@Autowired
	IMovies movies;
	
	@PostMapping("/login")
	public String adminLogin(@RequestBody  User u) {
		user.findById(u.getUid());
		return "Logged In Successfully";
	}

	@PostMapping("/signup")
	public String signu(@RequestBody User u){
		user.save(u);
		return "True";
	}
	
	@GetMapping("/allMovie")
	public List<Movies> allMovie() {
		return movies.findAll();
	}
	
	@GetMapping("/movie/{mid}")
	public String getMovies(@PathVariable("mid") int mid) {
		return movies.findById(mid).get().getMname();	
	}
	
	@PostMapping("book")
	public String book(@RequestBody Booking b){
		booking.save(b);
		return "true";
	}
	
	@GetMapping("/allBooking")
	public List<Booking> allBooking() {
		return booking.findAll();
	}
	
	@DeleteMapping("/cancelBooking/{bid}")
	public String cancelBooking(@PathVariable("bid") int bid) {
		booking.deleteById(bid);
		return "Booking Canceled";
	}	
}
