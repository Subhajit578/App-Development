package GangaMarketplace.service.Implementation;

import GangaMarketplace.Mappper.UserMappper;
import GangaMarketplace.dto.UserDTO;
import GangaMarketplace.entity.User;
import GangaMarketplace.exception.ResourceNotFoundException;
import GangaMarketplace.repository.UserRepository;
import GangaMarketplace.service.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        logger.info("Mapping UserDTO to User entity: {}", userDTO);
        User user = UserMappper.mapToUser(userDTO);
        logger.info("Mapped User entity: {}", user);
        User savedUser = userRepository.save(user);
        logger.info("Saved User entity: {}", savedUser);
        UserDTO savedUserDTO = UserMappper.mapToUserDto(savedUser);
        logger.info("Mapped saved User entity to UserDTO: {}", savedUserDTO);
        return savedUserDTO;
    }

    @Override
    public UserDTO getUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()
                -> new ResourceNotFoundException("User doesnot exist with the given id "+ userId));
        return UserMappper.mapToUserDto(user);
    }

    @Override
    public List<UserDTO> getAllUser() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> UserMappper.mapToUserDto(user)).collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(Long userId, UserDTO updatedUser) {
        User user = userRepository.findById(userId).orElseThrow(()
                -> new ResourceNotFoundException("User doesnot exist with the given id "+ userId));
        user.setName(updatedUser.getName());
        user.setUserName(updatedUser.getUserName());
        user.setAddress(updatedUser.getAddress());
        user.setTelephoneNumber(updatedUser.getTelephoneNumber());
        User newUser =userRepository.save(user);
        return UserMappper.mapToUserDto(user);
    }

}