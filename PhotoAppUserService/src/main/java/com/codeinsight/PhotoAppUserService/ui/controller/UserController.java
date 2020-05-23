package com.codeinsight.PhotoAppUserService.ui.controller;

import com.codeinsight.PhotoAppUserService.dto.UserDto;
import com.codeinsight.PhotoAppUserService.entity.UserEntity;
import com.codeinsight.PhotoAppUserService.service.UserService;
import com.codeinsight.PhotoAppUserService.ui.models.CreateUserRequestBody;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private Environment env;

    @Autowired
    private UserService userService;

    @GetMapping("/status/check")
    public String status(){

        return "Working in port" + env.getProperty("local.server.port");
    }


    @PostMapping
    public String createUser(@Valid  @RequestBody CreateUserRequestBody userDetails){

        ModelMapper modelMapper = new ModelMapper();
        modelMapper
                .getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto userDto = modelMapper.map(userDetails, UserDto.class);
        userService.createUser(userDto);
        return "New User";
    }
}

