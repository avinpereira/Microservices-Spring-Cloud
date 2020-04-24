package com.codeinsight.userservice.ui.controller;

import com.codeinsight.userservice.ui.models.requests.UpdateUserDetailsRequestModel;
import com.codeinsight.userservice.ui.models.requests.UserDetailsRequestModel;
import com.codeinsight.userservice.ui.models.response.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    Map<String, UserRest> users = new HashMap<>();

    @GetMapping
    public String getAllUser(@RequestParam(value = "page", defaultValue = "1") int page,
                             @RequestParam(value = "limit", defaultValue = "50") int limit,
                             @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
        return "Get All User was called Page =" + page + "Limit = " + limit + "sort =" + sort;
    }

    @GetMapping(value = "/{userId}",
            produces = {
                    MediaType.APPLICATION_XML_VALUE, //Remember that you will need a new dependency Jackson XML
                    MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
        if (users.containsKey(userId)) {
            return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel requestBody) {
        UserRest returnValue = new UserRest();
        returnValue.setFirstName(requestBody.getFirstName());
        returnValue.setLastName(requestBody.getLastName());
        returnValue.setEmail(requestBody.getEmail());
        returnValue.setUserId(UUID.randomUUID().toString());
        users = new HashMap<>();
        users.put(returnValue.getUserId(), returnValue);
        return new ResponseEntity<>(returnValue, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserRest> updateUser(@Valid @RequestBody UpdateUserDetailsRequestModel updateRequestBody,
                             @PathVariable(value = "userId") String userId) {
        if (users.containsKey(userId)) {
            UserRest storedValue = users.get(userId);
            storedValue.setFirstName(updateRequestBody.getFirstName());
            storedValue.setLastName(updateRequestBody.getLastName());
            users.put(userId, storedValue);
            return new ResponseEntity<>(storedValue,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable(value = "userId") String userId) {
        users.remove(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
