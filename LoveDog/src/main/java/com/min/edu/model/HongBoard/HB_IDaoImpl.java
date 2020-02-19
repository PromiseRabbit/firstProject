package com.min.edu.model.HongBoard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.dto.HongBoard_Dto;

@Repository
public class HB_IDaoImpl implements HB_IDao{

	private Logger log = LoggerFactory.getLogger(HB_IDaoImpl.class);

	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String NS = "sarang.hagae.";
	

	@Override
	public boolean hinsertBoard(HongBoard_Dto dto) {
		int cnt = sqlSession.insert(NS+"hinsertBoard", dto);
		return cnt>0?true:false;
	}

	@Override
	public boolean hmodifyBoard(HongBoard_Dto dto) {
		int cnt  = sqlSession.update(NS+"hmodifyBoard", dto);
		return cnt>0?true:false;
	}

	@Override
	public boolean hdelBoard(String seq) {
		int cnt = sqlSession.update(NS+"hdelBoard", seq);
		return cnt>0?true:false;
	}

	@Override
	public boolean hdelflagBoard(Map<String, String[]> map) {
		int cnt = sqlSession.update(NS+"hdelflagBoard", map);
		return cnt>0?true:false;
	}

	@Override
	public List<HongBoard_Dto> hallBoard() {
		return sqlSession.selectList(NS+"hallBoard");
	}

	@Override
	public List<HongBoard_Dto> hdetailBoard(Map<String, String> map) {
	//	Map<String, String> map = new HashMap<String, String>();
		map.put("h_regi", map.get("h_regi"));
		map.put("seq", map.get("seq"));
		log.info("h_regi=====>{}",map.get("h_regi"));
		log.info("seq=====>{}",map.get("seq"));
		return sqlSession.selectList(NS+"hdetailBoard", map);
	}

	
	@Override
	public boolean hreplyUp(HongBoard_Dto dto) {
		int cntU = sqlSession.update(NS+"hreplyUp", dto);
		return cntU>0?true:false;
	}

	@Override
	public boolean hreplyIn(HongBoard_Dto dto) {
		int cntI = sqlSession.insert(NS+"hreplyIn", dto);
		return cntI>0?true:false;
	}

	@Override
	public void hreadcount(String seq) {
		sqlSession.update(NS+"hreadcount", seq);
	
	}

}
