package com.spring.mes.system.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mes.system.dao.SystemDAO;
import com.spring.mes.system.vo.CompanyVO;
import com.spring.mes.system.vo.CustomerVO;
import com.spring.mes.system.vo.DeptVO;
import com.spring.mes.system.vo.ItemVO;

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

	//품목정보
	@Override
	public List itemInfo() throws DataAccessException {
		List itemList = null;
		itemList = systemDAO.itemInfo();
		return itemList;
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

	//품목등록
	@Override
	public int insertItem(ItemVO itemVO) throws DataAccessException {
		return systemDAO.insertItem(itemVO);
	}

	//거래처등록
	@Override
	public int insertCustomer(CustomerVO customerVO) throws DataAccessException {
		return systemDAO.insertCustomer(customerVO);
	}
}