package net.feminaexlux.gallery.struts2.service;

import net.feminaexlux.gallery.struts2.dao.UserDAO;
import net.feminaexlux.gallery.struts2.model.ResourceType;
import net.feminaexlux.gallery.struts2.model.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.util.reflection.Whitebox;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class UserServiceTest {
	private static final int USER_ID = 123;

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
	public void testLoginUser_PasswordMatches() throws Exception {
		String hashed = DigestUtils.sha1Hex(ResourceType.USER + "password" + USER_ID);

		when(user.getId()).thenReturn(USER_ID);
		when(user.getPassword()).thenReturn(hashed);
		when(user.getType()).thenReturn(ResourceType.USER);
		when(userDAO.findByUsername(anyString())).thenReturn(user);

		User loggedInUser = userService.loginUser("test", "password");

		assertEquals(user, loggedInUser);
	}

	@Test(expected = SecurityException.class)
	public void testLoginUser_PasswordDoesNotMatch() throws Exception {
		when(user.getId()).thenReturn(USER_ID);
		when(user.getPassword()).thenReturn("other password");
		when(user.getType()).thenReturn(ResourceType.USER);
		when(userDAO.findByUsername(anyString())).thenReturn(user);

		userService.loginUser("test", "wrong password");
	}

	@Test(expected = SecurityException.class)
	public void testLoginUser_PasswordNotProvided() throws Exception {
		userService.loginUser("test", null);
	}
}
