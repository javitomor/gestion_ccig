package mil.candes.core.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mil.candes.core.model.Destino;
import mil.candes.core.repository.DestinoRepository;

@Service("destinoService")
public class DestinoService {

	@Autowired
	DestinoRepository destinoRepository;

	public List<Destino> getDestinos() {
		Destino[] destinosArray = destinoRepository.getDestinos();

		List<Destino> destinosList = new ArrayList<>();

		for (Destino destino : destinosArray) {
			destinosList.add(destino);
		}
		return destinosList;
	}
}
