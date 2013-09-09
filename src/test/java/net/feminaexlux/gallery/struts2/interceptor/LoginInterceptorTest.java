package net.feminaexlux.gallery.struts2.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import net.feminaexlux.gallery.struts2.controller.AuthenticationAware;
import net.feminaexlux.gallery.struts2.model.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LoginInterceptorTest {
	private LoginInterceptor loginInterceptor;

	@Mock
	private ActionContext actionContext;
	@Mock
	private ActionInvocation actionInvocation;
	@Mock
	private Session session;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		loginInterceptor = new LoginInterceptor();

		ActionContext.setContext(actionContext);
	}

	@After
	public void tearDown() throws Exception {
		ActionContext.setContext(null);
	}

	@Test(expected = NullPointerException.class)
	public void testIntercept_ActionInvocationIsNull() throws Exception {
		loginInterceptor.intercept(null);
	}

	@Test(expected = NullPointerException.class)
	public void testIntercept_ActionIsNull() throws Exception {
		loginInterceptor.intercept(actionInvocation);
	}

	@Test
	public void testIntercept_ActionIsNotAuthenticationAware() throws Exception {
		NonAuthenticationAwareAction nonAuthenticationAwareAction = new NonAuthenticationAwareAction();
		when(actionInvocation.getAction()).thenReturn(nonAuthenticationAwareAction);
		when(actionInvocation.invoke()).thenReturn(nonAuthenticationAwareAction.execute());

		String result = loginInterceptor.intercept(actionInvocation);
		assertEquals(NonAuthenticationAwareAction.NON_AUTHENTICATION_AWARE, result);
	}

	@Test
	public void testIntercept_ActionIsAuthenticationAware_SessionMapIsEmpty() throws Exception {
		AuthenticationAwareAction authenticationAwareAction = new AuthenticationAwareAction();
		when(actionInvocation.getAction()).thenReturn(authenticationAwareAction);
		when(actionContext.getSession()).thenReturn(Collections.<String, Object>emptyMap());

		String result = loginInterceptor.intercept(actionInvocation);
		assertEquals(LoginInterceptor.LOGIN_REDIRECT, result);
	}

	@Test
	public void testIntercept_ActionIsAuthenticationAware_SessionIsNull() throws Exception {
		Map<String, Object> sessionMap = new HashMap<>();
		sessionMap.put("session", null);

		AuthenticationAwareAction authenticationAwareAction = new AuthenticationAwareAction();
		when(actionInvocation.getAction()).thenReturn(authenticationAwareAction);
		when(actionContext.getSession()).thenReturn(sessionMap);

		String result = loginInterceptor.intercept(actionInvocation);
		assertEquals(LoginInterceptor.LOGIN_REDIRECT, result);
	}

	@Test
	public void testIntercept_ActionIsAuthenticationAware_SessionIsInvalid() throws Exception {
		Map<String, Object> sessionMap = new HashMap<>();
		sessionMap.put("session", session);

		AuthenticationAwareAction authenticationAwareAction = new AuthenticationAwareAction();
		when(actionInvocation.getAction()).thenReturn(authenticationAwareAction);
		when(actionContext.getSession()).thenReturn(sessionMap);
		when(session.isValidLogin()).thenReturn(false);

		String result = loginInterceptor.intercept(actionInvocation);
		assertEquals(LoginInterceptor.LOGIN_REDIRECT, result);
	}

	@Test
	public void testIntercept_ActionIsAuthenticationAware_SessionIsValid() throws Exception {
		Map<String, Object> sessionMap = new HashMap<>();
		sessionMap.put("session", session);

		AuthenticationAwareAction authenticationAwareAction = new AuthenticationAwareAction();
		when(actionInvocation.getAction()).thenReturn(authenticationAwareAction);
		when(actionInvocation.invoke()).thenReturn(authenticationAwareAction.execute());
		when(actionContext.getSession()).thenReturn(sessionMap);
		when(session.isValidLogin()).thenReturn(true);

		String result = loginInterceptor.intercept(actionInvocation);
		assertEquals(AuthenticationAwareAction.AUTHENTICATION_AWARE, result);
		verify(session).updateActivity();
	}

	private static class AuthenticationAwareAction extends ActionSupport implements AuthenticationAware {

		public static final String AUTHENTICATION_AWARE = "authentication aware";

		@Override
		public String execute() throws Exception {
			return AUTHENTICATION_AWARE;
		}
	}

	private static class NonAuthenticationAwareAction extends ActionSupport {

		public static final String NON_AUTHENTICATION_AWARE = "non authentication aware";

		@Override
		public String execute() throws Exception {
			return NON_AUTHENTICATION_AWARE;
		}
	}
}
