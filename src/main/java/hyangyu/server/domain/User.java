package hyangyu.server.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
	@Column(nullable = false, length = 50)
	private String email;
	
	@Column(nullable = false, length = 200)
	private String password;
	
	@Column(nullable = false, length = 10)
	private String nickname;
	
	@Column(length = 50)
	private String sub;
	
	@Column(nullable = false, length = 100)
	private String token;
}
