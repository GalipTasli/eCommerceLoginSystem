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
		System.out.println("Email doðrulanmasý sona erdi.");
		return matcher.find();
	}

	@Override
	public boolean CheckEmailIfCorrect2(User user) {
		if(user.geteMail().isEmpty()) {
			System.out.println("Email bulunamadý.");
			return false;
		}
		System.out.println("Email sistemde bulundu."+user.geteMail());
		return true;
	}

	@Override
	public boolean CheckPasswordIfLenth(User user) {
		if(user.getPassword().length()>=6) {
			System.out.println("þifre baþarýlý");
			return true;
		}
		System.out.println("þifreniz 6 karakter veya daha fazla karakter içermelidir!!");
		return false;
	}

	@Override
	public boolean CheckNameAndSurnameIfCorrect(User user) {
		if(user.getName().length()<2 && user.getSurName().length()<2)
		{
			System.out.println("isimler en az  karakterden oluþmalýdýr");
			return false;
		}
		System.out.println("isimler baþarýlý");
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
			System.out.println("kayýt iþlemi baþarýlý");
			return true;
			
		}
		else
		{
			System.out.println("kayýt iþlemi baþarýsýz");
			return false;
		}
		
	}

	@Override
	public boolean SendVerificationMessage(User user) {
		if (CheckEmailIfCorrect(user)&& CheckEmailIfCorrect2(user)) {
			return true;
		}else {
			System.out.println("Email adresiniz doðrulama aþamasýný geçemedi, kurallara uyduðunuza dikkat edin.");
			return false;
		}
			
	}

	@Override
	public void Login(User user) {
		System.out.println("Giriþ iþlemi daha önceden doðrulanmýþ olan email ve þifre üzerinden otomatik olarak gerçekleþtirilmektedir.");
		System.out.println("email: "+user.geteMail());
		System.out.println("þifre: "+user.getPassword());
		
	}

	

}
