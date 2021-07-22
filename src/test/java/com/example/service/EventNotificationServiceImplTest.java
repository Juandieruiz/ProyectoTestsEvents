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
	void testAnnounceEventNull() throws NullPointerException {

		realEvent = null;
		assertNull(realEvent);

	}

	@Test
	void testAnnounceEventNullAttendee() {

		realEvent.setAttendees(null);
		assertNull(realEvent.getAttendees());

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
}
