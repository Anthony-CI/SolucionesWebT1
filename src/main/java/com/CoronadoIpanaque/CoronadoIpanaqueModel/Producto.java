package com.CoronadoIpanaque.CoronadoIpanaqueModel;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="producto")
//@Table (name = "producto")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer idProducto;
	@Column(nullable = false, length = 60)
	private String nombreProducto;
	@Column(nullable = false, length = 60)
	private Integer sku;
	@Column(nullable = false, length = 60)
	private String categoria;
	@Column(nullable = false, length = 60)
	private String tipoProducto;
	@Column(nullable = false, length = 100)
	private LocalDate fechaVencimiento;
	
}
