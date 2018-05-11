package ar.edu.unlp.pasae.pasaepracticabackend.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import ar.edu.unlp.pasae.pasaepracticabackend.dto.AutoDTO;
import ar.edu.unlp.pasae.pasaepracticabackend.entity.Auto;
import ar.edu.unlp.pasae.pasaepracticabackend.repository.IAutoRepository;
import ar.edu.unlp.pasae.pasaepracticabackend.transformer.Transformer;

@Service
public class AutoServiceImpl implements IAutoService {

	@Autowired
	private IAutoRepository autoRepository;

	@Autowired
	private Transformer<Auto, AutoDTO> transformer;

	@Override
	public Collection<AutoDTO> findByPatente(final String patente) {
		// index.max_result_window = 500 en este caso
		// https://www.elastic.co/guide/en/elasticsearch/guide/current/_fetch_phase.html
		final List<Auto> autos = getAutoRepository().findByPatente(patente, PageRequest.of(0, 500));
		return this.getTransformer().toCollectionDTO(autos);
	}

	private IAutoRepository getAutoRepository() {
		return autoRepository;
	}

	private Transformer<Auto, AutoDTO> getTransformer() {
		return transformer;
	}

	@SuppressWarnings("unused")
	private void setTransformer(Transformer<Auto, AutoDTO> transformer) {
		this.transformer = transformer;
	}

}
