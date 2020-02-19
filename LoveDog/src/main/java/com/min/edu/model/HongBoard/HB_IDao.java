package com.min.edu.model.HongBoard;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.HongBoard_Dto;


public interface HB_IDao {

		// 글 작성
		public boolean hinsertBoard(HongBoard_Dto dto);
		
		// 글 수정
		public boolean hmodifyBoard(HongBoard_Dto dto);
		
		// 글 삭제
		public boolean hdelBoard(String seq);
		
		// 다중 삭제
		public boolean hdelflagBoard(Map<String, String[]> map);
		
		// 전체 글 보기
		public List<HongBoard_Dto> hallBoard();
		
		// 상세 글 보기
		public List<HongBoard_Dto> hdetailBoard(Map<String, String> map);
		
		// 답글(UPDATE)
		public boolean hreplyUp(HongBoard_Dto dto);
		
		// 답글 (INSERT)
		public boolean hreplyIn(HongBoard_Dto dto);
		
		// 조회수 증가
		public void hreadcount(String seq);
	
	
	
	
	
}
