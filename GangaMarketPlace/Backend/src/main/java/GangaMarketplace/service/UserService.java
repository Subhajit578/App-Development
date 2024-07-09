package GangaMarketplace.service;

import GangaMarketplace.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    UserDTO getUserById(Long userId);
    List<UserDTO> getAllUser();
    UserDTO updateUser(Long userId, UserDTO updatedUser);
    /*UserDTO getUserByUserName(String userName);*/
}
