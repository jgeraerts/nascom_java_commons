package be.nascom.commons.services;

import be.nascom.commons.domain.authentication.Role;

import java.util.List;

/**
 * Standard service to allow for spring-security role management.
 * User: bart
 * Date: May 11, 2009
 * Time: 2:26:18 PM
 */
public interface RoleService {
    List<Role> getRolesByUserId(long uid);

    void addRole(long userId, long roleId);

    void deleteRole(long userId, long roleId);
}
