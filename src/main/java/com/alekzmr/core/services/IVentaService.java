package com.alekzmr.core.services;

import com.alekzmr.core.models.Venta;

public interface IVentaService extends ICRUDService<Venta, Integer>{
	Venta registrarTransaccional(Venta v) throws Exception;
	
	Venta modificarTransaccional(Venta v) throws Exception;
	
	void eliminarTransaccional (Integer id) throws Exception;
}
