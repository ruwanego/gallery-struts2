package net.feminaexlux.gallery.struts2.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import net.feminaexlux.gallery.struts2.controller.AuthenticationAware;
import net.feminaexlux.gallery.struts2.model.Session;

import java.util.Map;

public class LoginInterceptor extends AbstractInterceptor {

	public static final String LOGIN_REDIRECT = "loginRedirect";

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		if (actionInvocation == null || actionInvocation.getAction() == null) {
			throw new NullPointerException();
		}

		if (actionInvocation.getAction() instanceof AuthenticationAware) {
			// Check session
			Map<String, Object> sessionMap = ActionContext.getContext().getSession();
			if (sessionMap != null && !sessionMap.isEmpty()) {
				Session session = (Session) sessionMap.get("session");
				if (session != null && session.isValidLogin()) {
					session.updateActivity();
					return actionInvocation.invoke();
				} else {
					return LOGIN_REDIRECT;
				}
			} else {
				return LOGIN_REDIRECT;
			}
		}

		return actionInvocation.invoke();
	}
}
