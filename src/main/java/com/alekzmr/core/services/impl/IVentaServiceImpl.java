package com.alekzmr.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alekzmr.core.models.Venta;
import com.alekzmr.core.repositories.IDetalleVentaRepository;
import com.alekzmr.core.repositories.IGenericRepository;
import com.alekzmr.core.repositories.IVentaRepository;
import com.alekzmr.core.services.IVentaService;

@Service
public class IVentaServiceImpl extends ICRUDServiceImpl<Venta, Integer> implements IVentaService{
	
	@Autowired
	private IVentaRepository repo;
	
	@Autowired
	private IDetalleVentaRepository detRepo;
	
	@Override
	protected IGenericRepository<Venta, Integer> getRepo(){
		return repo;
	}

	@Override
	public Venta registrarTransaccional(Venta v) throws Exception {		
		v.getDetalleVenta().forEach(det -> det.setVenta(v));
		return repo.save(v);
	}

	@Override
	public Venta modificarTransaccional(Venta v) throws Exception {
		v.getDetalleVenta().forEach(det -> det.setVenta(v));
		return repo.save(v);
	}

	@Override
	public void eliminarTransaccional(Integer id) throws Exception {
		Venta v = repo.findById(id).orElse(null);
		if(v!=null) {
			v.getDetalleVenta().forEach(det -> detRepo.deleteById(det.getIdDetalleVenta()));			
			repo.deleteById(id);
		}
	}

	
}
