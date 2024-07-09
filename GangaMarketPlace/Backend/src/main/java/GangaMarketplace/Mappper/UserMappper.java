package GangaMarketplace.Mappper;

import GangaMarketplace.dto.UserDTO;
import GangaMarketplace.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserMappper {
    private static final Logger logger = LoggerFactory.getLogger(UserMappper.class);

    public static UserDTO mapToUserDto(User user) {
        logger.info("Mapping User entity to UserDTO: {}", user);
        UserDTO userDTO = new UserDTO(
                user.getId(),
                user.getName(),
                user.getAddress(),
                user.getTelephoneNumber(),
                user.getEmail(),
                user.getUserName(),
                user.getPassword()
        );
        logger.info("Mapped UserDTO: {}", userDTO);
        return userDTO;
    }

    public static User mapToUser(UserDTO userDTO) {
        logger.info("Mapping UserDTO to User entity: {}", userDTO);
        User user = new User(
                userDTO.getId(),
                userDTO.getName(),
                userDTO.getAddress(),
                userDTO.getTelephoneNumber(),
                userDTO.getEmail(),
                userDTO.getUserName(),
                userDTO.getPassword()
        );
        logger.info("Mapped User entity: {}", user);
        return user;
    }
}