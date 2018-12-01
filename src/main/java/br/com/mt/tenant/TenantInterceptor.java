package br.com.mt.tenant;

import java.io.Serializable;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;
import br.com.mt.domain.TenantEntity;
import br.com.mt.security.SecurityUtils;

@Component
public class TenantInterceptor extends EmptyInterceptor
{
    /*I*/
    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types)
    {
        return addTenantIdIfObjectIsTenantEntity(entity, state, propertyNames);
    }

    /*II*/
    @Override
    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types)
    {
        return addTenantIdIfObjectIsTenantEntity(entity, currentState, propertyNames);
    }

    /*III*/
    @Override
    public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types)
    {
        addTenantIdIfObjectIsTenantEntity(entity, state, propertyNames);
    }

    /*IV*/
    private boolean addTenantIdIfObjectIsTenantEntity(Object entity, Object[] state, String[] propertyName)
    {
        if (entity instanceof TenantEntity)
        {
            for (int index = 0; index < propertyName.length; index++)
            {
                if (propertyName[index].equals(TenantEntity.TENANT_ID_PROPERTY_NAME))
                {
                    state[index] = SecurityUtils.getTenantIdentifier();
                    return true;
                }
            }
            throw new ClassCastException();
        }
        return false;
    }
}
