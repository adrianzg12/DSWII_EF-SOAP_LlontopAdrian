package pe.edu.cibertec.DSWII_EF_SOAP_LlontopAdrian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import pe.edu.cibertec.DSWII_EF_SOAP_LlontopAdrian.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByClienteId(Long clienteId);
}
