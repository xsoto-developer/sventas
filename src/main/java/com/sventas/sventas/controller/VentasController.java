package com.sventas.sventas.controller;

import com.sventas.sventas.model.Ventas;
import com.sventas.sventas.service.VentasService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.Table;
import java.util.List;

@RestController
@RequestMapping("/ventas")
@Tag(name = "Ventas" , description = "Descipcion del registro de ventas")
public class VentasController {

    private final VentasService ventasService;

    public VentasController(VentasService ventasService) {
        this.ventasService = ventasService;
    }

    @Operation(summary = "Lista todas las ventas registradas")
    @GetMapping
    public ResponseEntity<List<Ventas>> findAll(){
        return new ResponseEntity<>(ventasService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener el tegistro de venta filtrado por Id")
    @GetMapping("/{id}")
    public ResponseEntity<Ventas> findById(@Parameter(description = "Identificador de ventas a ser buscado")
                                           @PathVariable("id") Integer id){
        Ventas ventas = ventasService.findById(id);
        if (ventas == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro no encontrado");
        }
        return new ResponseEntity<>(ventasService.findById(id), HttpStatus.OK);
    }

    @Operation(summary = "Registrar venta")
    @PostMapping
    public ResponseEntity<Ventas> create(@RequestBody Ventas ventas){
        return new ResponseEntity<>(ventasService.create(ventas), HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar ventas registradas")
    @PutMapping
    public Ventas update(@RequestBody Ventas ventas){
        return ventasService.update(ventas);
    }
    @Operation(summary = "Eliminar venta filtrada por Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@Parameter(description = "Identificador de ventas a ser eliminado")
                                         @PathVariable("id") Integer id){
        Ventas ventas = ventasService.findById(id);
        if(ventas== null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro no encontrado");
        }
        ventasService.delete(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

}
