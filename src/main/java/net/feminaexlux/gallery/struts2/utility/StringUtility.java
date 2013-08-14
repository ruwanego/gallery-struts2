package net.feminaexlux.gallery.struts2.utility;

import net.feminaexlux.gallery.struts2.model.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.security.InvalidParameterException;

public final class StringUtility {
	public static boolean isEmpty(String check) {
		return StringUtils.isEmpty(StringUtils.trimToNull(check));
	}

	public static String encrypt(String password, User potentialUser) {
		if (isEmpty(password) || potentialUser == null) {
			throw new InvalidParameterException();
		}

		return DigestUtils.sha1Hex(potentialUser.getType().getType() + password + potentialUser.getId());
	}

	public static String createSlug(String name) throws InvalidParameterException {
		if (isEmpty(name)) {
			throw new InvalidParameterException();
		}

		String slug = name.toLowerCase()
				.replaceAll("\\W", "-") // Non alphanumeric replaced by dashes
				.replaceAll("-+", "-")  // Dashes condensed
				.replaceAll("-$", "");  // Last dash removed

		if (isEmpty(slug)) {
			throw new InvalidParameterException();
		}

		return slug;
	}
}
