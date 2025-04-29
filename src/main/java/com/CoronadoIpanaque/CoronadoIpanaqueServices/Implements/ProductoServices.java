package com.CoronadoIpanaque.CoronadoIpanaqueServices.Implements;

import org.springframework.stereotype.Service;

import com.CoronadoIpanaque.CoronadoIpanaqueModel.Producto;
import com.CoronadoIpanaque.CoronadoIpanaqueRepository.IGenericRepository;
import com.CoronadoIpanaque.CoronadoIpanaqueRepository.IProductoRepository;
import com.CoronadoIpanaque.CoronadoIpanaqueServices.IProductoServices;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoServices extends GenericServices<Producto, Integer> implements IProductoServices {

	private final IProductoRepository repo;
	@Override
	protected IGenericRepository<Producto, Integer> getRepository() {
		// TODO Auto-generated method stub
		return repo;
	}

}
