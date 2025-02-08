package com.myorganisation.mydeal.service;

import com.myorganisation.mydeal.dto.UserInputDto;
import com.myorganisation.mydeal.dto.UserOutputDto;
import com.myorganisation.mydeal.model.Cart;
import com.myorganisation.mydeal.model.User;
import com.myorganisation.mydeal.repository.CartRepository;
import com.myorganisation.mydeal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CartRepository cartRepository;

    @Override
    public UserOutputDto addUser(UserInputDto userInputDto) {
        User user = new User();
        user.setName(userInputDto.getName());

        Cart cart = new Cart();
        cart.setProduct("iphone 14 pro");
//        cart = cartRepository.save(cart);
        user.setCart(cart);

        cart.setUser(user);
        user = userRepository.save(user);


//        cartRepository.save(cart);

        UserOutputDto userOutputDto = new UserOutputDto();
        userOutputDto.setId(user.getId());
        userOutputDto.setName(user.getName());
        userOutputDto.setCart(user.getCart());

        return userOutputDto;
    }

    @Override
    public String removeUser(Long id) {
        String name = userRepository.findById(id).orElse(null).getName();
        userRepository.deleteById(id);
        return "User name: " + name + " has been removed!";
    }
}
