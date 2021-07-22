package com.example;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.service.EventNotificationServiceImpl;

class EventTest {

	Event event;

	@BeforeEach
	void setUp() throws Exception {
		event = new Event();
	}

	// ============================== ADD Attendee =======================
	@Test
	@DisplayName("Agregar un asistente")
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
	@DisplayName("Agregar un Nullo")
	void testAddAttendeeNull() {

		event.addAttendee(null);

		assertEquals(0, event.getAttendees().size());
	}

	@Test
	@DisplayName("Agregar un asistente Nulo")
	void testAddAttendeeListNull() throws Exception {
		Event evento = new Event(1l, "El evento del año", EventType.BUSINESS, new EventNotificationServiceImpl());

		evento.setAttendees(null);
		assertEquals(null, evento.getAttendees());
		Attendee person1 = new Attendee(1L, "Persona 1", "");

		evento.addAttendee(person1);
		assertEquals(1, evento.getAttendees().size());
	}

	@Test
	@DisplayName("Prueba de Agregar asistentes, uno tras otro")
	void testAddAttendeeAlreadyContains() {

		assertEquals(0, event.getAttendees().size());

		Attendee person1 = new Attendee(1L, "Persona 1", "");

		event.addAttendee(person1);

		assertEquals(1, event.getAttendees().size());

		event.addAttendee(person1);

		assertEquals(1, event.getAttendees().size());

	}

	// ============================== ADD Attendees =======================
	@Test
	@DisplayName("Agregar asistentes")
	void testaddAttendees() {

		List<Attendee> attendees = new ArrayList<Attendee>();

//		Attendee person1 = new Attendee(1L, "Ana", "correo de Ana");
//		Attendee person2 = new Attendee(2L, "Juan", "correo de Juan");
//		Attendee person3 = new Attendee(null, "Pepe", "correo de Pepe");

		event.addAttendees(attendees);

	}

	@Test
	void testAddAttendeesNull() {

		event.addAttendees(null);

		assertEquals(event, event);

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
		Attendee person = new Attendee(1L, "Ana", "correo de Ana");

		personas.add(person);

		event.addAttendees(personas);

		assertEquals(1, event.getAttendees().size());

		personas.add(person);

		event.addAttendees(personas);

		assertEquals(1, event.getAttendees().size());
	}

	// ============================== REMOVE ATTENDEE =======================
	@Test
	void testRemoveAttendee() {

		assertEquals(0, event.getAttendees().size());

		Attendee persona1 = new Attendee(1L, "Persona1", "");

		event.addAttendee(persona1);

		assertEquals(1, event.getAttendees().size());

		event.removeAttendee(persona1);

		assertEquals(0, event.getAttendees().size());
	}

	@Test
	void testRemoveAttendeeNull() {

		Attendee attendee = new Attendee(1L, "Persona1", "");

		event.setAttendees(null);

		event.removeAttendee(attendee);
		assertEquals(0L, event.getAttendees().size());

	}

	@Test
	void testRemoveAttendeeNullList() {

//		Event evento = new Event(1L, "Evento 1", EventType.BUSINESS, new EventNotificationServiceImpl());

		event.setAttendees(null);
		assertEquals(null, event.getAttendees());

		event.removeAttendee(null);

		assertNull(event.getAttendees());

	}

	@Test
	void testRemoveAttendeeDontExist() {

		List<Attendee> personas = new ArrayList<Attendee>();

		event.removeAttendees(personas);

	}

// ============================== REMOVES ATTENDEES =======================
	@Test
	void testRemoveAttendees() {
		List<Attendee> persons = new ArrayList<Attendee>();

		event.removeAttendees(persons);

	}

	@Test
	void testRemoveAttendeesNull() {
		event.setAttendees(null);
		List<Attendee> personas = new ArrayList<Attendee>();
		Attendee persona1 = new Attendee(1L, "Persona1", "");

		personas.add(persona1);
		event.removeAttendees(personas);
		assertEquals(event.getAttendees().size(), 0);
	}

	@Test
	@DisplayName("Comprobar hay una lista de personas cuando se le paso un null")
	void testRemoveAttendeesIsNull() {

		event.removeAttendees(null);
		assertEquals(event, event);
	}

	// ============================== Speaker =======================
	@Test
	@DisplayName("Agregar un Speaker")
	void testAddSpeaker() {

		Speaker speaker1 = new Speaker(1L, "Altavoz 1", "");
		Speaker Speaker2 = new Speaker(2L, "Altavoz 2", "");

		event.addSpeaker(speaker1);
		assertEquals(1, event.getSpeakers().size());

		event.addSpeaker(Speaker2);
		assertEquals(2, event.getSpeakers().size());

	}

	@Test
	void testAddSpeakerNull() {

		event.addSpeaker(null);

		assertEquals(event, event);

	}

	@Test
	void testRemoveSpeaker() {

		assertEquals(0, event.getSpeakers().size());

		Speaker altavoz1 = new Speaker(1L, "Persona1", "");

		event.addSpeaker(altavoz1);

		assertEquals(1, event.getSpeakers().size());

		event.removeSpeaker(altavoz1);

		assertEquals(0, event.getSpeakers().size());
	}

	@Test
	void testRemoveSpeakerNull() {

		event.setSpeakers(null);
		assertEquals(null, event.getSpeakers());

		event.removeSpeaker(null);

		assertNull(event.getSpeakers());

	}

}