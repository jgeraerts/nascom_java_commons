package be.nascom.commons.dao;

import be.nascom.commons.domain.authentication.Role;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: bart
 * Date: May 11, 2009
 * Time: 2:27:56 PM
 */
public interface RoleDao {
    List<Role> getRolesByUserId(long uid);

    void addRole(long userId, long roleId);

    void deleteRole(long userId, long roleId);
}
