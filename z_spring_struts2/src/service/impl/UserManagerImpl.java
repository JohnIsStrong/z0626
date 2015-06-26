package service.impl;

import pojo.User;
import servcie.UserManager;

public class UserManagerImpl implements UserManager {

	@Override
	public User login(String uname, String psd) {
		// TODO Auto-generated method stub
		if ("john".equals(uname) && "123".equals(psd)) {
			User u = new User();
			u.setUname("john");
			u.setSex(true);
			return u;

		} else {
			return null;
		}
	}

}
