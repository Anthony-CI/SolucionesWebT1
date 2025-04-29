package com.CoronadoIpanaque.CoronadoIpanaqueServices.Implements;



import com.CoronadoIpanaque.CoronadoIpanaqueRepository.IGenericRepository;
import com.CoronadoIpanaque.CoronadoIpanaqueServices.IGenericServices;
import java.util.List;

public abstract class GenericServices<T,ID> implements IGenericServices<T, ID>  {
	
	protected abstract IGenericRepository<T, ID> getRepository();
	
	@Override
	public T save(T t) throws Exception {
		// TODO Auto-generated method stub
		return getRepository().save(t);
	}

	@Override
	public T update(T t, ID id) throws Exception {
		
		return getRepository().save(t);
	}

	@Override
	public List<T> findAll() throws Exception {
		// TODO Auto-generated method stub
		return getRepository().findAll();
	}

	@Override
	public T findById(ID id) throws Exception {
		// TODO Auto-generated method stub
		return getRepository().findById(id).orElse(null);
	}

	@Override
	public void delete(ID id) throws Exception {
		getRepository().deleteById(id);
		
	}
	
}
