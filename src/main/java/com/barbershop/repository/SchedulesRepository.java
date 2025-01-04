package com.barbershop.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.barbershop.model.Scheduling;

@Component
public class SchedulesRepository extends DAO<Scheduling> {
	
	public Set<Scheduling> schedules = new HashSet<>();
	
	public SchedulesRepository() {
		super(Scheduling.class);
	}
	
	public List<Scheduling> findAllByClientId(Long clientId) {
		String jpql = "SELECT s FROM Scheduling s WHERE s.client.id = :clientId";
		TypedQuery<Scheduling> query = em.createQuery(jpql, Scheduling.class)
				.setParameter("clientId", clientId);
		
		List<Scheduling> result = query.getResultList();
		return result;
	}
	
}
