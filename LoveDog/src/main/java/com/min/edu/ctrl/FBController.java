package com.min.edu.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.min.edu.dto.FreeBoard_Dto;
import com.min.edu.dto.Paging_Dto;
import com.min.edu.dto.User_Dto;
import com.min.edu.model.FreeBoard.FB_IService;


@Controller
public class FBController {
   
	// 자유게시판 컨트롤러
	
	private Logger log = LoggerFactory.getLogger(FBController.class);

	@Autowired
	private FB_IService service;
	
	@RequestMapping(value = "/freeboard.do" , method = RequestMethod.GET)
	public ModelAndView freeBoard(Model model, HttpSession session,
			@ModelAttribute("pagingDTO") Paging_Dto pagingDTO,
			String selEtc, 
			@RequestParam(defaultValue="u_id") String search_option, 
			@RequestParam(defaultValue="") String keyword,   //키워드의 기본값을 "" 공백으로
			@RequestParam(value = "pageNo", required = false) String pageNo
	) {
		
		pagingDTO.setPageSize(5); // 한 페이지에 보일 게시글 수
		pagingDTO.setPageNo(1); // 현재 페이지 번호
		if(StringUtils.isNotEmpty(pageNo)){
			pagingDTO.setPageNo(Integer.parseInt(pageNo));
		}
		pagingDTO.setBlockSize(5);
		pagingDTO.setTotalCount(service.getRtsCount(selEtc)); // 게시물 총 개수
		
		log.info("search_option {}", search_option);
		log.info("keyword {}", keyword);
		log.info("selEtc {}", selEtc);
				
		List<FreeBoard_Dto> lists = service.allBoard(selEtc, search_option, keyword, pagingDTO);
		model.addAttribute("lists", lists);
		
		ModelAndView mav = new ModelAndView();
        Map<String,Object> map = new HashMap<>();
        
        model.addAttribute("paging", pagingDTO);
        
        
        //
        User_Dto udto =  (User_Dto) session.getAttribute("user");
        map.put("auth", udto.getU_auth());
        log.info("udto : {}", udto);
        //

        //
        User_Dto adto = (User_Dto) session.getAttribute("user");
        map.put("u_id", adto.getU_id());
        //
        
        map.put("list", lists);                         
        map.put("search_option", search_option);
        map.put("selEtc", selEtc);
        map.put("keyword", keyword);
        mav.addObject("map", map);  
        mav.setViewName("freeboard");
 
        log.info("mav : {}", mav);
        
        return mav;    
		
	}
	
	@RequestMapping(value = "/reviewboard.do", method = RequestMethod.GET)
	public ModelAndView reviewboard(Model model,@ModelAttribute("pagingDTO") Paging_Dto pagingDTO,
			String selEtc, 
			@RequestParam(defaultValue="u_id") String search_option, 
			@RequestParam(defaultValue="") String keyword,   //키워드의 기본값을 "" 공백으로
			@RequestParam(value = "pageNo", required = false) String pageNo
	) {
		log.info("search_option {}", search_option);
		log.info("keyword {}", keyword);
		log.info("selEtc {}", selEtc);
		
		pagingDTO.setPageSize(5); // 한 페이지에 보일 게시글 수
		pagingDTO.setPageNo(1); // 현재 페이지 번호
		if(StringUtils.isNotEmpty(pageNo)){
			pagingDTO.setPageNo(Integer.parseInt(pageNo));
		}
		pagingDTO.setBlockSize(5);
		pagingDTO.setTotalCount(service.getRtsCount(selEtc)); // 게시물 총 개수
		
		List<FreeBoard_Dto> lists = service.allBoard(selEtc, search_option, keyword, pagingDTO);
		model.addAttribute("lists", lists);
		
		ModelAndView mav = new ModelAndView();
        Map<String,Object> map = new HashMap<>();
              
        map.put("list", lists);                         
        map.put("search_option", search_option);
        map.put("selEtc", selEtc);
        map.put("keyword", keyword);
        model.addAttribute("paging", pagingDTO);
        mav.addObject("map", map);  
        mav.setViewName("reviewboard");
        log.info("mav : {}", mav);
        
        return mav;    
		
	}
	
	@RequestMapping(value = "/noticeboard.do", method = RequestMethod.GET)
	public ModelAndView noticeboard(Model model,String selEtc,HttpSession session, 
			@ModelAttribute("pagingDTO") Paging_Dto pagingDTO,
			@RequestParam(defaultValue="u_id") String search_option, 
			@RequestParam(defaultValue="") String keyword,   //키워드의 기본값을 "" 공백으로
			@RequestParam(value = "pageNo", required = false) String pageNo
	) {
		log.info("search_option {}", search_option);
		log.info("keyword {}", keyword);
		log.info("selEtc {}", selEtc);
				
		pagingDTO.setPageSize(5); // 한 페이지에 보일 게시글 수
		pagingDTO.setPageNo(1); // 현재 페이지 번호
		if(StringUtils.isNotEmpty(pageNo)){
			pagingDTO.setPageNo(Integer.parseInt(pageNo));
		}
		pagingDTO.setBlockSize(5);
		pagingDTO.setTotalCount(service.getRtsCount(selEtc)); // 게시물 총 개수
		
		List<FreeBoard_Dto> lists = service.allBoard(selEtc, search_option, keyword, pagingDTO);
		model.addAttribute("lists", lists);
		
		ModelAndView mav = new ModelAndView();
        Map<String,Object> map = new HashMap<>();
              
        //
        User_Dto udto =  (User_Dto) session.getAttribute("user");
        map.put("auth", udto.getU_auth());
        log.info("udto : {}", udto);
        //
        
        map.put("list", lists);                         
        map.put("search_option", search_option);
        map.put("selEtc", selEtc);
        map.put("keyword", keyword);
        model.addAttribute("paging", pagingDTO);
        mav.addObject("map", map);  
        mav.setViewName("noticeboard");
        log.info("mav : {}", mav);
        
        return mav;    
		
	}
	
	@RequestMapping(value = "/detail.do", method = RequestMethod.GET)
	public String detail(Model model, String seq, HttpSession session,String u_id) {
		log.info("상세보기 detail.do{}", seq);
		
		
		User_Dto ddto = (User_Dto) session.getAttribute("user");
		log.info("ddto-->{}", ddto.getU_id());
		
		FreeBoard_Dto dto = new FreeBoard_Dto();
        dto.setU_id(u_id);
		
        
        model.addAttribute("tdto", ddto);
      log.info("ddto===>{}", ddto);
    //    log.info("dto===>{}", dto);
      
      
	//	
		FreeBoard_Dto lists = service.detailBoard(seq);
		model.addAttribute("lists", lists);
		
	//
        User_Dto udto = (User_Dto) session.getAttribute("user");
        log.info("udto-->{}", udto.getU_auth());
		if(udto.getU_auth().trim().equalsIgnoreCase("A")) {
			return "Adetail";
		}else {
			return "detail";
		}
		
	}	
	
	@RequestMapping(value = "/del.do" , method = RequestMethod.GET)
	public String delBoard(String seq, String selEtc) {
		log.info("단일 삭제 del.do{}", seq);
		boolean isc = service.delBoard(seq);
		log.info("selEtc===={}", selEtc);
		log.info("isc=======>"+isc);
		switch (selEtc) {
		case "F":
			return isc?"redirect:/freeboard.do?selEtc="+selEtc:"redirect:/detail.do";
		case "R":
			return isc?"redirect:/reviewboard.do?selEtc="+selEtc:"redirect:/detail.do";
		default:
			return isc?"redirect:/noticeboard.do?selEtc="+selEtc:"redirect:/detail.do";
		}
		
		
	}
	
	
	@RequestMapping(value = "/write.do", method = RequestMethod.GET)
    public String writeA(Model model, String selEtc) {
          FreeBoard_Dto dto = new FreeBoard_Dto();
          dto.setB_type(selEtc);
          model.addAttribute("mdto", dto);
          log.info("글작성  dto.do \t {}", dto);
          return "write";
    }
	
	
	// 글쓰기 폼 -> 등록
	@RequestMapping(value = "/Nwrite.do", method = RequestMethod.POST)
	public String write(FreeBoard_Dto dto, String selEtc,Model model, HttpSession session){
		
		log.info("글작성  Nwrite.do \t {}", dto);
		User_Dto sdto = (User_Dto) session.getAttribute("user");
		dto.setU_id(sdto.getU_id());
		dto.setB_type(selEtc);
	
		boolean isc = service.insertBoard(dto);
		switch (selEtc) {
		case "F":
			return isc?"redirect:/freeboard.do?selEtc="+selEtc:"redirect:/write.do";
		case "R":
			return isc?"redirect:/reviewboard.do?selEtc="+selEtc:"redirect:/write.do";
		default:
			return isc?"redirect:/noticeboard.do?selEtc="+selEtc:"redirect:/write.do";
		}	
	}
	
	
	
	// 수정 폼 -> 수정하기
	@RequestMapping(value = "/modify.do", method = RequestMethod.POST)
	public String modify(FreeBoard_Dto dto, String selEtc) {
		log.info("수정 modify.do : \t{}", dto);
		boolean isc = service.modifyBoard(dto);
		log.info("selEtc===={}", selEtc);
		log.info("isc=======>"+isc);
		switch (selEtc) {
		case "F":
			return isc?"redirect:/freeboard.do?selEtc="+selEtc:"redirect:/modify.do";
		case "R":
			return isc?"redirect:/reviewboard.do?selEtc="+selEtc:"redirect:/modify.do";
		default:
			return isc?"redirect:/noticeboard.do?selEtc="+selEtc:"redirect:/modify.do";
		}	
	}
	
	// 상세보기 -> 수정 폼
	@RequestMapping(value = "/modifyForm.do", method = RequestMethod.GET)
	public String modifyA(Model model, String seq) {
		log.info("수정폼 modifyForm.do : \t{}", seq);
		FreeBoard_Dto dto = service.detailBoard(seq);
		 model.addAttribute("dto",dto);
		return "modifyForm";
		
	}
	
	// 답글 폼 -> 답글 등록
	@RequestMapping(value="/reply.do", method = RequestMethod.POST)
	public String reply(FreeBoard_Dto dto, String selEtc) {
		log.info("답글 reply.do : \t{}", dto);
		boolean iscI =  service.replyBoard(dto);
		log.info("selEtc===={}", selEtc);
		log.info("isc=======>"+iscI);
		switch (selEtc) {
		case "F":
			return iscI?"redirect:/freeboard.do?selEtc="+selEtc:"redirect:/replyForm.do";
		case "R":
			return iscI?"redirect:/reviewboard.do?selEtc="+selEtc:"redirect:/replyForm.do";
		default:
			return iscI?"redirect:/noticeboard.do?selEtc="+selEtc:"redirect:/replyForm.do";
		}	
	}
	
	// 상세보기 -> 답글 폼으로 이동
	@RequestMapping(value = "/replyForm.do", method = RequestMethod.GET)
	public String replyA(Model model, String seq) {
		log.info("답글폼 replyForm.do : \t{}", seq);
		
		// service.detailBoard(seq) 로 디테일 정보가져오기 ?
		FreeBoard_Dto dto = service.detailBoard(seq);
		model.addAttribute("dto", dto);
		return "replyForm";
	}
	
	// 다중삭제
	@RequestMapping(value = "/delflag.do", method = RequestMethod.POST)
	public String delflag(Model model, String selEtc,String[] chkVal) {
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("seq_", chkVal);
		log.info("map==> \t{}", map);
		log.info("selEtc==> \t{}", selEtc);
		boolean isc = service.delflagBoard(map);
	
		
		switch (selEtc) {
		case "F":
			return isc?"redirect:/freeboard.do?selEtc="+selEtc:"redirect:/init.do";
		case "R":
			return isc?"redirect:/reviewboard.do?selEtc="+selEtc:"redirect:/init.do";
		default:
			return isc?"redirect:/noticeboard.do?selEtc="+selEtc:"redirect:/init.do";
		}	
	}
	
	
}













