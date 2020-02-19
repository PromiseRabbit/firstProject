package com.min.edu.model.Hospi;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.dto.Hospi_Dto;
import com.min.edu.dto.User_Dto;

import oracle.sql.DATE;
@Service
public class Hospi_IServiceImpl implements Hospi_IService {

	private Logger logger = LoggerFactory.getLogger(Hospi_IServiceImpl.class);
	
	@Autowired
	private Hospi_IDao dao;
	
	/**
	 * <h2>병원 등록 신청</h2>
	 * @param 병원DTO
	 * @return 성공여부 성공true &#47; 실패 false
	 */
	@Override
	public boolean insertHospital(Hospi_Dto dto) {
		logger.info("병원등록신청 insertHospital: {}", dto);
		boolean isc = dao.insertHospital(dto);
		return isc?true:false;
	}

	
	/**
	 * <h2>병원등록 허가</h2>
	 * @param 유저의 User_Dto 
	 * @return 성공여부 성공true &#47; 실패 false
	 */
	@Override
	public boolean updateHospital(Map<String, String> map) {
		logger.info("병원등록 허가 updateHospital", new DATE());
		boolean isc = dao.updateHospital(map);
		return isc?true:false;
	}

	
	/**
	 * <h2>병원 삭제</h2>
	 * @param 화면에서 받아온 user의 id
	 * @return 성공여부 성공true &#47; 실패 false
	 */
	@Override
	public boolean deleteHospital(String u_id) {
		logger.info("병원 삭제 deleteHospital", u_id);
		return dao.deleteHospital(u_id);
	}

	
	/**
	 * <h2>병원 전체조회</h2>
	 * @return 탈퇴 혹은 삭제된 병원을 포함한 모든 병원
	 */
	@Override
	public List<Hospi_Dto> selectAllHospital() {
		logger.info("병원 전체 조회 selectAllHospital", new DATE());
		return dao.selectAllHospital();
	}

	
	/**
	 * <h2>병원 상세조회 </h2>
	 * @param 화면에서 받아온 user의 id
	 * @return Hospi_Dto
	 */
	@Override
	public Hospi_Dto selectOneHospital(String u_id) {
		logger.info("병원 상세조회  selectOneHospital", new DATE());
		dao.selectOneHospital(u_id);
		return dao.selectOneHospital(u_id);
	}

	
	/**
	 * <h2>병원 진료과 상세조회 </h2>
	 * @param 화면에서 받아온 user의 h_regi
	 * @return String
	 */
	@Override
	public List<Hospi_Dto> selectOneHobj(String h_regi) {
		logger.info("병원 진료과 상세조회  selectOneHobj", new DATE());
		return dao.selectOneHobj(h_regi);
	}

	
	/**
	 * <h2>병원 진료동물 상세조회 </h2>
	 * @param 화면에서 받아온 user의 h_regi
	 * @return String
	 */
	@Override
	public List<Hospi_Dto> selectOneHani(String h_regi) {
		logger.info("병원 진료동물 상세조회  selectOneHani", new DATE());
		return dao.selectOneHani(h_regi);
	}
	
	
	/**
	 * <h2>병원 정보 수정 </h2>
	 * @param 화면에서 받아온 user의 u_id
	 * @return Hospi_Dto
	 */
	@Override
	public boolean modifyHospital(Hospi_Dto dto) {
		logger.info("병원 정보 수정  modifyHospital", new DATE());
		dao.modifyHospital(dto);
		return dao.modifyHospital(dto);
	}
//	@Override
//	public boolean modifyHospital(Map<String, String> map) {
//		logger.info("병원 정보 수정  modifyHospital", new DATE());
//		dao.modifyHospital(u_id);
//		return dao.modifyHospital(u_id);
//	}
	
	
	/**
	 * <h2>진료동물 추가</h2>
	 * @param 기존 등록되어 있는 진료동물
	 * @return 성공여부 성공true &#47; 실패 false
	 */
	@Override
	public boolean insertAni(Map<String, String[]> main_ani) {
		logger.info("진료동물 추가  insertAni", main_ani);
		boolean isc = dao.insertAni(main_ani);
		return isc?true:false;
	}

	
	/**
	 * <h2>진료과 추가</h2>
	 * @param 기존 등록되어있는 진료과목
	 * @return 성공여부 성공true &#47; 실패 false
	 */
	@Override
	public boolean insertObj(Map<String, String[]> main_obj) {
		logger.info("진료과 추가  insertObj", main_obj);
		boolean isc = dao.insertObj(main_obj);
		return isc?true:false;
	}








}
