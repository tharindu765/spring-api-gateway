package lk.ijse.user_service.service;


import lk.ijse.user_service.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO registerUser(UserDTO dto);
    UserDTO getUserById(String id);
    List<UserDTO> getAllUsers();
    void deleteUser(String id);
}
