package com.example;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.service.EventNotificationServiceImpl;

@ExtendWith(MockitoExtension.class)
class EventNotificationTest {

	@Mock
	EventNotificationServiceImpl notificationService;

	@InjectMocks
	Event event;

	@Test
	void testNotificationService() throws Exception {

		event.notifyAssistants();

		verify(notificationService, times(1)).announce(event);
	}

}