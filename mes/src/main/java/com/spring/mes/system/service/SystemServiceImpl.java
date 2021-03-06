package com.spring.mes.system.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mes.system.dao.SystemDAO;
import com.spring.mes.system.item.vo.ItemVO;
import com.spring.mes.system.vo.CompanyVO;
import com.spring.mes.system.vo.CustomerVO;
import com.spring.mes.system.vo.DeptVO;

@Service("systemService")
@Transactional(propagation = Propagation.REQUIRED)
public class SystemServiceImpl implements SystemService {
	@Autowired
	private SystemDAO systemDAO;
	
	//회사정보
	@Override
	public CompanyVO companyInfo(CompanyVO companyVO) throws DataAccessException {
		companyVO = systemDAO.companyInfo(companyVO);
		return companyVO;
	}

	//회사등록
	@Override
	public int insertCompany(CompanyVO companyVO) throws DataAccessException {
		return systemDAO.insertCompany(companyVO);
	}

	//부서정보
	@Override
	public List departmentInfo() throws DataAccessException {
		List deptList = null;
		deptList = systemDAO.departmentInfo();
		return deptList;
	}

	//사원정보
	@Override
	public List employeeInfo() throws DataAccessException {
		List empList = null;
		empList = systemDAO.employeeInfo();
		return empList;
	}

	//거래처정보
	@Override
	public List customerInfo() throws DataAccessException {
		List customerList = null;
		customerList = systemDAO.customerInfo();
		return customerList;
	}

	//창고정보
	@Override
	public List storageInfo() throws DataAccessException {
		List storageList = null;
		storageList = systemDAO.storageInfo();
		return storageList;
	}
	
	//공정정보
	@Override
	public List processInfo() throws DataAccessException {
		List processList = null;
		processList = systemDAO.processInfo();
		return processList;
	}

	//검사유형정보
	@Override
	public List qualityTestInfo() throws DataAccessException {
		List qualityTestList = null;
		qualityTestList = systemDAO.qualityTestInfo();
		return qualityTestList;
	}

	//부서등록
	@Override
	public int insertDept(DeptVO deptVO) throws DataAccessException {
		return systemDAO.insertDept(deptVO);
	}


	//거래처등록
	@Override
	public int insertCustomer(CustomerVO customerVO) throws DataAccessException {
		return systemDAO.insertCustomer(customerVO);
	}

	//회사수정
	@Override
	public int updateCompany(CompanyVO companyVO) throws DataAccessException {
		return systemDAO.updateCompany(companyVO);
	}

	//회사삭제
	@Override
	public int deleteCompany(CompanyVO companyVO) throws DataAccessException {
		return systemDAO.deleteCompany(companyVO);
	}
}