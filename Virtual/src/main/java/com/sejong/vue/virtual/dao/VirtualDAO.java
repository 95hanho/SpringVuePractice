package com.sejong.vue.virtual.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sejong.vue.model.User;
import com.sejong.vue.model.Virtualnum;
import com.sejong.vue.virtual.mapper.VirtualMapper;

@Repository
public class VirtualDAO {
	
	@Autowired
	private VirtualMapper vtMapper;

	public ArrayList<Virtualnum> selectVtlist() {
		return vtMapper.selectVtlist();
	}

	public User searchUser(String id) {
		return vtMapper.searchUser(id);
	}

	public void virtualinput(Virtualnum virtualnum) {
		vtMapper.virtualinput(virtualnum);
	}

	public int vnumdelete(String vnumber) {
		return vtMapper.vnumdelete(vnumber);
	}

	public int pathdelete(String path) {
		return vtMapper.pathdelete(path);
	}

	public int virtualupdate(Virtualnum virtualnum) {
		return vtMapper.virtualupdate(virtualnum);
	}

	public int virtualdelete(int vtNum) {
		return vtMapper.virtualdelete(vtNum);
	}

	public String userInput(User user) {
		try {
			vtMapper.userInput(user);
			return "success";
		} catch (Exception e) {
			if((e.getClass()+"").contains("DuplicateKey")) {
				return "duplicate";
			} else {
				return "fail";
			}
		}
		
	}


}
