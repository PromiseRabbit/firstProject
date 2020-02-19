package com.min.edu.model.FreeBoard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.ctrl.FBController;
import com.min.edu.dto.FreeBoard_Dto;
import com.min.edu.dto.Paging_Dto;

@Repository
public class FB_IDaoImpl implements FB_IDao{

	private Logger log = LoggerFactory.getLogger(FB_IDaoImpl.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String NS = "sarang.hagae.";
	
	
	@Override
	public boolean insertBoard(FreeBoard_Dto dto) {
		int cnt = sqlSession.insert(NS+"insertBoard", dto);
		return cnt>0?true:false;
	}

	@Override
	public boolean modifyBoard(FreeBoard_Dto dto) {
		int cnt  = sqlSession.update(NS+"modifyBoard", dto);
		return cnt>0?true:false;
	}

	@Override
	public boolean delBoard(String seq) {
		
		log.info("seq=====>{}",seq);
		
		int cnt = sqlSession.update(NS+"delBoard", seq);
		
		log.info("cnt=====>{}",cnt);
		
		return cnt>0?true:false;
	}

	@Override
	public boolean delflagBoard(Map<String, String[]> map) {
	//	map.put("seq_", map.get("seq"));
	//	log.info("map=====>{}",map);
		int cnt = sqlSession.delete(NS+"delflagBoard", map);
		return cnt>0?true:false;
	}


	@Override
	public List<FreeBoard_Dto> allBoard(String selEtc, String search_option, String keyword, Paging_Dto pagingDTO) {
		Map<String, String> map = new HashMap<String, String>();
		
		log.info("getStartRowNum==============>{}",pagingDTO.getStartRowNum());
		log.info("getEndRowNum==============>{}",pagingDTO.getEndRowNum());
		
		map.put("startRowNum", Integer.toString(pagingDTO.getStartRowNum()));
		map.put("endRowNum", Integer.toString(pagingDTO.getEndRowNum()));
		map.put("selEtc", selEtc);
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		return sqlSession.selectList(NS+"allBoard", map);
	}
	
	@Override
	public FreeBoard_Dto detailBoard(String seq) {
		return sqlSession.selectOne(NS+"detailBoard", seq);
	}

	@Override
	public boolean replyUp(FreeBoard_Dto dto) {
		int cntU = sqlSession.update(NS+"replyUp", dto);
		return cntU>0?true:false;
	}

	@Override
	public boolean replyIn(FreeBoard_Dto dto) {
		int cntI = sqlSession.insert(NS+"replyIn", dto);
		return cntI>0?true:false;
	}

	@Override
	public void readcount(String seq) {
		sqlSession.update(NS+"readcount", seq);
	}


	@Override
	public List<FreeBoard_Dto> getBoardList(Paging_Dto pagingDTO) {
		return sqlSession.selectList(NS+"getBoardList", pagingDTO);
	}

	@Override
	public int getRtsCount(String selEtc) {
		return (Integer)sqlSession.selectOne(NS+"getRtsCount", selEtc);
	}
		

}
