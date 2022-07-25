package com.gate6coders.codeconnectedserver.domain.users.service;

import com.gate6coders.codeconnectedserver.domain.users.models.UserProfile;

public interface UserService {
    UserProfile create(UserProfile userProfile);
    Boolean doesExist(String id);
}
