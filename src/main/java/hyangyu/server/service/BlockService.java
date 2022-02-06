package hyangyu.server.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hyangyu.server.domain.BlockedUser;
import hyangyu.server.domain.Display;
import hyangyu.server.domain.FavoriteDisplay;
import hyangyu.server.domain.User;
import hyangyu.server.repository.BlockedUserRepository;
import hyangyu.server.repository.DisplayRepository;
import hyangyu.server.repository.FavoriteDisplayRepository;
import hyangyu.server.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BlockService {
	private final UserRepository userRepository;
	private final BlockedUserRepository blockedUserRepository;
    
    @Transactional(readOnly = false)
    public Optional<BlockedUser>  saveBlock(Long userId, Long reportedId) {
    	Optional<User> user = userRepository.findByUserId(userId);
        Optional<User> reportedUser = userRepository.findByUserId(reportedId);
        BlockedUser blockedUser = new BlockedUser(user.get(), reportedUser.get());
        Optional<BlockedUser> result = Optional.ofNullable(blockedUserRepository.findOne(blockedUser.getBlockedUserId()));
        if (result.isEmpty()) {
        	blockedUserRepository.saveBlockedUser(blockedUser);
        }
        return result;
    }
    public Optional<BlockedUser>  deleteBlock(Long userId, Long reportedId)  {
    	Optional<User> user = userRepository.findByUserId(userId);
    	Optional<User> reportedUser = userRepository.findByUserId(reportedId);
    	BlockedUser blockedUser = new BlockedUser(user.get(), reportedUser.get());
    	Optional<BlockedUser> result = Optional.ofNullable(blockedUserRepository.findOne(blockedUser.getBlockedUserId()));
        if (!result.isEmpty()) {
        	blockedUserRepository.deleteBlockedUser(blockedUser);
        }
        return result;
    }
}
