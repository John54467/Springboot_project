package io.reflectoring.jvcart.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.reflectoring.jvcart.entity.Order;


public interface OrderRepository extends JpaRepository<Order,Long>{
	Optional<Order>findByReferenceId(String referencdId);

}
