package ec.edu.espe.pruebaparcial3.ventas.service;

import ec.edu.espe.pruebaparcial3.ventas.repository.VentaRepository;
import org.springframework.stereotype.Service;

@Service
public class VentaService {
    private final VentaRepository ventaRepository;

    public VentaService(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

}
