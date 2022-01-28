package hyangyu.server.api;

import hyangyu.server.dto.UserDto;
import hyangyu.server.domain.User;
import hyangyu.server.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/api/UserApi")
public class UserApi {
    private final UserService userService;

    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/test-redirect")
    public void testRedirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/api/UserController/user");
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signup(
            @Valid @RequestBody UserDto userDto
    ) {
        return ResponseEntity.ok(userService.signup(userDto));
    }

    @GetMapping("/user")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<UserDto> getMyUserInfo(HttpServletRequest request) {
        return ResponseEntity.ok(userService.getMyUserWithAuthorities());
    }

    @GetMapping("/user/{email}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<UserDto> getUserInfo(@PathVariable String email) {
        return ResponseEntity.ok(userService.getUserWithAuthorities(email));
    }
    
    @PostMapping("/user/modifyUsername")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<String> modifyUsername(HttpServletRequest request, String username){
    	UserDto userDto = userService.getMyUserWithAuthorities();
    	return ResponseEntity.ok(userService.modifyUsername(userDto, username));
    }
    
    @PostMapping("/user/modifyPassword")
    public ResponseEntity<String> modifyUsername(@PathVariable String email, String password){
    	return ResponseEntity.ok(userService.modifyPassword(email, password));
    }
}
