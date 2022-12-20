package com.sejong.vue.virtual.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.sejong.vue.model.User;
import com.sejong.vue.model.Virtualnum;

@Mapper
public interface VirtualMapper {

	ArrayList<Virtualnum> selectVtlist();

	User searchUser(String id);

	void virtualinput(Virtualnum virtualnum);

	int vnumdelete(String vnumber);

	int pathdelete(String path);

	int virtualupdate(Virtualnum virtualnum);

	int virtualdelete(int vtNum);

	Object userInput(User user);


}
