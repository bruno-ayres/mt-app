package br.com.mt.tenant;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface ReadsTenantData
{
}
