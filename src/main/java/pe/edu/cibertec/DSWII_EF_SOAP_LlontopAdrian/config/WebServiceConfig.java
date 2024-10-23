package pe.edu.cibertec.DSWII_EF_SOAP_LlontopAdrian.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean(name = "productos")
    public DefaultWsdl11Definition productosWsdl11Definition(XsdSchema productosSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ProductosPort");
        wsdl11Definition.setLocationUri("/ws/productos");
        wsdl11Definition.setSchema(productosSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema productosSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/producto.xsd"));
    }
}

