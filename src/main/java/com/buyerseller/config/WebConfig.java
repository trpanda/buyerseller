package com.buyerseller.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter
{

    /*
     * (non-Javadoc)
     * @see
     * org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#configureContentNegotiation(org.springframework.web.servlet.config.annotation.
     * ContentNegotiationConfigurer)
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer)
    {
        configurer.favorPathExtension(false);
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#configurePathMatch(org.springframework.web.servlet.config.annotation.
     * PathMatchConfigurer)
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer)
    {
        configurer.setUseSuffixPatternMatch(false);
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addViewControllers(org.springframework.web.servlet.config.annotation.
     * ViewControllerRegistry)
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addRedirectViewController("/svc/buyerseller/apidocs/v2/api-docs", "/v2/api-docs"); //$NON-NLS-1$ //$NON-NLS-2$
        registry.addRedirectViewController("/svc/buyerseller/apidocs/configuration/ui", "/configuration/ui"); //$NON-NLS-1$ //$NON-NLS-2$
        registry.addRedirectViewController("/svc/buyerseller/apidocs/configuration/security", //$NON-NLS-1$
                "/configuration/security"); //$NON-NLS-1$
        registry.addRedirectViewController("/svc/buyerseller/apidocs/swagger-resources", "/swagger-resources"); //$NON-NLS-1$ //$NON-NLS-2$
        registry.addRedirectViewController("/svc/buyerseller/apidocs", "/svc/gateway/apidocs/swagger-ui.html"); //$NON-NLS-1$ //$NON-NLS-2$
        registry.addRedirectViewController("/svc/buyerseller/apidocs/", "/svc/gateway/apidocs/swagger-ui.html"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addResourceHandlers(org.springframework.web.servlet.config.annotation.
     * ResourceHandlerRegistry)
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler("/svc/buyerseller/apidocs/**") //$NON-NLS-1$
                .addResourceLocations("classpath:/META-INF/resources/"); //$NON-NLS-1$
    }

}
