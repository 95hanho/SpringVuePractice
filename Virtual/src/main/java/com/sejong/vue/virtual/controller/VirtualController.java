package com.sejong.vue.virtual.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sejong.vue.model.User;
import com.sejong.vue.model.Virtualnum;
import com.sejong.vue.virtual.service.VirtualService;

@RestController
public class VirtualController {
	
	@Autowired
	private VirtualService vtService;
	
	// bean등록된 비밀번호암호화 클래스
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	// 로그인
	@PostMapping("/api/login")
	public Map<String, Object> login(@RequestBody Map<String, User> list){
		User user = vtService.searchUser(list.get("user").getId());
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		if(user != null) {
			if(passwordEncoder.matches(list.get("user").getPassword(), user.getPassword())) {
				result.put("success", true);
				result.put("message", "Login successful!");
			} else {
				result.put("success", false);
				result.put("message", "Login failed please check your password");
			} 
		} else {
			result.put("success", false);
			result.put("message", "Login failed please check your id");
		}
		
		return result;
	}
	
	// 유저 추가(회원가입)
	@PostMapping("/api/user/userInput")
	public Map<String, Object> userInput(@RequestBody User user){
		Map<String, Object> result = new HashMap<String, Object>();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		System.out.println(user);
		
		String sqlResult = vtService.userInput(user);
		
		if(sqlResult.equals("duplicate")) {
			result.put("result", "fail");
			result.put("message", "아이디가 중복되었습니다.");
		} else if(sqlResult.equals("fail")) {
			result.put("result", "fail");
			result.put("message", "SQL 문제발생");
		} else {
			result.put("result", "success");
			result.put("message", "유저 추가 성공!!");
		}
		return result;
	}

//	---------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	// 멘트 조회
	@GetMapping("/api/virtual")
	public ArrayList<Virtualnum> selectVtlist() {
		return vtService.selectVtlist();
	}
	
	// 멘트 추가
	@PostMapping("/api/virtual/virtualinput")
	public Map<String, Object> virtualinput(@RequestBody Map<String, Virtualnum> list){
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			vtService.virtualinput(list.get("virtualnum"));
			result.put("success", true);
			result.put("message", "가상번호입력완료");
		} catch (Exception e) {
			result.put("success", false);
			result.put("message", "입력실패");
		}
		
		return result;
	}
	
	// 멘트 수정
	@PostMapping("/api/virtual/virtualupdate")
	public Map<String, Object> virtualupdate(@RequestBody Map<String, Virtualnum> list){
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			int y = vtService.virtualupdate(list.get("virtualnum"));
			if(y >= 1) {
				result.put("success", true);
				result.put("message", "수정완료");
			} else {
				result.put("success", false);
				result.put("message", list.get("virtualnum").getVnumber() + "가상번호의 수정 실패");
			}
		} catch (Exception e) {
			result.put("success", false);
			result.put("message", "서버 오류");
		}
		
		return result;
		
	}
	
	// 멘트 삭제
	@PostMapping("/api/virtual/virtualdelete")
	public Map<String, Object> virtualdelete(@RequestBody Map<String, Virtualnum> list){
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			int y = vtService.virtualdelete(list.get("virtualnum").getVtNum());
			if(y >= 1) {
				result.put("success", true);
				result.put("message", "삭제완료");
			} else {
				result.put("success", false);
				result.put("message", list.get("virtualnum").getVnumber() + "가상번호의 삭제 실패");
			}
		} catch (Exception e) {
			result.put("success", false);
			result.put("message", "서버 오류");
		}
		
		return result;
	}
	
	// 멘트 삭제(가상번호로)
	@PostMapping("/api/virtual/vnumdelete")
	public Map<String, Object> vnumdelete(@RequestBody Map<String, String> list){
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			int y = vtService.vnumdelete(list.get("vnumber"));
			if(y >= 1) {
				result.put("success", true);
			} else {
				result.put("success", false);
				result.put("message", list.get("vnumber")+ " 가상번호와 일치하는 데이터가 없습니다.");
			}
		} catch (Exception e) {
			result.put("success", false);
			result.put("message", "서버 오류");
		}
		
		return result;
	}
	
	// 멘트 삭제(경로로)
	@PostMapping("/api/virtual/pathdelete")
	public Map<String, Object> pathdelete(@RequestBody Map<String, String> list){
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			int y = vtService.pathdelete(list.get("path"));
			if(y >= 1) {
				result.put("success", true);
			} else {
				result.put("success", false);
				result.put("message", list.get("path")+ " 경로와 일치하는 데이터가 없습니다.");
			}
		} catch (Exception e) {
			result.put("success", false);
			result.put("message", "서버 오류");
		}
		
		return result;
	}
	
}
