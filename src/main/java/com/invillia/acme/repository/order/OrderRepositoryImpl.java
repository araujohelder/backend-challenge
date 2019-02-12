package com.invillia.acme.repository.order;
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

import com.invillia.acme.filter.OrderFilter;
import com.invillia.acme.model.Order;

public class OrderRepositoryImpl implements OrderRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Order> search(OrderFilter orderFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Order> criteria = builder.createQuery(Order.class);
		Root<Order> root = criteria.from(Order.class);
		Predicate[] predicate = createRestrictions(orderFilter, builder, root);
  		criteria.where(predicate);
		TypedQuery<Order> query = manager.createQuery(criteria);
		return query.getResultList();
	}

	private Predicate[] createRestrictions(OrderFilter orderFilter, CriteriaBuilder builder, Root<Order> root) {
		
		List<Predicate> predicates = new ArrayList<Predicate>();
		if (!StringUtils.isEmpty(orderFilter.getStatusEnum())) {
			
			predicates.add(builder.equal(
					builder.upper(root.get("status")), orderFilter.getStatusEnum()));
		} 
		return predicates.toArray(new Predicate[predicates.size()]);
	}
}