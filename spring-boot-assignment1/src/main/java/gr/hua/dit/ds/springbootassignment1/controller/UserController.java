package gr.hua.dit.ds.springbootassignment1.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import gr.hua.dit.ds.springbootassignment1.entity.User;
import gr.hua.dit.ds.springbootassignment1.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	public List<User> retrieveAllStudents() {
		return userRepository.findAll();
	}
	
	@GetMapping("/users/{email}")
	public User retrieveUser(@PathVariable Integer email) {
		Optional<User> user = userRepository.findById(email);

		if (!user.isPresent())
			throw new UserNotFoundException();

		return user.get();
	}
	
	@DeleteMapping("/users/{email}")
	public void deleteUser(@PathVariable Integer email) {
		userRepository.deleteById(email);
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		User savedUser = userRepository.save(user);
		System.out.println("user email " + savedUser.getEmail());

		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{email}")
				.buildAndExpand(savedUser.getEmail()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/users/{email}")
	public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable Integer email) {

		Optional<User> userOptional = userRepository.findById(email);

		if (!userOptional.isPresent())
			return ResponseEntity.notFound().build();

		user.setId(email);
		
		userRepository.save(user);

		return ResponseEntity.noContent().build();
	}
}