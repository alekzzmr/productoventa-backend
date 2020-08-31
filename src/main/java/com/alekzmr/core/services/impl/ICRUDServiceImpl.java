package com.alekzmr.core.services.impl;

import java.util.List;

import com.alekzmr.core.repositories.IGenericRepository;
import com.alekzmr.core.services.ICRUDService;

public abstract class ICRUDServiceImpl<T,ID> implements ICRUDService<T, ID>{

	protected abstract IGenericRepository<T, ID> getRepo();
	
	@Override
	public T registrar(T obj) throws Exception {
		
		return getRepo().save(obj);
	}

	@Override
	public T modificar(T obj) throws Exception {
		// TODO Auto-generated method stub
		return getRepo().save(obj);
	}

	@Override
	public List<T> listar() throws Exception {
		// TODO Auto-generated method stub
		return getRepo().findAll();
	}

	@Override
	public T buscarPorId(ID id) throws Exception {
		// TODO Auto-generated method stub
		return getRepo().findById(id).orElse(null);	
	}

	@Override
	public void eliminar(ID id) throws Exception {
		// TODO Auto-generated method stub
		getRepo().deleteById(id);
	}

}
