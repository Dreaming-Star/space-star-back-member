package com.spacestar.back.friend.repository;

import com.spacestar.back.friend.domain.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface FriendRepository extends JpaRepository<Friend, Long> {

    List<Friend> findByUuid(String uuid);

    @Query("select f from Friend f where f.friendUuid = :friendUuid and f.uuid = :uuid")
    Friend findByFriendUuidAndUuid(String friendUuid, String uuid);

    Optional<Friend> findByUuidAndFriendUuid(String targetUuid, String uuid);
}
