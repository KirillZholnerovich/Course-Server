package by.bstu.fit.zholnerovich.course.server;

import by.bstu.fit.zholnerovich.course.server.config.WebConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class ApplicationInitializer implements WebApplicationInitializer{

    private final static String REST_SERVLET = "restServlet";
    private final static String SOAP_SERVLET = "soapServlet";

    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();

        ctx.register(WebConfig.class);

        servletContext.addListener(new ContextLoaderListener(ctx));

        DispatcherServlet restServlet = new DispatcherServlet(ctx);
        MessageDispatcherServlet soapServlet = new MessageDispatcherServlet();

        soapServlet.setApplicationContext(ctx);
        soapServlet.setTransformWsdlLocations(true);

        ServletRegistration.Dynamic servlet = servletContext.addServlet(REST_SERVLET, restServlet);
        ServletRegistration.Dynamic dynamic = servletContext.addServlet(SOAP_SERVLET, soapServlet);

        servlet.addMapping("/rest/*");
        servlet.setLoadOnStartup(1);

        dynamic.addMapping("/registration/*");
        dynamic.setLoadOnStartup(2);
    }
}
