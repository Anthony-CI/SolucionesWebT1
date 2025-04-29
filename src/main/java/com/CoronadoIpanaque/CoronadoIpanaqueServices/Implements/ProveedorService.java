package com.CoronadoIpanaque.CoronadoIpanaqueServices.Implements;


import org.springframework.stereotype.Service;

import com.CoronadoIpanaque.CoronadoIpanaqueModel.proveedor;
import com.CoronadoIpanaque.CoronadoIpanaqueRepository.IGenericRepository;
import com.CoronadoIpanaque.CoronadoIpanaqueRepository.IProductoRepository;
import com.CoronadoIpanaque.CoronadoIpanaqueRepository.IProveedorRepository;

import com.CoronadoIpanaque.CoronadoIpanaqueServices.IProveedorService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProveedorService  extends GenericServices<proveedor, Integer> implements IProveedorService {

	private final IProveedorRepository re;
	@Override
	protected IGenericRepository<proveedor, Integer> getRepository() {
		// TODO Auto-generated method stub
		return re;
	}

}
