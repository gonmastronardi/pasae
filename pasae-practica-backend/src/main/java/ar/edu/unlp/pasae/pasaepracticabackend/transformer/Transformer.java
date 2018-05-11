package ar.edu.unlp.pasae.pasaepracticabackend.transformer;

import java.util.Collection;
import java.util.List;

public interface Transformer <Entity, DTO> {
	DTO toDTO(Entity e);
	Entity toEntity(DTO dto);
	List<DTO> toListDTO(List<Entity> list);
	Collection<DTO> toCollectionDTO(List<Entity> list);
}
