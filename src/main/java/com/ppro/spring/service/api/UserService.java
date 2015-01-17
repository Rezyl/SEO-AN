package com.ppro.spring.service.api;

import com.ppro.spring.model.User;

/**
 * Created with IntelliJ IDEA.
 * User: lukas
 * Date: 2.1.15
 */
public interface UserService extends CRUDService<User> {

    User getUserByName(String name);
}
