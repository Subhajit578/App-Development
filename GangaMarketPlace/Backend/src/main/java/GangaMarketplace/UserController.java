package GangaMarketplace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
    @RequestMapping(method = RequestMethod.POST, path = "/users/newusers")
    public String createNewUser(@RequestBody User user)
    {
        userRepository.save(user);
        return "New User" + user.getName()+"saved";
    }
    @RequestMapping(method =RequestMethod.GET, path= "/users/getUsers")
    public List<User> getAllUsers()
    {
        List<User> results = userRepository.findAll();
        return results;
    }
    @RequestMapping(method= RequestMethod.GET, path ="/users/createUser")
    public String createDummyData(){
        User o1 = new User(1, "John", "404 Not found", "some numbers");
        userRepository.save(o1);
        return "Successfully Created Dummy DATA";
    }
}
