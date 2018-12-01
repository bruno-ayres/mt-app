package br.com.mt.config;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.stereotype.Component;
import br.com.mt.tenant.TenantInterceptor;

@Component
public class HibernateInterceptorCustomizer implements HibernatePropertiesCustomizer
{

    @Autowired
    public TenantInterceptor tenantInterceptor;

    @Override
    public void customize(Map<String, Object> hibernateProperties)
    {
        hibernateProperties.put("hibernate.session_factory.interceptor", tenantInterceptor);
    }

}
