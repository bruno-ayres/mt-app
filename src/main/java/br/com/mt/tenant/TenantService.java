package br.com.mt.tenant;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import br.com.mt.security.SecurityUtils;

@Service
public abstract class TenantService
{

    @PersistenceContext
    public EntityManager entityManager;

    public Serializable getCurrentTenantIdentifer()
    { /*II*/
        return SecurityUtils.getTenantIdentifier();
    }
}
