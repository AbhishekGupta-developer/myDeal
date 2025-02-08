package com.myorganisation.mydeal.service;

import com.myorganisation.mydeal.dto.UserInputDto;
import com.myorganisation.mydeal.dto.UserOutputDto;

public interface UserService {
    UserOutputDto addUser(UserInputDto userInputDto);
    String removeUser(Long id);
}
