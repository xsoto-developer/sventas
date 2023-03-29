package com.sventas.sventas.controller;

import com.sventas.sventas.exception.ModelNotFoundException;
import com.sventas.sventas.model.Cliente;
import com.sventas.sventas.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@Tag(name = "Clientes", description = "Puntos de salida disponibles de Clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Operation(summary = "Listar todos lis clientes registrados")
    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        return new ResponseEntity<>(clienteService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Registrar Cliente")
    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
        return new ResponseEntity<>(clienteService.create(cliente), HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar Cliente")
    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Cliente cliente) {
        clienteService.update(cliente);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Obtener el registro del cliente filtrado por {id}")
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@Parameter(description = "id of client to be searched")
                                            @PathVariable("id") Integer id) {
        Cliente cliente = clienteService.findById(id);
        if (cliente == null) {
            throw new ModelNotFoundException("El cliente no existe");
//            throw new ResponseStatusException(
//                    HttpStatus.NOT_FOUND, "Client Not Found");
        }
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @Operation(summary = "Eliminar el registro del cliente")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id) throws Exception {
        Cliente cliente = clienteService.findById(id);
        if (cliente == null) {
            throw new ModelNotFoundException("El cliente no existe");
        }
        clienteService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }


}
