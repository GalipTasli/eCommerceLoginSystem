package eCommerceLoginSystem.dataAccess.abstracts;

import eCommerceLoginSystem.entities.concretes.User;

public interface UserDaoService {
	public void add(User user);
	public void delete(User user);
	public void update(User user);
	public User getAll();

}
