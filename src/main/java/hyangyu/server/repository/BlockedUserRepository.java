package hyangyu.server.repository;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hyangyu.server.domain.BlockedUser;
import hyangyu.server.domain.BlockedUserId;
import hyangyu.server.domain.FavoriteDisplay;
import hyangyu.server.domain.User;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BlockedUserRepository{
	private final EntityManager em;
	
	public void saveBlockedUser(BlockedUser blockedUser) {
	        em.persist(blockedUser);
	    }
	public BlockedUser findOne(BlockedUserId blockedUserId) {
        return em.find(BlockedUser.class, blockedUserId);
    }
	
	@Transactional
	public void deleteBlockedUser(BlockedUser blockedUser) { em.remove(em.find(BlockedUser.class, blockedUser.getBlockedUserId()));}
}
