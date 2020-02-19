package com.min.edu.model.HongBoard;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.dto.HongBoard_Dto;

@Service
public class HB_IServiceImpl implements HB_IService{

	
	private Logger log = LoggerFactory.getLogger(HB_IServiceImpl.class);
	
	@Autowired
	private HB_IDao dao;
	
	
	
	@Override
	public boolean hinsertBoard(HongBoard_Dto dto) {
		log.info("hinsertBoard 글작성, {}", dto);
		return dao.hinsertBoard(dto);
	}

	@Override
	public boolean hmodifyBoard(HongBoard_Dto dto) {
		log.info("hmodifyBoard 글 수정, {}", dto);
		return dao.hmodifyBoard(dto);
	}

	@Override
	public boolean hdelBoard(String seq) {
		log.info("hdelBoard 단일 삭제, {}", seq);
		return dao.hdelBoard(seq);
	}

	@Override
	public boolean hdelflagBoard(Map<String, String[]> map) {
		log.info("hdelflagBoard 다중 삭제, {}", map);
		return dao.hdelflagBoard(map);
	}

	@Override
	public List<HongBoard_Dto> hallBoard() {
		log.info("hallBoard 글 전체 보기, {}", new Date());
		return dao.hallBoard();
	}

	@Override
	public List<HongBoard_Dto> hdetailBoard(Map<String, String> map) {
		log.info("hdetailBoard 상세글보기, {}", map);
	//	log.info("h_regi==={}", h_regi);
	//	log.info("seq==={}", seq);
	//    Map<String, String> map = new HashMap<String, String>();
			dao.hreadcount(map.get("seq"));
		//	dao.hreadcount(seq);
			log.info("seq========>{}", map.get("seq"));
		return dao.hdetailBoard(map);
	}

	@Override
	public boolean hreplyBoard(HongBoard_Dto dto) {
		log.info("replyBoard 답글작성, {}", dto);
		boolean iscU = dao.hreplyUp(dto);
		boolean iscI = dao.hreplyIn(dto);
		return iscI ? true:false;
	}

	@Override
	public void hreadcount(String seq) {
		log.info("hreadcount 조회수 증가, {}", seq);
		dao.hreadcount(seq);
		
	}
}


