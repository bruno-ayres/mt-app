package br.com.mt.domain;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

@MappedSuperclass()
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@FilterDef(name = "tenantFilter", parameters = @ParamDef(name = "tenantId", type = "long"), defaultCondition = "tenant_Id" + "= :" + "tenantId")
@Filter(name = "tenantFilter")
public class TenantEntity
{
    public static final String TENANT_FILTER_NAME = "tenantFilter";

    public static final String TENANT_ID_PROPERTY_NAME = "tenantId";

    public static final String TENANT_FILTER_ARGUMENT_NAME = TENANT_ID_PROPERTY_NAME;

    private Long tenantId;

    public Long getTenantId()
    {
        return tenantId;
    }

    public void setTenantId(Long p_tenantId)
    {
        tenantId = p_tenantId;
    }
}
