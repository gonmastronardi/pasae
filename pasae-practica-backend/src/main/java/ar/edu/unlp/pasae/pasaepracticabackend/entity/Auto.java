package ar.edu.unlp.pasae.pasaepracticabackend.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import org.springframework.data.elasticsearch.annotations.Document;


@Document(indexName = "autos", shards = 5, replicas = 1)

public class Auto {
	
	
	@SuppressWarnings("unused")
	private Auto() {
		super();
	}
	
	public Auto(Long id, String patente, String modelo, String marca, String color) {
		super();
		this.setId(id);
		this.setPatente(patente);
		this.setModelo(modelo);
		this.setMarca(marca);
		this.setColor(color);

	}

	public Auto( String patente, String modelo, String marca, String color) {
		super();
		this.setPatente(patente);
		this.setModelo(modelo);
		this.setMarca(marca);
		this.setColor(color);

	}

	@Id   @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	private String patente;
	private String modelo;
	private String marca;
	private String color;
	
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @return the patente
	 */
	public String getPatente() {
		return patente;
	}
	/**
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}
	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param id the id to set
	 */
	private void setId(Long id) {
		this.id = id;
	}
	/**
	 * @param patente the patente to set
	 */
	private void setPatente(String patente) {
		this.patente = patente;
	}
	/**
	 * @param modelo the modelo to set
	 */
	private void setModelo(String modelo) {
		this.modelo = modelo;
	}
	/**
	 * @param marca the marca to set
	 */
	private void setMarca(String marca) {
		this.marca = marca;
	}
	/**
	 * @param color the color to set
	 */
	private void setColor(String color) {
		this.color = color;
	}
	
	
}
