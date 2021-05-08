package eCommerceLoginSystem.business.abstracts;

import eCommerceLoginSystem.business.concretes.GoogleAdaptManager;
import eCommerceLoginSystem.entities.concretes.User;

public interface UserService {
	public boolean CheckEmailIfCorrect(User user);
	public boolean CheckEmailIfCorrect2(User user);
	public boolean CheckPasswordIfLenth(User user);
	public boolean CheckNameAndSurnameIfCorrect(User user);
	public boolean EmailFormat(User user, GoogleAdaptManager googleAdaptManager);
	public boolean Register(User user);
	public boolean  SendVerificationMessage(User user);
	public void Login(User user);
	
	
	
	

}
