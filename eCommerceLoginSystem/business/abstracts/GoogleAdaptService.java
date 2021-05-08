package eCommerceLoginSystem.business.abstracts;

import eCommerceLoginSystem.entities.concretes.User;

public interface GoogleAdaptService {
	public boolean connectGoogle(User user);

}
