package com.github.ajdhefley.rideit.services.user.model;

import javax.persistence.*;

@Entity
@Table(name="oauthusers")
public class OAuthUser {

    @Id
    @Column(name="oauthuserid", nullable=false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer oauthUserId;

    @Column(name="oauthserviceid", nullable=false)
    private Integer oauthServiceId;

    @Column(name="oauthidentifier", nullable=false)
    private String oauthIdentifier;

    @Column(name="userid", nullable=false)
    private Integer userId;

}
