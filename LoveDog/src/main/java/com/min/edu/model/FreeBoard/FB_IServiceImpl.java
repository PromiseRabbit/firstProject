package com.min.edu.model.FreeBoard;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.dto.FreeBoard_Dto;
import com.min.edu.dto.Paging_Dto;

@Service
public class FB_IServiceImpl implements FB_IService{

	private Logger log = LoggerFactory.getLogger(FB_IServiceImpl.class);
	
	@Autowired
	private FB_IDao dao;
	
	
	@Override
	public boolean insertBoard(FreeBoard_Dto dto) {
		log.info("insertBoard 글작성, {}", dto);
		return dao.insertBoard(dto);
	}

	@Override
	public boolean modifyBoard(FreeBoard_Dto dto) {
		log.info("modifyBoard 글 수정, {}", dto);
		return dao.modifyBoard(dto);
	}

	@Override
	public boolean delBoard(String seq) {
		log.info("delBoard 단일 삭제, {}", seq);
		return dao.delBoard(seq);
	}

	@Override
	public boolean delflagBoard(Map<String, String[]> map) {
		log.info("delflagBoard 다중 삭제, {}", Arrays.toString(map.get("seq_")) );
		return dao.delflagBoard(map);
	}

	@Override
	public List<FreeBoard_Dto> allBoard(String selEtc, String search_option, String keyword, Paging_Dto pagingDTO) {
		log.info("allBoard 글 전체 보기, {}", new Date());
		log.info("selEtc===, {}", selEtc);
		return dao.allBoard(selEtc, search_option, keyword, pagingDTO);
	}

	@Override
	public FreeBoard_Dto detailBoard(String seq) {
		log.info("detailBoard 상세글보기, {}", seq);
		dao.readcount(seq);
		return dao.detailBoard(seq);
	}

	@Override
	public boolean replyBoard(FreeBoard_Dto dto) {
		log.info("replyBoard 답글작성, {}", dto);
		boolean iscU = dao.replyUp(dto);
		boolean iscI = dao.replyIn(dto);
		return iscI ? true:false;
	}

	@Override
	public void readcount(String seq) {
		log.info("readcount 조회수 증가, {}", seq);
		dao.readcount(seq);
		
	}
	
	@Override
	public List<FreeBoard_Dto> getBoardList(Paging_Dto pagingDTO) {
		return dao.getBoardList(pagingDTO);
	}

	@Override
	public int getRtsCount(String selEtc) {
		return dao.getRtsCount(selEtc);
	}

}
