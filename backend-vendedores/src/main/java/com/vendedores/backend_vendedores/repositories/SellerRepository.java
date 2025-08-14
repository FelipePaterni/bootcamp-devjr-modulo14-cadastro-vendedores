package com.vendedores.backend_vendedores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendedores.backend_vendedores.models.Seller;

public interface SellerRepository extends JpaRepository<Seller,Long>{

    
}