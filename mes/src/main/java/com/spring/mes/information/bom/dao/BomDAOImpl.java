package com.spring.mes.information.bom.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.mes.information.bom.vo.BomVO;

@Repository("bomDAO")
public class BomDAOImpl implements BomDAO{
	@Autowired
	private SqlSession sqlSession;
	
	//BOM리스트
	@Override
	public List bomList() throws DataAccessException {
		List<BomVO> bomList = null;
		bomList = sqlSession.selectList("mapper.bom.searchBomList");
		return bomList;
	}

	//BOM등록
	@Override
	public int insertBom(BomVO bomVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.bom.insertBom", bomVO);
		return result;
	}
}
