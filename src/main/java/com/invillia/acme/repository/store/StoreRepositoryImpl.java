package com.invillia.acme.repository.store;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.util.StringUtils;

import com.invillia.acme.filter.StoreFilter;
import com.invillia.acme.model.Store;

public class StoreRepositoryImpl implements StoreRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Store> search(StoreFilter storeFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Store> criteria = builder.createQuery(Store.class);
		Root<Store> root = criteria.from(Store.class);
		Predicate[] predicate = createRestrictions(storeFilter, builder, root);
  		criteria.where(predicate);
  		criteria.orderBy(builder.asc(root.get("name")));
		TypedQuery<Store> query = manager.createQuery(criteria);
		return query.getResultList();
	}

	private Predicate[] createRestrictions(StoreFilter storeFilter, CriteriaBuilder builder, Root<Store> root) {
		
		List<Predicate> predicates = new ArrayList<Predicate>();

		if (!StringUtils.isEmpty(storeFilter.getName())) {
			predicates.add(builder.like(
					builder.lower(root.get("name")), "%" + storeFilter.getName().toLowerCase() + "%" ));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
}