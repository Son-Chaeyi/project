package com.myspring.pro27.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.pro27.member.vo.CompanyVO;
import com.myspring.pro27.member.vo.ItemVO;
import com.myspring.pro27.member.vo.MemberVO;

public interface MemberService {
	 public List listMembers() throws DataAccessException;
	 public int addMember(MemberVO memberVO) throws DataAccessException;
	 public int removeMember(String id) throws DataAccessException;
	 public MemberVO login(MemberVO memberVO) throws Exception;
	 public List listCar() throws DataAccessException;
	 public CompanyVO companyInfo(CompanyVO companyVO) throws DataAccessException;
	 public List listEmp() throws DataAccessException;
	 public List listDept() throws DataAccessException;
	 public ItemVO itemInfo(ItemVO itemVO) throws DataAccessException;
	 public List qualityTest() throws DataAccessException;
}