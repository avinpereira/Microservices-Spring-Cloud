package com.codeinsight.PhotoAppUserService.dao.service;

import com.codeinsight.PhotoAppUserService.dao.repository.UserRepository;
import com.codeinsight.PhotoAppUserService.dto.UserDto;
import com.codeinsight.PhotoAppUserService.entity.UserEntity;
import com.codeinsight.PhotoAppUserService.service.UserService;
import com.netflix.discovery.converters.Auto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto userDetails) {
        userDetails.setUserId(UUID.randomUUID().toString());
        ModelMapper modelMapper = new ModelMapper();
        modelMapper
                .getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);
        userEntity.setEncryptedPassword("test");
        userRepository.save(userEntity);
        return null;
    }
}
