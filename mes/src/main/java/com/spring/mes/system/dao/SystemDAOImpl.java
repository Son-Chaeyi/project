package com.spring.mes.system.dao;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.mes.system.item.vo.ItemVO;
import com.spring.mes.system.vo.CompanyVO;
import com.spring.mes.system.vo.CustomerVO;
import com.spring.mes.system.vo.DeptVO;
import com.spring.mes.system.vo.EmpVO;
import com.spring.mes.system.vo.ProcessVO;
import com.spring.mes.system.vo.QualityTestVO;
import com.spring.mes.system.vo.StorageVO;

@Repository("systemDAO")
public class SystemDAOImpl implements SystemDAO {
	@Autowired
	private SqlSession sqlSession;
	
	//회사정보
	@Override
	public CompanyVO companyInfo(CompanyVO companyVO) throws DataAccessException {
		return sqlSession.selectOne("mapper.company.selectCompany");
	}

	//회사등록
	@Override
	public int insertCompany(CompanyVO companyVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.company.insertCompany", companyVO);
		return result;
	}

	//부서정보
	@Override
	public List departmentInfo() throws DataAccessException {
		List<DeptVO> deptList = null;
		deptList = sqlSession.selectList("mapper.dept.selectAllDepartment");
		return deptList;
	}

	//사원정보
	@Override
	public List employeeInfo() throws DataAccessException {
		List<EmpVO> empList = null;
		empList = sqlSession.selectList("mapper.emp.selectAllEmployee");
		return empList;
	}
	
	//거래처정보
	@Override
	public List customerInfo() throws DataAccessException {
		List<CustomerVO> customerList = null;
		customerList = sqlSession.selectList("mapper.customer.selectAllCustomer");
		return customerList;
	}

	//창고정보
	@Override
	public List storageInfo() throws DataAccessException {
		List<StorageVO> storageList = null;
		storageList = sqlSession.selectList("mapper.storage.selectAllStorage");
		return storageList;
	}
	
	//공정정보
	@Override
	public List processInfo() throws DataAccessException {
		List<ProcessVO> processList = null;
		processList = sqlSession.selectList("mapper.process.selectAllProcess");
		return processList;
	}

	//검사유형정보
	@Override
	public List qualityTestInfo() throws DataAccessException {
		List<QualityTestVO> qualityTestList = null;
		qualityTestList = sqlSession.selectList("mapper.qualityTest.selectAllQualityTest");
		return qualityTestList;
	}

	//부서등록
	@Override
	public int insertDept(DeptVO deptVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.dept.insertDepartment", deptVO);
		return result;
	}

	//거래처등록
	@Override
	public int insertCustomer(CustomerVO customerVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.customer.insertCustomer", customerVO);
		return result;
	}

	//회사수정
	@Override
	public int updateCompany(CompanyVO companyVO) throws DataAccessException {
		int result = sqlSession.update("mapper.company.updateCompany",companyVO);
		return result;
	}

	//회사삭제
	@Override
	public int deleteCompany(CompanyVO companyVO) throws DataAccessException {
		int result = sqlSession.delete("mapper.company.deleteCompany", companyVO);
		return result;
	}
}