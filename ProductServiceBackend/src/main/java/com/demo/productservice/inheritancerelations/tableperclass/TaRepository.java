package com.demo.productservice.inheritancerelations.tableperclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaRepository extends JpaRepository<Ta, Long> {
	@Override
	Ta save(Ta ta);
}
