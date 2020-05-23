package com.codeinsight.PhotoAppUserService.service;

import com.codeinsight.PhotoAppUserService.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDetails);
}
