package net.feminaexlux.gallery.struts2.utility;

import net.feminaexlux.gallery.struts2.model.ResourceType;
import net.feminaexlux.gallery.struts2.model.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.security.InvalidParameterException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class StringUtilityTest {
	@Mock
	private User user;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testIsEmpty_ValidString() throws Exception {
		assertFalse(StringUtility.isEmpty("Valid string"));
	}

	@Test
	public void testIsEmpty_Null() throws Exception {
		assertTrue(StringUtility.isEmpty(null));
	}

	@Test
	public void testIsEmpty_EmptyString() throws Exception {
		assertTrue(StringUtility.isEmpty(""));
	}

	@Test
	public void testIsEmpty_Spaces() throws Exception {
		assertTrue(StringUtility.isEmpty("              "));
	}

	@Test
	public void testEncrypt_ValidUserValidPassword() throws Exception {
		int id = 12345;
		String hash = DigestUtils.sha1Hex(ResourceType.ADMIN + "password" + id);

		when(user.getId()).thenReturn(id);
		when(user.getType()).thenReturn(new ResourceType(ResourceType.ADMIN));

		assertEquals(hash, StringUtility.encrypt("password", user));
	}

	@Test(expected = InvalidParameterException.class)
	public void testEncrypt_NullUser() throws Exception {
		StringUtility.encrypt("password", null);
	}

	@Test(expected = InvalidParameterException.class)
	public void testEncrypt_NullPassword() throws Exception {
		StringUtility.encrypt(null, user);
	}

	@Test
	public void testCreateSlug_ValidString() throws Exception {
		assertEquals("hello-world", StringUtility.createSlug("Hello World"));
		assertEquals("hello-world-123", StringUtility.createSlug("Hello World 123"));
		assertEquals("hello-world", StringUtility.createSlug("HELLO!WORLD"));
		assertEquals("hello-world", StringUtility.createSlug("Hello @*(#&$ World"));
		assertEquals("hello-world", StringUtility.createSlug("Hello World (*#@&$)#@(*$&"));
	}

	@Test(expected = InvalidParameterException.class)
	public void testCreateSlug_InvalidString() throws Exception {
		StringUtility.createSlug("(*#@&$)#@(*$&");
	}

	@Test(expected = InvalidParameterException.class)
	public void testCreateSlug_EmptyString() throws Exception {
		StringUtility.createSlug("");
	}

	@Test(expected = InvalidParameterException.class)
	public void testCreateSlug_NullString() throws Exception {
		StringUtility.createSlug(null);
	}
}
