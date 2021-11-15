package com.simple.thrillio.dao;

import com.simple.thrillio.DataStore;
import com.simple.thrillio.entities.User;

public class UserDao {
	public User[] getUsers() {
		return DataStore.getUsers();
	}

}
