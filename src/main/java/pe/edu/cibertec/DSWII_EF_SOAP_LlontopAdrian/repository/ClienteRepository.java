package pe.edu.cibertec.DSWII_EF_SOAP_LlontopAdrian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.DSWII_EF_SOAP_LlontopAdrian.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByEmail(String email);
}

