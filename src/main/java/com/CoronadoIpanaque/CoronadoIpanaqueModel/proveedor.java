package com.CoronadoIpanaque.CoronadoIpanaqueModel;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="proveedor")

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class proveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer idProveedor;
	@Column(nullable = false, length = 60)
	private String nombreProveedor;
	@Column(nullable = false, length = 60)
	private Integer rucProveedor;
	@Column(nullable = false, length = 60)
	private String tipoProductoProveedor;
	@Column(nullable = false, length = 100)
	private LocalDate fechaIngreso;
}
