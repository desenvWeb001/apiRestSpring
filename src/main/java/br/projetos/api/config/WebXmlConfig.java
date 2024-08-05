package br.projetos.api.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.DelegatingFilterProxy;

@Configuration
public class WebXmlConfig implements WebApplicationInitializer {
	public void onStartup(ServletContext servletContext) throws ServletException {  
        FilterRegistration.Dynamic securityFilter;  
              securityFilter =  servletContext.addFilter("springSecurityFilterChain", new DelegatingFilterProxy());  
              securityFilter = servletContext.addFilter("simpleCorsFilter",new CORSFilter());  
        securityFilter.setAsyncSupported(Boolean.TRUE);  
        securityFilter.addMappingForUrlPatterns(null, true, "/*");  
    }  
}
