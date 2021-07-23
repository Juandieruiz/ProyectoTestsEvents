package com.example.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.Attendee;
import com.example.Event;
import com.example.EventType;


class EventNotificationServiceImplTest {

	EventNotificationService eventNotificationService = new EventNotificationServiceImpl();

	Event realEvent = new Event(1L, "Evento Mock", EventType.BUSINESS, eventNotificationService);

	Attendee person1 = new Attendee(1L, "JuanDiego", "arroba@gmail.com");
	Attendee person2 = new Attendee(1L, "JoseLuis", "arroba@gmail.com");

	@Test
	void testAnnounceEventNull() {

		realEvent.addAttendee(person1);
		
		assertEquals(0, person1.getNotifications().size());
		eventNotificationService.announce(null);
		
		assertEquals(0, person1.getNotifications().size());
		
		
	}

	@Test
	void testAnnounceEventNullAttendee() {

		realEvent.setAttendees(null);
		assertEquals(0,person1.getNotifications().size());
		}

		@Test
		void testListAnnounceNull() {
		realEvent.notifyAssistants();
		assertNull(realEvent.getAttendees());
	}

	@Test
	void testAnnounceAttendeeIsEmpty() {
		assertTrue(realEvent.getAttendees().isEmpty());

		realEvent.notifyAssistants();
		assertTrue(realEvent.getAttendees().isEmpty());
	}
	
	@Test
	void testAttendanceEventNull() {

	}
	
	@Test
	void testMultiplesAsistentes() {

		Attendee person1 = new Attendee(1L, "JuanDiego", "arroba@gmail.com");
		Attendee person2 = new Attendee(1L, "JoseLuis", "arroba@gmail.com");
		
		realEvent.addAttendee(person1);
		realEvent.addAttendee(person2);
		
		//ejecutar el metodo testear
		eventNotificationService.announce(realEvent);
		
		//comprobar
		assertEquals(1, person1.getNotifications().size());
		
	}
}
