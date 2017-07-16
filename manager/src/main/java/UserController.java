

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	
	@RequestMapping(value="/users", method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)	
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		User registeredUser = userService.register(user);
		return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);	
	}
	
	@RequestMapping(value="/users", method=RequestMethod.GET,
			consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)	
	public ResponseEntity<Collection<User>> searchAllUsers() {
		Collection<User> myUsers = userService.searchAll();
		return new ResponseEntity<>(myUsers, HttpStatus.FOUND);
	}
	
	@RequestMapping(value="/users/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<User> removeUser (@PathVariable Integer id) {
		User removedUser = userService.getUserById(id);
		if (removedUser == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		userService.remove(removedUser);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/users", method=RequestMethod.PUT)
	public ResponseEntity<User> updateUser (@RequestBody User user) {
		userService.update(user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	
}
