package ca.mcgill.ecse321.eventregistration.persistence;


import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.eventregistration.dao.EventRegistrationRepository;
import ca.mcgill.ecse321.eventregistration.dao.PersonRepository;
import ca.mcgill.ecse321.eventregistration.model.Event;
import ca.mcgill.ecse321.eventregistration.service.EventRegistrationService;

@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersistenceTests {

	@Autowired
	private EventRegistrationRepository dao;

	@Autowired
	private EventRegistrationService service;

	@Autowired
	private PersonRepository personRepository;

	@After
	public void clearDatabase() {
		personRepository.deleteAll();
	}

	@Ignore
	@Test
	public void repositoryTest() {

		dao.createPerson("RepositoryPerson");

		dao.createEvent("e1", new Date(1999,9,9), new Time(10, 0, 0), new Time(12,0,0));

		List<Event> eventsBeforeADeadline = dao.getEventsBeforeADeadline(new Date(2000,1,1));
		for (Event event : eventsBeforeADeadline) {
			System.out.println(event.toString());
		}
	}

	//@Ignore
	@Test
	public void serviceTest( ) {
		service.createPerson("ServicePerson");
	}

}
