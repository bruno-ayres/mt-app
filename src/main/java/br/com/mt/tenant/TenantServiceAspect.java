package br.com.mt.tenant;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import br.com.mt.domain.TenantEntity;

@Aspect
@Component
public class TenantServiceAspect
{
    @Before("execution(* br.com.mt.tenant.TenantService+.*(..)) && @annotation(br.com.mt.tenant.ReadsTenantData) && target(tenantService)")
    public void StringArguementMethods(JoinPoint joinPoint, TenantService tenantService)
    {
        tenantService.entityManager.unwrap(Session.class).enableFilter(TenantEntity.TENANT_FILTER_NAME).setParameter(TenantEntity.TENANT_FILTER_ARGUMENT_NAME,
            tenantService.getCurrentTenantIdentifer()); /*VII*/
    }
}
