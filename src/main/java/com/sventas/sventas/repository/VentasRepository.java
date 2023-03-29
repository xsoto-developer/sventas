package com.sventas.sventas.repository;

import com.sventas.sventas.model.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentasRepository extends JpaRepository<Ventas,Integer> {
}
