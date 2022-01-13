package hyangyu.server.api;

import java.nio.charset.Charset;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import hyangyu.server.domain.User;
import hyangyu.server.dto.StatusEnum;
import hyangyu.server.dto.UserResponseDto;
import hyangyu.server.repository.UserRepository;

@RestController
public class UserController {
	private UserRepository userRepository;
	
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@GetMapping(value = "/user/{id}")
	public ResponseEntity<UserResponseDto> findById(@PathVariable Long id){
		User user = userRepository.findById(id).get();
		UserResponseDto userResponseDto = new UserResponseDto();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("applicaition", "json", Charset.forName("UTF-8")));
		
		userResponseDto.setStatus(StatusEnum.OK);
		userResponseDto.setMessage("성공 코드");
		userResponseDto.setData(user);
		
		return new ResponseEntity<>(userResponseDto,headers,HttpStatus.OK);
		
	}
}
