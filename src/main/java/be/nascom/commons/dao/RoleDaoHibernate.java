package be.nascom.commons.dao;

import be.nascom.commons.domain.authentication.Role;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * User: bart
 * Date: May 11, 2009
 * Time: 2:28:04 PM
 */
@Repository("roleDao")
public class RoleDaoHibernate implements RoleDao {
    @Autowired
    protected SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = true)
    @SuppressWarnings({"unchecked"})
    public List<Role> getRolesByUserId(long uid) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery(
                "SELECT {role.*} FROM role {role} LEFT JOIN users_roles AS ur ON {role}.id = ur.role_id WHERE ur.user_id = ?")
                .addEntity("role", Role.class);
        query.setLong(0, uid);
        return query.list();
    }

    @Transactional(readOnly = false)
    public void addRole(long userId, long roleId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery("INSERT INTO users_roles (user_id,role_id) VALUES (?,?)");
        query.setLong(0, userId);
        query.setLong(1, roleId);
        query.executeUpdate();
    }

    @Transactional(readOnly = false)
    public void deleteRole(long userId, long roleId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery("DELETE FROM users_roles WHERE user_id = ? AND role_id = ?");
        query.setLong(0, userId);
        query.setLong(1, roleId);
        query.executeUpdate();
    }
}
