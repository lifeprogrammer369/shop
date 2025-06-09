package com.shop.v0.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.shop.v0.Model.Region;
import com.shop.v0.Service.RegionService;

@RestController
@RequestMapping("/api/v1/regiones")
public class RegionController {
    @Autowired
    private RegionService regionService;

    @GetMapping
    public ResponseEntity<List<Region>> listar(){
        List<Region> regiones = regionService.findAll();
        if (regiones.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(regiones);
    }
    @PostMapping
    public ResponseEntity<Region> guardar(@RequestBody Region Region) {
        Region RegionNuevo = regionService.save(Region);
        return ResponseEntity.status(HttpStatus.CREATED).body(RegionNuevo);
    }
        @GetMapping("/{id}")
    public ResponseEntity<Region> buscar(@PathVariable Integer id) {
        try{
            Region Region = regionService.findById(id);
            return ResponseEntity.ok(Region);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
            @PutMapping("/{id}")
    public ResponseEntity<Region> actualizar(@PathVariable Integer id, @RequestBody Region Region) {
        try{
            Region region = regionService.findById(id);
            region.setId(id);
            region.setNombre(Region.getNombre());
            regionService.save(region);
            return ResponseEntity.ok(Region);
        }catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    
    }
        @DeleteMapping("/{id}")
        public ResponseEntity<?> eliminar(@PathVariable Long id){
        try{
            regionService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/buscar")
    public List<Region> mostrar_regiones(@RequestParam String nombre){
        return regionService.mostrarRegionesPorNombre(nombre);
    }
}