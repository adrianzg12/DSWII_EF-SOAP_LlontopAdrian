package pe.edu.cibertec.DSWII_EF_SOAP_LlontopAdrian.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSWII_EF_SOAP_LlontopAdrian.model.Producto;
import pe.edu.cibertec.DSWII_EF_SOAP_LlontopAdrian.repository.ProductoRepository;

import java.util.List;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public Producto createProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto updateProducto(Long id, Producto producto) {
        producto.setId(id);
        return productoRepository.save(producto);
    }

    public Producto findProductoById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    public List<Producto> findAllProductos() {
        return productoRepository.findAll();
    }
}
