package eCommerceLoginSystem.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eCommerceLoginSystem.business.abstracts.GoogleAdaptService;
import eCommerceLoginSystem.entities.concretes.User;

public class GoogleAdaptManager implements GoogleAdaptService {

	@Override
	public boolean connectGoogle(User user) {
		String emailRegex="^[a-z0-9](\\.?[a-z0-9]){5,}@g(oogle)?mail\\.com$";
		Pattern emailPat= Pattern.compile(emailRegex,Pattern.CASE_INSENSITIVE);
		Matcher matcher= emailPat.matcher(user.geteMail());
		System.out.println("Google Email hesabınızı kontrol ediliyor. "
				+ "Cevap true ise eğer işlemleriniz sorunsuz bir şekilde tamamlanacaktır, "
				+ "eğer cevap false ise işleminiz tamamlanamayacaktır: "+matcher.find());
		return matcher.find();
	}

}
