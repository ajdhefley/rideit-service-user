package com.github.ajdhefley.rideit.services.user;

import com.github.ajdhefley.rideit.services.user.model.OAuthUser;
import com.github.ajdhefley.rideit.services.user.model.User;
import com.github.ajdhefley.rideit.services.user.repository.OAuthUserRepository;
import com.github.ajdhefley.rideit.services.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    OAuthUserRepository oauthUserRepository;

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUser(@PathVariable("userId") int userId) {
        return new ResponseEntity<>(this.userRepository.findById(userId).orElseThrow(null), HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<User> saveUser(User user) {
        return new ResponseEntity<>(this.userRepository.save(user), HttpStatus.CREATED);
    }

    @GetMapping("/oauth-user/{serviceId}/{accountId}")
    public ResponseEntity<OAuthUser> getOAuthUser(@PathVariable("serviceId") int serviceId, @PathVariable("accountId") String accountId) {
        return new ResponseEntity<>(this.oauthUserRepository.getByOAuthIdentifier(accountId), HttpStatus.OK);
    }

    @PostMapping("/oauth-user")
    public ResponseEntity<OAuthUser> saveOAuthUser(@RequestBody OAuthUser oauthUser) {
        return new ResponseEntity<>(this.oauthUserRepository.save(oauthUser), HttpStatus.CREATED);
    }

}
