package com.alekzmr.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.alekzmr.core.models.Persona;
import com.alekzmr.core.repositories.IGenericRepository;
import com.alekzmr.core.repositories.IPersonaRepository;
import com.alekzmr.core.services.IPersonaService;

@Service
public class IPersonaServiceImpl extends ICRUDServiceImpl<Persona, Integer> implements IPersonaService{
	
	@Autowired
	private IPersonaRepository repo;
	
	@Override
	protected IGenericRepository<Persona, Integer> getRepo(){
		return repo;
	}
	
}
