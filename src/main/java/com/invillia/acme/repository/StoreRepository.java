package com.invillia.acme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invillia.acme.model.Store;
import com.invillia.acme.repository.store.StoreRepositoryQuery;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryQuery {

}
