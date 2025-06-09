package com.shop.v0.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.v0.Model.Region;
import com.shop.v0.Repository.RegionRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class RegionService {
    @Autowired
    private RegionRepository Region_repository;

    public List<Region> findAll() {
        return Region_repository.findAll();
    }
    public Region findById(long id){
        return Region_repository.findById(id).get();
    }
    public Region save(Region Region){
        return Region_repository.save(Region);
    }
    public void delete(long id){
        Region_repository.deleteById(id);
    }
    public List<Region> mostrarRegionesPorNombre(String nombre) {
        return Region_repository.mostrar_region(nombre);
    }
}