package com.example;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.service.EventNotificationServiceImpl;
import com.sun.jdi.event.EventSet;

class EventTest {

	Event event;

	@BeforeEach
	void setUp() throws Exception {
		event = new Event();
	}

	@Test
	@DisplayName("Prueba")
	void testAddAttendee() {

		Attendee person1 = new Attendee(1L, "Persona 1", "");
		Attendee person2 = new Attendee(2L, "Persona 2", "");

		event.addAttendee(person1);
		assertEquals(1, event.getAttendees().size());

		event.addAttendee(person2);
		assertEquals(2, event.getAttendees().size());

		assertEquals("Persona 1", event.getAttendees().get(0).getNickname());
	}

	@Test
	@DisplayName("Prueba")
	void testAddAttendeeNull() {

		event.addAttendee(null);

		assertEquals(0, event.getAttendees().size());
	}

	@Test
	@DisplayName("Prueba")
	void testAddAttendeeListNull() throws Exception {
		Event evento = new Event(1l, "El evento del año", EventType.BUSINESS, new EventNotificationServiceImpl());

		evento.setAttendees(null);
		assertEquals(null, evento.getAttendees());
		Attendee person1 = new Attendee(1L, "Persona 1", "");

		evento.addAttendee(person1);
		assertEquals(1, evento.getAttendees().size());
	}

	@Test
	@DisplayName("Prueba")
	void testAddAttendeeAlreadyContains() {

		assertEquals(0, event.getAttendees().size());

		Attendee person1 = new Attendee(1L, "Persona 1", "");

		event.addAttendee(person1);

		assertEquals(1, event.getAttendees().size());

		event.addAttendee(person1);

		assertEquals(1, event.getAttendees().size());

	}

	// ============================== Attendees =======================
	@Test
	void testaddAttendees() {

		List<Attendee> attendees = new ArrayList<Attendee>();

		Attendee person1 = new Attendee(1L, "Ana", "correo de Ana");
		Attendee person2 = new Attendee(2L, "Juan", "correo de Juan");
		Attendee person3 = new Attendee(null, "Pepe", "correo de Pepe");

		event.addAttendees(attendees);
 
	}

	@Test
	void testAddAttendeesNull() {

		
		event.addAttendees(null);

		assertEquals(event,event);
		

	}

	@Test
	void testAddAttendeesListNull() throws Exception {

		event.setAttendees(null);
		List<Attendee> persons = new ArrayList<Attendee>();

		Attendee person1 = new Attendee(1L, "Ana", "correo de Ana");
		
		
		persons.add(person1);
		
		event.addAttendees(persons);
	
		assertEquals(event.getAttendees().size(), 1);

	}

	@Test
	void testAddAttendeesAlreadyContains() {

		List<Attendee> personas = new ArrayList<Attendee>();
		
		Attendee person1 = new Attendee(1L, "Ana", "correo de Ana");
		

		personas.add(person1);
		
		event.addAttendees(personas);
		
		assertEquals(1, event.getAttendees().size());
		
		
		
		

	}

	
	@Test
	void testRemoveAttendeeNull() {
	}

	@Test
	void testRemoveAttendees() {
		fail("Not yet implemented");
	}

	@Test
	void testNotifyAssistants() {
		fail("Not yet implemented");
	}

	@Test
	void testAddSpeaker() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveSpeaker() {
		fail("Not yet implemented");
	}

}
