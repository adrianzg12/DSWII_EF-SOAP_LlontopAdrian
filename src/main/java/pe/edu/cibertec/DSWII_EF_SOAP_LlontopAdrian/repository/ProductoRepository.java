package pe.edu.cibertec.DSWII_EF_SOAP_LlontopAdrian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import pe.edu.cibertec.DSWII_EF_SOAP_LlontopAdrian.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByNombre(String nombre);
}
