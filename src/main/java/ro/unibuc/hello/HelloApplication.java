package ro.unibuc.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import ro.unibuc.hello.data.InformationEntity;
import ro.unibuc.hello.data.InformationRepository;
import ro.unibuc.hello.data.MedicamentEntity;
import ro.unibuc.hello.data.MedicamentRepository;
import ro.unibuc.hello.dto.Medicament;
import ro.unibuc.hello.data.FarmacistEntity;
import ro.unibuc.hello.data.FarmacistRepository;
import ro.unibuc.hello.dto.Farmacist;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = {InformationRepository.class, MedicamentRepository.class})

public class HelloApplication {

	@Autowired
	private InformationRepository informationRepository;
	@Autowired
	private MedicamentRepository medicamentRepository;
	@Autowired
	private FarmacistRepository farmacistRepository;


	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
	}

	@PostConstruct
	public void runAfterObjectCreated() {
		informationRepository.deleteAll();
		informationRepository.save(new InformationEntity("Overview",
				"This is an example of using a data storage engine running separately from our applications server")
				);
		medicamentRepository.deleteAll();
		medicamentRepository.save(new MedicamentEntity("Medicamente",new ArrayList<Medicament>()));
		farmacistRepository.deleteAll();
		farmacistRepository.save(new FarmacistEntity("Farmacisti",new ArrayList<Farmacist>()));

	}

}
