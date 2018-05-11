package ar.edu.unlp.pasae.pasaepracticabackend.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unlp.pasae.pasaepracticabackend.dto.AutoDTO;
import ar.edu.unlp.pasae.pasaepracticabackend.service.IAutoService;

@RestController
@RequestMapping("/auto")
public class AutoController {

	@Autowired
	private IAutoService autoService;

	@GetMapping(path = "/findByPatente")
	public Collection<AutoDTO> findByPatente(final String patente) {
				return getAutoService().findByPatente(patente);
	}

	private IAutoService getAutoService() {
			return autoService;
	}

}
