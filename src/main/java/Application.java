import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.buyerseller.service.BidExpiryThread;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Configuration
@EnableScheduling
@ImportResource(value = "classpath:spring-context.xml")
@ComponentScan(basePackages = { "com.buyerseller" }) 
@EnableSwagger2
@EnableJpaRepositories
public class Application
{

    private static final String NIO_PROTOCOL = "org.apache.coyote.http11.Http11NioProtocol"; //$NON-NLS-1$
    private static final Logger _logger      = LoggerFactory.getLogger(Application.class);
    
    @Autowired
    private BidExpiryThread bidExpiryThread;

    /**
     * @param args arguments
     */
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }

    /**
     * @return tomcat instance with NIO protocol
     */
    @Bean
    public EmbeddedServletContainerFactory servletContainer()
    {
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
        _logger.info(String.format("Creating  an embedded tomcat server with %s.", NIO_PROTOCOL)); //$NON-NLS-1$
        tomcat.setProtocol(NIO_PROTOCOL);
        return tomcat;
    }

}
