package com.invillia.acme.repository.store;

import java.util.List;

import com.invillia.acme.filter.StoreFilter;
import com.invillia.acme.model.Store;

public interface StoreRepositoryQuery {
	
	public List<Store> search(StoreFilter storeFilter);
	
}