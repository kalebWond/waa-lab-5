package com.example.Lab4.services;

import com.example.Lab4.aop.annotation.ExecutionTime;
import com.example.Lab4.domain.User;
import com.example.Lab4.domain.dto.PostDto;
import com.example.Lab4.domain.dto.UserDto;
import com.example.Lab4.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(post -> modelMapper.map(post, UserDto.class))
                .collect(Collectors.toList());
    }

    @ExecutionTime
    @Override
    public UserDto getById(long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        if(user == null) return null;
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public void save(UserDto p) {
        userRepository.save(modelMapper.map(p, User.class));
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void update(long id, UserDto u) {
        userRepository.findById(id).map(user -> {
            user.setName(u.getName());
            return userRepository.save(user);
        });
    }

    @Override
    public List<UserDto> findAllWithPostCountGreaterThan(int count) {
        return userRepository.getUsersWithMultiplePosts(count).stream().map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findAllByPostTitle(String title) {
        return userRepository.getUsersByPostTitle(title).stream().map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDto> getPostsByUserId(long id) {
        User user = userRepository.findById(id).get();
        return user.getPosts().stream().map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }

}
