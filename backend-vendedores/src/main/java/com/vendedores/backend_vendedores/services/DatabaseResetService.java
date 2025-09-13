package com.vendedores.backend_vendedores.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.vendedores.backend_vendedores.models.Seller;
import com.vendedores.backend_vendedores.repositories.SellerRepository;

@Service
public class DatabaseResetService {

    @Autowired
    private SellerRepository repository;

    // Agendado para rodar todo dia à meia-noite
    @Scheduled(cron = "0 0 0 * * ?")
    public void resetDatabase() {
        repository.deleteAll(); // limpa todos os dados

        // dados base
        repository.saveAll(List.of(
           new Seller("Carlos Silva", 0, 99.0, 1600.00),
            new Seller("Ana Souza", 1, 100.0, 1800.00),
            new Seller("João Pereira", 0, 85.0, 1500.00)
        ));
        LocalDate currentDateTime = LocalDate.now();
        System.out.println("Banco resetado e populado com dados base!" + currentDateTime );
    }
}
