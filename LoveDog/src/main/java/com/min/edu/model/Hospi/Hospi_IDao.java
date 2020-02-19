package com.min.edu.model.Hospi;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.Hospi_Dto;
import com.min.edu.dto.User_Dto;

public interface Hospi_IDao {
	
	public boolean insertHospital(Hospi_Dto dto);
	public boolean updateHospital(Map<String, String> map);
	public boolean deleteHospital(String u_id)   ;
	public List<Hospi_Dto> selectAllHospital();
	public Hospi_Dto selectOneHospital(String u_id);
	public List<Hospi_Dto> selectOneHobj(String h_regi);
	public List<Hospi_Dto> selectOneHani(String h_regi);
	
	public boolean modifyHospital(Hospi_Dto dto);
	public boolean insertAni(Map<String, String[]> main_ani)        ;
	public boolean insertObj(Map<String, String[]> main_obj)        ;


}
