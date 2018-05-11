package ar.edu.unlp.pasae.pasaepracticabackend.transformer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unlp.pasae.pasaepracticabackend.dto.AutoDTO;
import ar.edu.unlp.pasae.pasaepracticabackend.entity.Auto;

@Component
public class AutoTransformer implements Transformer<Auto, AutoDTO> {

	@Override
	public AutoDTO toDTO(Auto a) {
		return new AutoDTO(a.getId(),a.getPatente(),a.getModelo(),a.getMarca(),a.getColor());
	}

	@Override
	public Auto toEntity(AutoDTO dto) {
		return new Auto(dto.getId(),dto.getPatente(),dto.getModelo(),dto.getMarca(),dto.getColor());
	}

	@Override
	public List<AutoDTO> toListDTO(List<Auto> listAuto) {
		List<AutoDTO> lista = new ArrayList<AutoDTO>();
		for (Auto a : listAuto) {
			lista.add(this.toDTO(a));
		}
		return lista;
	}

	@Override
	public Collection<AutoDTO> toCollectionDTO(List<Auto> listAuto) {
		List<AutoDTO> lista = new ArrayList<AutoDTO>();
		for (Auto a : listAuto) {
			lista.add(this.toDTO(a));
		}
		return lista;
	}

}
