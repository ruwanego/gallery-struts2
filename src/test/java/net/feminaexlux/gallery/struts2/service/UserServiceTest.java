package net.feminaexlux.gallery.struts2.service;

import net.feminaexlux.gallery.struts2.dao.UserDAO;
import net.feminaexlux.gallery.struts2.model.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.util.reflection.Whitebox;

import static org.junit.Assert.fail;

public class UserServiceTest {
	private UserService userService;

	@Mock
	private User user;
	@Mock
	private UserDAO userDAO;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		userService = new UserService();

		Whitebox.setInternalState(userService, "userDAO", userDAO);
	}

	@Test
	public void testLoginUser() throws Exception {
		fail("Need to implement");
	}
}
