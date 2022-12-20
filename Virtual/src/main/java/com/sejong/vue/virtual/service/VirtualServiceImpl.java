package com.sejong.vue.virtual.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sejong.vue.model.User;
import com.sejong.vue.model.Virtualnum;
import com.sejong.vue.virtual.dao.VirtualDAO;

@Service
public class VirtualServiceImpl implements VirtualService {
	
	@Autowired
	private VirtualDAO vtDAO;

	@Override
	public ArrayList<Virtualnum> selectVtlist() {
		return vtDAO.selectVtlist();
	}

	@Override
	public User searchUser(String id) {
		return vtDAO.searchUser(id);
	}

	@Override
	public void virtualinput(Virtualnum virtualnum) {
		vtDAO.virtualinput(virtualnum);
	}

	@Override
	public int vnumdelete(String vnumber) {
		return vtDAO.vnumdelete(vnumber);
	}

	@Override
	public int pathdelete(String path) {
		return vtDAO.pathdelete(path);
	}

	@Override
	public int virtualupdate(Virtualnum virtualnum) {
		return vtDAO.virtualupdate(virtualnum);
	}

	@Override
	public int virtualdelete(int vtNum) {
		return vtDAO.virtualdelete(vtNum);
	}

	@Override
	public String userInput(User user) {
		return vtDAO.userInput(user);
	}

}
