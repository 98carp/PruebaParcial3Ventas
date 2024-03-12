package ec.edu.espe.pruebaparcial3.ventas.service;

import ec.edu.espe.pruebaparcial3.ventas.domain.Venta;
import ec.edu.espe.pruebaparcial3.ventas.dto.VentaReqDto;
import ec.edu.espe.pruebaparcial3.ventas.external.dto.ProductoDto;
import ec.edu.espe.pruebaparcial3.ventas.repository.VentaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService {
    private final VentaRepository ventaRepository;
    private final RestTemplate restTemplate;

    public VentaService(VentaRepository ventaRepository, RestTemplate restTemplate) {
        this.ventaRepository = ventaRepository;
        this.restTemplate = restTemplate;
    }
    @Transactional
    public Venta crearVenta(VentaReqDto ventaReqDto, List<String> codigoProducto){
        List<ProductoDto>productoDtos=new ArrayList<>();
        for(String codProdTemp:codigoProducto){
            String url="http://localhost:8083/api/v1/prod/"+codProdTemp;
            ProductoDto productoDto=restTemplate.getForObject(url,ProductoDto.class);
            productoDtos.add(productoDto);
        }
    }

}
