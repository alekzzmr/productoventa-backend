package com.alekzmr.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alekzmr.core.models.Producto;
import com.alekzmr.core.repositories.IGenericRepository;
import com.alekzmr.core.repositories.IProductoRepository;
import com.alekzmr.core.services.IProductoService;

@Service
public class IProductoServiceImpl extends ICRUDServiceImpl<Producto, Integer> implements IProductoService{
	@Autowired
	private IProductoRepository repo;
	
	@Override
	protected IGenericRepository<Producto, Integer> getRepo(){
		return repo;
	}
}
