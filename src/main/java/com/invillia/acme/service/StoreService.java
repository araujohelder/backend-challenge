package com.invillia.acme.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.invillia.acme.filter.StoreFilter;
import com.invillia.acme.model.Store;
import com.invillia.acme.repository.StoreRepository;

@Service
public class StoreService extends AbstractService<Store, StoreRepository> {
	
	public List<Store> search(StoreFilter storeFilter) {
		return repository.search(storeFilter);
	}

}
