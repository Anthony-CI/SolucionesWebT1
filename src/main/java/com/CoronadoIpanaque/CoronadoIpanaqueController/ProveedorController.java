package com.CoronadoIpanaque.CoronadoIpanaqueController;

import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.CoronadoIpanaque.CoronadoIpanaqueModel.proveedor;
import com.CoronadoIpanaque.CoronadoIpanaqueServices.IProveedorService;

import lombok.RequiredArgsConstructor;

//http://localhost:9090/proveedor
@RestController
@RequestMapping("/proveedor")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")

public class ProveedorController {
private final IProveedorService service;
	
	@GetMapping
    public ResponseEntity<List<proveedor>> findAll() throws Exception{
        List<proveedor> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<proveedor> findById(@PathVariable("id") Integer id) throws Exception{
        proveedor obj =  service.findById(id);
        return ResponseEntity.ok(obj);
    }
    
    
    
    @PostMapping
    public ResponseEntity<EntityModel<proveedor>> crearProveedor(@RequestBody proveedor proveedor) throws Exception {
        // Guardar el proveedor primero
        proveedor obj = service.save(proveedor); // <-- Esto asignará el ID

        // Crear el recurso con HATEOAS
        EntityModel<proveedor> recurso = EntityModel.of(obj);

        recurso.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProveedorController.class)
                .findById(obj.getIdProveedor())).withSelfRel());

        recurso.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProveedorController.class)
                .update(obj.getIdProveedor(), obj)).withRel("actualizar"));

        recurso.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProveedorController.class)
                .delete(obj.getIdProveedor())).withRel("eliminar"));

        // Devolver con location y body
        return ResponseEntity.created(
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProveedorController.class)
                        .findById(obj.getIdProveedor())).toUri())
                .body(recurso);
    }
    
    
    
    
    /*
    @PostMapping
    public ResponseEntity<proveedor> save(@RequestBody proveedor proveedor) throws Exception{
        proveedor obj =  service.save(proveedor);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdProveedor()).toUri();
        return ResponseEntity.created(location).build();
    }
    */
    
    
    
    @PutMapping("/{id}")
    public ResponseEntity<proveedor> update(@PathVariable("id") Integer id, @RequestBody proveedor proveedor) throws Exception{
        proveedor obj =  service.update(proveedor, id);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id)
            throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
