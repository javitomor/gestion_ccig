package mil.candes.core.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mil.candes.core.model.Promotor;
import mil.candes.core.repository.PromotorRepository;

@Service("promotorService")
public class PromotorService {
	
	@Autowired
	PromotorRepository promotorRepository;
	
	public List<Promotor> getPromotores(){
		List<Promotor> promotores = new ArrayList<>();
		for (Promotor promotor : promotorRepository.getPromotores()) {
			promotores.add(promotor);
		}
		return promotores;
	}

}
