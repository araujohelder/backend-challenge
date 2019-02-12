package com.invillia.acme.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractService<E, T extends JpaRepository<E, Long>> {
	
	@Autowired
	protected T repository;
	
	
	public E findByid(Long id) {
		Optional<E> obj = repository.findById(id);
		if (obj.isPresent() ) {
			return obj.get();
		}
		throw new EmptyResultDataAccessException(1);
	}
	
	public List<E> findAll() {
		 return  repository.findAll();
	}
	
	public void delete(Long id) {
		E obj = this.findByid(id);
		repository.delete(obj);
	}

	public E save(E obj)  {
		return repository.save(obj);
	}

	public E update(Long id, E obj) {
		E objReturn = this.findByid(id);
		BeanUtils.copyProperties(obj, objReturn, "id");
		this.repository.save(objReturn);
		return objReturn;
	}
	
	public void deleteAll() {
		this.repository.deleteAll();
	}
}
