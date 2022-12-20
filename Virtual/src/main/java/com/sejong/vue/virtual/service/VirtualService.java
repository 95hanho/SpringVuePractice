package com.sejong.vue.virtual.service;

import java.util.ArrayList;

import com.sejong.vue.model.User;
import com.sejong.vue.model.Virtualnum;

public interface VirtualService {

	ArrayList<Virtualnum> selectVtlist();

	User searchUser(String id);

	void virtualinput(Virtualnum virtualnum);

	int vnumdelete(String vnumber);

	int pathdelete(String path);

	int virtualupdate(Virtualnum virtualnum);

	int virtualdelete(int vtNum);

	String userInput(User user);

}
