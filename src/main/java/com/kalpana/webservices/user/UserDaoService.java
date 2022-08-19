package com.kalpana.webservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList();
	private static int userCount = 4;
	static {
		users.add(new User(1, "Kalpana", new Date()));
		users.add(new User(2, "Krithikesh", new Date()));
		users.add(new User(3, "Sarevana", new Date()));
		users.add(new User(4, "Pradyun", new Date()));
	}

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		if (user.getId() == null) {
			++userCount;
			user.setId(userCount);
		}

		users.add(user);

		return user;
	}

	public User findById(Integer id) {
		for (User us : users) {
			if (us.getId() == id) {
				return us;
			}
		}
		return null;
	}

}
