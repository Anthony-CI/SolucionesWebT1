package com.CoronadoIpanaque.CoronadoIpanaqueController;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.CoronadoIpanaque.CoronadoIpanaqueModel.Producto;
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

    @PostMapping
    public ResponseEntity<Producto> save(@RequestBody Producto producto) throws Exception{
        Producto obj =  service.save(producto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdProducto()).toUri();
        return ResponseEntity.created(location).build();
    }

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
