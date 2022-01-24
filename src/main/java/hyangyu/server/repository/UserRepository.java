package hyangyu.server.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import hyangyu.server.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{

	@EntityGraph(attributePaths = "authorities")
	   Optional<User> findByEmail(String email);

	Optional<User> findByUserId(Long user_id);
}
