package be.nascom.commons.services;

import be.nascom.commons.domain.authentication.Role;
import be.nascom.commons.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: bart
 * Date: May 11, 2009
 * Time: 2:27:12 PM
 */
@Service("roleService")
public class RoleServiceImpl extends GenericServiceImpl<Role, Long> implements RoleService {
    @Autowired
    RoleDao roleDao;

    @Override
    public List<Role> getRolesByUserId(long uid) {
        return roleDao.getRolesByUserId(uid);
    }

    @Override
    public void addRole(long userId, long roleId) {
        roleDao.addRole(userId, roleId);
    }

    @Override
    public void deleteRole(long userId, long roleId) {
        roleDao.deleteRole(userId, roleId);
    }
}