package hyangyu.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hyangyu.server.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
