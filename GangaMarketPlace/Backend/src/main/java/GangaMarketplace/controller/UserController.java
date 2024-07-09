package GangaMarketplace.controller;

import GangaMarketplace.dto.UserDTO;
import GangaMarketplace.service.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    // Add user API
    @PostMapping(path = "/createUser")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        logger.info("Received UserDTO: {}", userDTO);
        UserDTO savedUser = userService.createUser(userDTO);
        logger.info("Saved UserDTO: {}", savedUser);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    // Add user manually API
    @GetMapping(path = "/createUserM")
    public ResponseEntity<UserDTO> createUserM() {
        UserDTO userDTO = new UserDTO(0, "abc", "abc address", "123", "abc@", "abc", "abc1");
        logger.info("Creating dummy UserDTO: {}", userDTO);
        UserDTO savedUser = userService.createUser(userDTO);
        logger.info("Saved dummy UserDTO: {}", savedUser);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    // Get user bu userID
    @GetMapping(path ="/getUserById/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Long userId)
    {
        UserDTO userDTO = userService.getUserById(userId);
        return ResponseEntity.ok(userDTO);
    }
    //Api to  get all user by
    @GetMapping(path = "/getAllUsers")
    public ResponseEntity<List<UserDTO>> getAllUser()
    {
        List<UserDTO> users= userService.getAllUser();
        return ResponseEntity.ok(users);
    }
    // Update user
    @PutMapping("/updateUser/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") Long id ,@RequestBody UserDTO updatedUser)
    {
        UserDTO updateUser= userService.updateUser(id,updatedUser);
        return ResponseEntity.ok(updateUser);
    }
}

    /*@Autowired
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
        User o1 = new User(1, "John", "404 Not found", "some numbers","xyz","xyz1","xyzp");
        userRepository.save(o1);
        return "Successfully Created Dummy DATA";
    }*/
