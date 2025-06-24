package lk.ijse.user_service.service.impl;


import lk.ijse.user_service.dto.UserDTO;
import lk.ijse.user_service.entity.User;

import lk.ijse.user_service.exception.UserNotFoundException;
import lk.ijse.user_service.mapper.UserMapper;
import lk.ijse.user_service.repository.UserRepository;
import lk.ijse.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDTO registerUser(UserDTO dto) {
        User user = UserMapper.toEntity(dto);
        return UserMapper.toDTO(repository.save(user));
    }

    @Override
    public UserDTO getUserById(String id) {
        return repository.findById(id)
                .map(UserMapper::toDTO)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return repository.findAll().stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUser(String id) {
        repository.deleteById(id);
    }
}
