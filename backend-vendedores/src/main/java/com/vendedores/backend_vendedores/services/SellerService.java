package com.vendedores.backend_vendedores.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendedores.backend_vendedores.DTO.SellerRequest;
import com.vendedores.backend_vendedores.DTO.SellerResponse;
import com.vendedores.backend_vendedores.models.Seller;
import com.vendedores.backend_vendedores.repositories.SellerRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SellerService {
    @Autowired
    private SellerRepository sellerRepository;

    public SellerResponse save(SellerRequest sellerRequest) {
        Seller newSeller = sellerRepository.save(sellerRequest.toEntity());
        return newSeller.toDTO();
    }

    public SellerResponse getById(long id) {
        Seller seller = sellerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Seller not found"));
        return seller.toDTO();
    }

    public List<SellerResponse> getAll() {
        return sellerRepository.findAll()
                .stream()
                .map(s -> s.toDTO())
                .collect(Collectors.toList());
    }

    public void deleteById(long id) {
        if (sellerRepository.existsById(id)) {
            sellerRepository.deleteById(id);
        } else
            throw new EntityNotFoundException("Seller not found");
    }

    public void update(long id, SellerRequest sellerUpdate) {
        try {
            Seller seller = sellerRepository.getReferenceById(id);
            seller.setName(sellerUpdate.getName());
            seller.setSalary(sellerUpdate.getSalary());
            seller.setGender(sellerUpdate.getGender());
            seller.setBonus(sellerUpdate.getBonus());
            sellerRepository.save(seller);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Product not found");
        }
    }
}
