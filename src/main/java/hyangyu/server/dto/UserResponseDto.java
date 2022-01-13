package hyangyu.server.dto;

import hyangyu.server.domain.User;
import lombok.Getter;

@Getter
public class UserResponseDto {
	private final Long userId;
	private final String email;
	private final String nickname;
	private final String sub;
	private final String token;
	
	public UserResponseDto(User user) {
		this.userId = user.getUserId();
		this.email = user.getEmail();
		this.nickname = user.getNickname();
		this.sub = user.getSub();
		this.token = user.getToken();
	}
}
