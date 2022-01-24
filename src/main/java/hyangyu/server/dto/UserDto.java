package hyangyu.server.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import hyangyu.server.domain.User;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
	@NotNull
	@Size(max = 100)
	private String email;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@NotNull
	@Size(min = 8, max = 200)
	private String password;

	@NotNull
	@Size(min = 3, max = 10)
	private String username;

	
	private String sub;
	
	@NotNull
	private String token;
	
	@Size(max = 50)
	private String image;
	
	private Set<AuthorityDto> authorityDtoSet;

public static UserDto from(User user) {
	if(user == null) return null;

	return UserDto.builder()
              .username(user.getUsername())
              .email(user.getEmail())
              .sub(user.getSub())
              .token(user.getToken())
              .image(user.getImage())
              .authorityDtoSet(user.getAuthorities().stream()
                      .map(authority -> AuthorityDto.builder().authorityName(authority.getAuthorityName()).build())
                      .collect(Collectors.toSet()))
              .build();
   }
}
