package ar.edu.unlp.pasae.pasaepracticabackend.service;

import java.util.Collection;

import ar.edu.unlp.pasae.pasaepracticabackend.dto.AutoDTO;

public interface IAutoService {

	Collection<AutoDTO> findByPatente(String patente);

}
