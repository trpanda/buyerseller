package com.buyerseller.persistence.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.OpenJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableJpaRepositories(basePackages =
{
        "com.buyerseller.persistence.repo"
})

@EnableTransactionManagement
public class BuyerSellerJpaConfig extends JpaBaseConfiguration
{
    @Autowired
    private DataSource ds;

    @Override
    protected AbstractJpaVendorAdapter createJpaVendorAdapter()
    {
        return new OpenJpaVendorAdapter();
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration#
     * getVendorProperties()
     */
    @Override
    protected Map<String, Object> getVendorProperties()
    {
        return new HashMap<String, Object>();
    }

}
