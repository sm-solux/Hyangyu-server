package hyangyu.server.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Getter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@NotNull
	@Column(length = 50)
	private String email;
	
	@NotNull
	@Column(length = 200)
	private String password;
	
	@NotNull
	@Column(length = 10)
	private String nickname;
	
	@Column(length = 50)
	private String sub;
	
	@NotNull
	@Column( length = 100)
	private String token;
}
