package com.shop.v0.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shop.v0.Model.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long>{
    @Query("SELECT r FROM Region r WHERE r.nombre_region = :nombre_region")
    List<Region> mostrar_region(@Param("nombre") String nombre);

}