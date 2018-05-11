package ar.edu.unlp.pasae.pasaepracticabackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ar.edu.unlp.pasae.pasaepracticabackend.entity.Auto;
import ar.edu.unlp.pasae.pasaepracticabackend.repository.IAutoRepository;

@Component
public class AppStartupRunnerES implements ApplicationRunner {

	@Autowired
	private IAutoRepository autoRepository;

	public IAutoRepository getAutoRepository() {
		return autoRepository;
		}

	@Override
	public void run(final ApplicationArguments args) throws Exception {
		//for (int i = 0; i < 1000; i++) {
		//	getAutoRepository().save(new Auto("AAA" + i,  i % 2 == 0  ? "Volkswagen" : "Chevrolet" , String.valueOf(i),
		//		i % 2 == 0 ? "Red" : "White"));
		//}
	}

	public void setAutoRepository(final IAutoRepository autoRepository) {
		this.autoRepository = autoRepository;
	}

}
