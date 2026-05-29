package pl.wsb.fitnesstracker.user.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.wsb.fitnesstracker.user.api.*;

import java.time.LocalDate;
import java.util.List;

/**
 * UserController is responsible for handling HTTP requests related to user operations.
 * It provides endpoints for retrieving and creating users.
 */
@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
class UserController {

    private final UserService userService;

    private final UserProvider userProvider;

    private final UserMapper userMapper;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserDto addUser(@RequestBody UserDto userDto) throws InterruptedException {

        // TODO: Implement the method to add a new user.
        //  You can use the @RequestBody annotation to map the request body to the UserDto object.

        User user = userMapper.toUser(userDto);
        User createdUser = userService.createUser(user);
        return userMapper.toUserDto(createdUser);
    }

    @GetMapping
    public List<UserDto> getUsers() throws InterruptedException {

       return this.userProvider.findAllUsers().stream()
                .map(this.userMapper::toUserDto)
                .toList();
    }

    @GetMapping("/simple")
    public List<UserDto> getSimpleUsers() {

        return this.userProvider.findAllUsers().stream()
                .map(this.userMapper::toUserDto)
                .toList();
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable Long id) {

        User user = userProvider.getUser(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        return userMapper.toUserDto(user);
    }
    @PutMapping("/{userId}")
    public UserDto updateUser(
            @PathVariable Long userId,
            @RequestBody UserDto userDto) {

        User user = userMapper.toUser(userDto);

        User updatedUser = userService.updateUser(userId, user);

        return userMapper.toUserDto(updatedUser);
    }

    @GetMapping("/email")
    public List<UserDto> getUserByEmail(@RequestParam String email) {

        return userProvider.getUserByEmail(email)
                .stream()
                .map(userMapper::toUserDto)
                .toList();
    }

    @GetMapping("/older/{time}")
    public List<UserDto> getUsersOlderThan(@PathVariable LocalDate time) {

        return userProvider.getUsersOlderThan(time)
                .stream()
                .map(userMapper::toUserDto)
                .toList();
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long userId) {

        userService.deleteUser(userId);
    }
}
