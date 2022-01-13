package hyangyu.server.dto;

import hyangyu.server.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRequestDto {

	private String email;
	private String nickname;
	private String password;
	
	@Builder
	public UserRequestDto(String email, String nickname, String password) {
		this.email = email;
		this.nickname = nickname;
		this.password = password;
	}
	
	public User toEntity() {
		return User.builder()
				.email(email)
				.nickname(nickname)
				.password(password)
				.build();
	}
	
	
}
