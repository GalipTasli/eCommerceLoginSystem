package eCommerceLoginSystem.core.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eCommerceLoginSystem.core.abstracts.ValidationService;

public class ValidationManager implements ValidationService {

	@Override
	public boolean valEmail(String input) {
		String emailRegex="^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		Pattern emailPat= Pattern.compile(emailRegex,Pattern.CASE_INSENSITIVE);
		Matcher matcher= emailPat.matcher(input);
		return matcher.find();
	}

}
