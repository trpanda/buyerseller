package com.buyerseller.config;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import io.swagger.models.Contact;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

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
        registry.addRedirectViewController("/svc/buyerseller/apidocs/v1/api-docs", "/v1/api-docs"); //$NON-NLS-1$ //$NON-NLS-2$
        registry.addRedirectViewController("/svc/buyerseller/apidocs/configuration/ui", "/configuration/ui"); //$NON-NLS-1$ //$NON-NLS-2$
        registry.addRedirectViewController("/svc/buyerseller/apidocs/configuration/security", "/configuration/security"); //$NON-NLS-1$ //$NON-NLS-2$
        registry.addRedirectViewController("/svc/buyerseller/apidocs/swagger-resources", "/swagger-resources"); //$NON-NLS-1$ //$NON-NLS-2$
        registry.addRedirectViewController("/svc/buyerseller/apidocs", "/svc/buyerseller/apidocs/swagger-ui.html"); //$NON-NLS-1$ //$NON-NLS-2$
        registry.addRedirectViewController("/svc/buyerseller/apidocs/", "/svc/buyerseller/apidocs/swagger-ui.html"); //$NON-NLS-1$ //$NON-NLS-2$
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
