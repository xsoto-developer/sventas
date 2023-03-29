package com.sventas.sventas.service;

import com.sventas.sventas.model.Ventas;

import java.util.List;

public interface IVentasService {

    Ventas create(Ventas ventas);

    Ventas update(Ventas ventas);

    Ventas findById(Integer id);

    List<Ventas> findAll();

    void delete(Integer id);


}
