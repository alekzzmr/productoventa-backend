package com.alekzmr.core.services;

import java.util.List;

public interface ICRUDService<T, ID> {
	T registrar (T obj) throws Exception;
	T modificar (T obj) throws Exception;
	List<T> listar () throws Exception;
	T buscarPorId (ID id) throws Exception;
	void eliminar (ID id) throws Exception;
}
