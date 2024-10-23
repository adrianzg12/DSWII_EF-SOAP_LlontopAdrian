package pe.edu.cibertec.DSWII_EF_SOAP_LlontopAdrian.endpoint;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.xml.transform.StringSource;
import pe.edu.cibertec.DSWII_EF_SOAP_LlontopAdrian.model.Producto;
import pe.edu.cibertec.DSWII_EF_SOAP_LlontopAdrian.service.ProductoService;

import javax.xml.bind.JAXBElement;

@Endpoint
public class ProductoEndpoint {

    private static final String NAMESPACE_URI = "http://www.cibertec.edu.pe/soap/producto";

    @Autowired
    private ProductoService productoService;

    // Método para crear un producto
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createProductoRequest")
    @ResponsePayload
    public StringSource createProducto(@RequestPayload JAXBElement<Producto> request) {
        Producto producto = request.getValue();
        Producto createdProducto = productoService.createProducto(producto);
        // Aquí se debe crear un response adecuado
        return new StringSource("<createProductoResponse><id>" + createdProducto.getId() + "</id></createProductoResponse>");
    }

    // Método para obtener un producto por ID
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductoRequest")
    @ResponsePayload
    public StringSource getProducto(@RequestPayload JAXBElement<Long> request) {
        Long id = request.getValue();
        Producto producto = productoService.findProductoById(id);
        // Aquí se debe crear un response adecuado
        return new StringSource("<getProductoResponse><producto>" + productoToXml(producto) + "</producto></getProductoResponse>");
    }

    // Método auxiliar para convertir producto a XML
    private String productoToXml(Producto producto) {
        return "<id>" + producto.getId() + "</id>" +
                "<nombre>" + producto.getNombre() + "</nombre>" +
                "<descripcion>" + producto.getDescripcion() + "</descripcion>" +
                "<precio>" + producto.getPrecio() + "</precio>" +
                "<disponibilidad>" + producto.getDisponibilidad() + "</disponibilidad>";
    }
}