package ar.edu.unlp.pasae.pasaepracticabackend.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import ar.edu.unlp.pasae.pasaepracticabackend.entity.Auto;

public interface IAutoRepository extends ElasticsearchRepository<Auto, String> {
	List<Auto> findByPatente(String patente, Pageable pageable);

}

