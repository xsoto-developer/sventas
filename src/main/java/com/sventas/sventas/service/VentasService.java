package com.sventas.sventas.service;

import com.sventas.sventas.model.Cliente;
import com.sventas.sventas.model.Ventas;
import com.sventas.sventas.repository.ClienteRepository;
import com.sventas.sventas.repository.VentasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentasService implements IVentasService {
    private final VentasRepository ventasRepository;

    public VentasService(VentasRepository ventasRepository) {
        this.ventasRepository = ventasRepository;
    }


    @Override
    public Ventas create(Ventas ventas) {
        return ventasRepository.save(ventas);
    }

    @Override
    public Ventas update(Ventas ventas) {
        return ventasRepository.save(ventas);
    }

    @Override
    public Ventas findById(Integer id) {
        Optional<Ventas> optionalVentas = ventasRepository.findById(id);
        return optionalVentas.orElse(null);
    }

    @Override
    public List<Ventas> findAll() {
        return ventasRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        ventasRepository.deleteById(id);
    }
}
