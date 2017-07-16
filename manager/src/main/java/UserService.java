

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User register(User user) {
		return userRepository.save(user);
	}
		
	public Collection<User> searchAll(){
		return userRepository.findAll();
	}
	
	public void remove(User user) {
		userRepository.delete(user);
	}
	
	public User getUserById(Integer id) {
		return userRepository.findOne(id);
	}
	
	public User update(User user) {
		return userRepository.save(user);
	}
}