package com.sts.mockitotesting.testClasses;

import com.sts.mockitotesting.testClasses.User;
import com.sts.mockitotesting.testClasses.UserService;
import com.sts.mockitotesting.testClasses.UserServiceImpl;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplMockTest {

    @InjectMocks
    private UserServiceImpl userBusiness;

    @Mock
    private UserService userServiceMock;

    @Test
    public void testRetrieveUsersWithNameContaining() {
        List<User> users = Arrays.asList(
            new User(1L, "John Doe"),
            new User(2L, "Jane Smith"),
            new User(3L, "Johnny Appleseed")
        );
        when(userServiceMock.retrieveUsers()).thenReturn(users);

        List<User> filteredUsers = userBusiness.retrieveUsersWithNameContaining("John");
        assertEquals(2, filteredUsers.size());
    }

    @Test
    public void testRetrieveUsersWithNameContaining_withEmptyList() {
        List<User> users = Arrays.asList();
        when(userServiceMock.retrieveUsers()).thenReturn(users);

        List<User> filteredUsers = userBusiness.retrieveUsersWithNameContaining("John");
        assertEquals(0, filteredUsers.size());
    }
}
