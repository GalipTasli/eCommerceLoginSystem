package eCommerceLoginSystem.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eCommerceLoginSystem.business.abstracts.UserService;
import eCommerceLoginSystem.entities.concretes.User;

public class UserManager implements UserService {

	@Override
	public boolean CheckEmailIfCorrect(User user) {
		String emailRegex="^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		Pattern emailPat= Pattern.compile(emailRegex,Pattern.CASE_INSENSITIVE);
		Matcher matcher= emailPat.matcher(user.geteMail());
		System.out.println("Email do�rulanmas� sona erdi.");
		return matcher.find();
	}

	@Override
	public boolean CheckEmailIfCorrect2(User user) {
		if(user.geteMail().isEmpty()) {
			System.out.println("Email bulunamad�.");
			return false;
		}
		System.out.println("Email sistemde bulundu."+user.geteMail());
		return true;
	}

	@Override
	public boolean CheckPasswordIfLenth(User user) {
		if(user.getPassword().length()>=6) {
			System.out.println("�ifre ba�ar�l�");
			return true;
		}
		System.out.println("�ifreniz 6 karakter veya daha fazla karakter i�ermelidir!!");
		return false;
	}

	@Override
	public boolean CheckNameAndSurnameIfCorrect(User user) {
		if(user.getName().length()<2 && user.getSurName().length()<2)
		{
			System.out.println("isimler en az  karakterden olu�mal�d�r");
			return false;
		}
		System.out.println("isimler ba�ar�l�");
		return true;
	}

	@Override
	public boolean EmailFormat(User user,GoogleAdaptManager googleAdaptManager) {
		if(googleAdaptManager.connectGoogle(user)) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean Register(User user) {
		if(CheckEmailIfCorrect(user)&& CheckEmailIfCorrect2(user)&& CheckNameAndSurnameIfCorrect(user)&& CheckPasswordIfLenth(user)) {
			System.out.println("kay�t i�lemi ba�ar�l�");
			return true;
			
		}
		else
		{
			System.out.println("kay�t i�lemi ba�ar�s�z");
			return false;
		}
		
	}

	@Override
	public boolean SendVerificationMessage(User user) {
		if (CheckEmailIfCorrect(user)&& CheckEmailIfCorrect2(user)) {
			return true;
		}else {
			System.out.println("Email adresiniz do�rulama a�amas�n� ge�emedi, kurallara uydu�unuza dikkat edin.");
			return false;
		}
			
	}

	@Override
	public void Login(User user) {
		System.out.println("Giri� i�lemi daha �nceden do�rulanm�� olan email ve �ifre �zerinden otomatik olarak ger�ekle�tirilmektedir.");
		System.out.println("email: "+user.geteMail());
		System.out.println("�ifre: "+user.getPassword());
		
	}

	

}
