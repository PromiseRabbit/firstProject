package com.min.edu.ctrl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.edu.dto.Hospi_Dto;
import com.min.edu.dto.User_Dto;
import com.min.edu.model.Hospi.Hospi_IService;
import com.min.edu.model.Reserv.Reserv_IService;

@Controller
public class HospiController {
// 병원 Controller
	private Logger log = LoggerFactory.getLogger(HospiController.class);
	
	@Autowired
	private Hospi_IService service;
	
	@Autowired
	private Reserv_IService serviceR;

	// 관리자 첫화면
			@RequestMapping(value = "/mainH.do", method = RequestMethod.GET)
			public String mainH() {
				log.info("mainH 관리자 첫화면\t{}", new Date());
				return "HospiMain";
			}

			
			// 병원목록
			@RequestMapping(value = "/HospiList.do", method = RequestMethod.GET)
			public String HospiList(Model model) {
				log.info("HospiList \t{}", new Date());
				List<Hospi_Dto> lists = service.selectAllHospital();
				model.addAttribute("lists", lists);
				return "HospiList";
			}

			
			// 병원목록 넘어가는 과정
			@RequestMapping(value = "/regist.do", method = RequestMethod.GET)
			public String HospiAwaitList(Model model) {
				log.info("HospiAwaitList \t{}", new Date());
				List<Hospi_Dto> Alists = service.selectAllHospital();
				System.out.println();
				System.out.println(Alists);
				System.out.println();
				model.addAttribute("Alists", Alists);
				return "HospiAwaitList";
			}
			
			
			// 병원 목록 -> 병원 대기자 상세조회로 이동
			@RequestMapping(value = "/detailHospital.do", method = RequestMethod.GET)
			public String detailHospital(Model model, String u_id) {
				log.info("detailHospital 병원 상세조회 \t{}", u_id);
				
				Hospi_Dto hDto = service.selectOneHospital(u_id);
				model.addAttribute("dto", hDto);
				System.out.println(hDto);
				
				List<Hospi_Dto> Ldto = service.selectOneHobj(hDto.getH_regi());
				model.addAttribute("Ldto", Ldto);
				
				List<Hospi_Dto> Hdto = service.selectOneHani(hDto.getH_regi());
				model.addAttribute("Hdto", Hdto);
				return "HospiDetail";
			}
			
			
			// 병원권한변경
			@RequestMapping(value = "/authChange.do", method = RequestMethod.GET)
			public String authChange(@RequestParam("role") String h_enable,@RequestParam("u_id") String u_id ) {
				log.info("authChange 병원 권한변경\t{}", u_id);
				Map<String, String> map = new HashMap<String, String>();
				map.put("u_id", u_id);
				map.put("h_enable", h_enable);
				boolean isc = service.updateHospital(map);
				return "redirect:/detailHospital.do?u_id="+u_id;
			}
			
			
			// 병원목록 -> 병원 상세페이지 화면으로 이동
			@RequestMapping(value = "/HospiDnM.do", method = RequestMethod.GET)
			public String HospiDnM(Model model, String u_id) {
				log.info("HospiDnM 병원 상세조회 \t{}", u_id);
				Hospi_Dto hDto = service.selectOneHospital(u_id);
				model.addAttribute("dto", hDto);
				
				List<Hospi_Dto> Ldto = service.selectOneHobj(hDto.getH_regi());
				model.addAttribute("Ldto", Ldto);
				
				List<Hospi_Dto> Hdto = service.selectOneHani(hDto.getH_regi());
				model.addAttribute("Hdto", Hdto);
				
				return "HospiDnM";
				}
			
			
			// 병원 상세페이지화면 -> 병원정보 수정 페이지로 이동
			@RequestMapping(value = "/HospitalModify.do", method = RequestMethod.GET)
			public String HospitalModify(Model model, String u_id ) {
				log.info("HospiDnM 병원정보 수정 페이지 이동 \t{}", u_id);
				Hospi_Dto mdto = service.selectOneHospital(u_id);
				model.addAttribute("mdto", mdto);
				
				List<Hospi_Dto> Ldto = service.selectOneHobj(mdto.getH_regi());
				model.addAttribute("Ldto", Ldto);
				
				List<Hospi_Dto> Hdto = service.selectOneHani(mdto.getH_regi());
				model.addAttribute("Hdto", Hdto);
				
				return "HospitalModify";
			}
			
			
			// 병원 수정페이지 - 병원 권한변경
				@RequestMapping(value = "/authChangeM.do", method = RequestMethod.GET)
				public String authChangeM(@RequestParam("role") String h_enable,@RequestParam("u_id") String u_id ) {
					log.info("authChangeM 병원 권한변경\t{}", u_id);
					Map<String, String> map = new HashMap<String, String>();
					map.put("u_id", u_id);
					map.put("h_enable", h_enable);
					boolean isc = service.updateHospital(map);
					return "redirect:/HospitalModify.do?u_id="+u_id;
				}
			
				
			// 병원 수정페이지에서 수정과정
//				@RequestMapping(value = "/HospitalModify.do", method = RequestMethod.GET)
//				public String HospitalModify(HttpSession session, Model model, String u_id) {
//					log.info("HospitalModifyF 병원 수정완료 \t{}", u_id);
//					Hospi_Dto dto = (Hospi_Dto) session.getAttribute("u_id");
//					System.out.println(dto);
//					Map<String, String> map = new HashMap<String, String>();
//					map.put("u_id", dto.getU_id());
//					Hospi_Dto Hdto = service.modifyHospital(map);
//					return null;
//				}
				
			// 병원 수정페이지 -> 수정완료
			@RequestMapping(value = "/HospitalModifyF.do", method = RequestMethod.POST)
			public String HospitalModifyF(Hospi_Dto dto, String h_enable ,String u_id) {
				log.info("HospitalModifyF 병원 수정완료 \t{}", dto);
				System.out.println("***"+dto+"***");
				boolean isc = service.modifyHospital(dto);
				return isc?"redirect:/HospiList.do":"redirect:/HospitalModify.do";
			}
			
			
//			// 병원 수정페이지 -> 수정변경완료
//			@RequestMapping(value = "/HospitalModifyFFF.do", method = RequestMethod.GET)
//			public String HospitalModifyFFF(Hospi_Dto dto) {
//				log.info("HospitalModifyF 병원 수정 \t{}", dto);
//				
//				return null;
//			}
			
			
	}
