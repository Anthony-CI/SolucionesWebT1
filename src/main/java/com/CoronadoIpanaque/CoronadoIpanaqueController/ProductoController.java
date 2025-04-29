package com.CoronadoIpanaque.CoronadoIpanaqueController;

import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.CoronadoIpanaque.CoronadoIpanaqueModel.Producto;
import com.CoronadoIpanaque.CoronadoIpanaqueModel.proveedor;
import com.CoronadoIpanaque.CoronadoIpanaqueServices.IProductoServices;

import lombok.RequiredArgsConstructor;


//http://localhost:9090/producto
@RestController
@RequestMapping("/producto")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ProductoController {

	private final IProductoServices service;
	
	@GetMapping
    public ResponseEntity<List<Producto>> findAll() throws Exception{
        List<Producto> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> findById(@PathVariable("id") Integer id) throws Exception{
        Producto obj =  service.findById(id);
        return ResponseEntity.ok(obj);
    }

    //nivel 3
    @PostMapping
    public ResponseEntity<EntityModel<Producto>> crearProducto(@RequestBody Producto producto) throws Exception {
        // Guardar el producto primero
        Producto obj = service.save(producto); // asignará el ID

        // Crear el recurso con HATEOAS
        EntityModel<Producto> recurso = EntityModel.of(obj);

        recurso.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductoController.class)
                .findById(obj.getIdProducto())).withSelfRel());

        recurso.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductoController.class)
                .update(obj.getIdProducto(), obj)).withRel("actualizar"));

        recurso.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductoController.class)
                .delete(obj.getIdProducto())).withRel("eliminar"));

        // Devolver con location y body
        return ResponseEntity.created(
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductoController.class)
                        .findById(obj.getIdProducto())).toUri())
                .body(recurso);
    }
    
    
    
    
    /*
    @PostMapping
    public ResponseEntity<Producto> save(@RequestBody Producto producto) throws Exception{
        Producto obj =  service.save(producto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdProducto()).toUri();
        return ResponseEntity.created(location).build();
    }
    */
    
    @PutMapping("/{id}")
    public ResponseEntity<Producto> update(@PathVariable("id") Integer id, @RequestBody Producto producto) throws Exception{
        Producto obj =  service.update(producto, id);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id)
            throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
	
	
	

}
