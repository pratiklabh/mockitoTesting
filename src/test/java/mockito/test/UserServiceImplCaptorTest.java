package com.sts.mockitotesting.testClasses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplCaptorTest {

    private UserService userService;
    private UserServiceImpl userServiceImpl;

    @Captor
    private ArgumentCaptor<String> stringCaptor;

    @BeforeEach
    public void setUp() {
        userService = Mockito.mock(UserService.class);
        userServiceImpl = new UserServiceImpl(userService);
    }

    @Test
    public void testRetrieveUsersWithNameContainingUsingCaptor() {
        List<User> users = Arrays.asList(
                new User(1L, "Alice"),
                new User(2L, "Bob"),
                new User(3L, "Charlie"),
                new User(4L, "Alicia")
        );

        when(userService.retrieveUsers()).thenReturn(users);

        // Call the method under test
        userServiceImpl.retrieveUsersWithNameContaining("Ali");

        // Capture the argument passed to the retrieveUsersWithNameContaining method
        verify(userServiceImpl).retrieveUsersWithNameContaining(stringCaptor.capture());
        
        // Assert that the correct argument was passed
        assertEquals("Ali", stringCaptor.getValue());

        // Also verify the result of the method call
        List<User> filteredUsers = userServiceImpl.retrieveUsersWithNameContaining("Ali");
        assertEquals(2, filteredUsers.size());
        assertEquals("Alice", filteredUsers.get(0).getName());
        assertEquals("Alicia", filteredUsers.get(1).getName());
    }
}
