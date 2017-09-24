package com.buyerseller.common;

import java.util.MissingResourceException;
import java.util.ResourceBundle;
public class ResourceMessageUtil
{

    private static final String         BUNDLE_NAME     = "messages";                           //$NON-NLS-1$

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

    private ResourceMessageUtil()
    {
    }

    @SuppressWarnings("javadoc")
    public static String getString(String key)
    {
        try
        {
            return RESOURCE_BUNDLE.getString(key);
        }
        catch (MissingResourceException e)
        {
            return '!' + key + '!';
        }
    }
}
