package io.reflectoring.jvcart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import io.reflectoring.jvcart.entity.product;

public interface ProductRepository extends JpaRepository<product,Long>,JpaSpecificationExecutor<product>{

}
