package com.alekzmr.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alekzmr.core.models.DetalleVenta;
import com.alekzmr.core.repositories.IDetalleVentaRepository;
import com.alekzmr.core.repositories.IGenericRepository;
import com.alekzmr.core.services.IDetalleVentaService;


@Service
public class IDetalleVentaServiceImpl extends ICRUDServiceImpl<DetalleVenta, Integer> implements IDetalleVentaService{
	
	@Autowired
	private IDetalleVentaRepository repo;
	
	@Override
	protected IGenericRepository<DetalleVenta, Integer> getRepo(){
		return repo;
	}
}
