package com.shop.v0.Model;

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
@Table(name = "contacto")
@AllArgsConstructor
@NoArgsConstructor
public class Contacto {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id_contacto;
    @Column(nullable = false, length = 15)
        private String email;
    @Column(nullable = false, length = 15)
        private String telefono;
}