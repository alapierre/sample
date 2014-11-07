package pl.com.softproject.dialect;

import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

/**
 * Created by admin01 on 29.10.14.
 */
public class CustomHibernateJpaVendorAdapter extends HibernateJpaVendorAdapter {

    private final JpaDialect jpaDialect = new CustomHibernateJpaDialect();

    @Override
    public JpaDialect getJpaDialect() {

        return this.jpaDialect;
    }

}
