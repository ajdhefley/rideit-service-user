package com.github.ajdhefley.rideit.services.user.repository;

import com.github.ajdhefley.rideit.services.user.model.OAuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OAuthUserRepository extends JpaRepository<OAuthUser, Integer> {

    @Query("SELECT u FROM OAuthUser u WHERE u.oauthIdentifier=:oauthIdentifier")
    public OAuthUser getByOAuthIdentifier(@Param("oauthIdentifier") String oauthIdentifier);

}
