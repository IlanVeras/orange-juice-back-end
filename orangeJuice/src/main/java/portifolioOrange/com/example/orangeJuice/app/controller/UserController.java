package portifolioOrange.com.example.orangeJuice.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import portifolioOrange.com.example.orangeJuice.app.UserApi;
import portifolioOrange.com.example.orangeJuice.app.dto.request.user.CreateUserRequest;
import portifolioOrange.com.example.orangeJuice.app.dto.response.user.UserResponse;
import portifolioOrange.com.example.orangeJuice.domain.entity.User;
import portifolioOrange.com.example.orangeJuice.domain.service.UserService;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
public class UserController implements UserApi {
    private final UserService userService;

    private final ObjectMapper mapper;

    public UserController(UserService userService, ObjectMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    private UserResponse userToProductDetailedResponse(User user) {
        return mapper.convertValue(user, UserResponse.class);
    }

    @Override
    public ResponseEntity<UserResponse> create(CreateUserRequest request) {
        User user = mapper.convertValue(request, User.class);
        User createdUser = userService.create(user);

        UserResponse userResponse = userToProductDetailedResponse(createdUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }

    @Override
    public ResponseEntity<List<UserResponse>> searchAll() {
        List<User> userList = userService.searchAll();
        List<UserResponse> userResponseList = userList.stream()
                .map(user -> new UserResponse(user.getId(), user.getName(), user.getSurname(), user.getEmail()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(userResponseList);
    }

    @Override
    public ResponseEntity<UserResponse> searchById(UUID id) {
        User user = userService.searchById(id);
        UserResponse userResponse = userToProductDetailedResponse(user);

        if (user != null) {
            return ResponseEntity.ok(userResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<UserResponse> update(UUID id, Map<String, Object> params) {
        User user = userService.update(id, params);
        UserResponse userResponse = userToProductDetailedResponse(user);
        if (user != null) {

            return ResponseEntity.accepted().body(userResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> delete(UUID id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @Override
    public ResponseEntity<List<UserResponse>> searchByName(@PathVariable String name) {
        List<User> userList = userService.searchByName(name);
        List<UserResponse> userResponseList = userList.stream()
                .map(user -> new UserResponse(user.getId(), user.getName(), user.getSurname(), user.getEmail()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(userResponseList);
    }

}
