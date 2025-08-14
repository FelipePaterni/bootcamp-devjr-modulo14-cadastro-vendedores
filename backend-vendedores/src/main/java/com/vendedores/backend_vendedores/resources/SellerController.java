package com.vendedores.backend_vendedores.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vendedores.backend_vendedores.DTO.SellerRequest;
import com.vendedores.backend_vendedores.DTO.SellerResponse;
import com.vendedores.backend_vendedores.services.SellerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("sellers")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @GetMapping
    public ResponseEntity<List<SellerResponse>> getAllSellers() {
        return ResponseEntity.ok(sellerService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<SellerResponse> getByID(@PathVariable long id) {
        SellerResponse seller = sellerService.getById(id);
        return ResponseEntity.ok(seller);
    }

    @PostMapping
    public ResponseEntity<SellerResponse> save(@Validated @RequestBody SellerRequest sellerRequest) {
        SellerResponse sellerResponse = sellerService.save(sellerRequest);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("./{id}")
                .buildAndExpand(sellerResponse.getId())
                .toUri();

        return ResponseEntity.created(location).body(sellerResponse);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable long id, @Valid @RequestBody SellerRequest sellerUpdate) {
        sellerService.update(id, sellerUpdate);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        sellerService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
