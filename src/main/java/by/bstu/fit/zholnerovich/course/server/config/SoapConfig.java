package by.bstu.fit.zholnerovich.course.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
@ComponentScan("by.bstu.fit.zholnerovich.course.server")
public class SoapConfig extends WsConfigurerAdapter {
    @Bean(name = "registration")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema regSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("RegPort");
        wsdl11Definition.setLocationUri("/registration");
        wsdl11Definition.setTargetNamespace("http://bstu.by/fit/zholnerovich/course/server/soap");
        wsdl11Definition.setSchema(regSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema regSchema() {
        return new SimpleXsdSchema(new ClassPathResource("registration.xsd"));
    }
}
