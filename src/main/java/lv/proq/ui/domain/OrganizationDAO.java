package lv.proq.ui.domain;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Artyom on 1/10/2016.
 */

@Component
public class OrganizationDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void create(Organization organization) {
        sessionFactory.getCurrentSession().save(organization);
    }
}
