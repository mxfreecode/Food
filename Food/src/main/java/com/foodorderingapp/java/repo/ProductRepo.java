package com.foodorderingapp.java.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.foodorderingapp.java.dto.ProductDetailsDTO;
import com.foodorderingapp.java.dto.ProductsView;
import com.foodorderingapp.java.entity.Product;
import com.foodorderingapp.java.entity.Store;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer>{
	
	List<Product> findByStore(Store store, Pageable paging);
	
	@Query("SELECT new com.foodorderingapp.java.dto.ProductDetailsDTO(p.productDescription, p.productName) FROM Product p WHERE p.store = :store")
	List<ProductDetailsDTO> getProductDetails(Store store);
	
	//ProductsView getProductName();
}
