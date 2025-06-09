package com.shop.v0.Model;

import java.time.LocalTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name = "tienda")
@AllArgsConstructor
@NoArgsConstructor
public class Tienda {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id_tienda;
    @Column(nullable = false, length = 11)
        private String rut_tienda;
    @Column(nullable = false, length = 60)
        private String direccion_tienda;
    @Column(nullable = false)  // 'LocalTime' se transformará a 'Time' en MySQL :)
        private LocalTime horario_apertura;
    @Column(nullable = false)
        private LocalTime horario_cierre;

}