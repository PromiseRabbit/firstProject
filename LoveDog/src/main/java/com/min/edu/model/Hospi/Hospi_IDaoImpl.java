/**
 * 
 */
package com.min.edu.model.Hospi;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.dto.Hospi_Dto;
import com.min.edu.dto.User_Dto;

/**
 * @author octo
 *
 */
@Repository
public class Hospi_IDaoImpl implements Hospi_IDao {

	@Autowired
	private SqlSessionTemplate SqlSession;
	private final String NS ="sarang.hagae.";
	
	@Override
	public boolean insertHospital(Hospi_Dto dto) {
		int cnt = SqlSession.insert(NS+"insertHospital");
		return cnt>0?true:false;
	}

	@Override
	public boolean updateHospital(Map<String, String> map) {
		int cntU = SqlSession.update(NS+"updateHospital", map);
		return cntU>0?true:false;
	}

	@Override
	public boolean deleteHospital(String u_id) {
		int cnt = SqlSession.delete(NS+"deleteHospital");
		return cnt>0?true:false;
	}

	@Override
	public List<Hospi_Dto> selectAllHospital() {
	
		return SqlSession.selectList(NS+"selectAllHospital");
	}

	@Override
	public Hospi_Dto selectOneHospital(String u_id) {
		
		return SqlSession.selectOne(NS+"selectOneHospital", u_id);
	}
	
	@Override
	public List<Hospi_Dto> selectOneHobj(String h_regi) {
		
		return SqlSession.selectList(NS+"selectOneHobj", h_regi);
	}
	
	@Override
	public List<Hospi_Dto> selectOneHani(String h_regi) {
		
		return SqlSession.selectList(NS+"selectOneHani", h_regi);
	}

	
	@Override
	public boolean modifyHospital(Hospi_Dto dto) {
		int cnt = SqlSession.update(NS+"modifyHospital", dto);
		return cnt>0?true:false;
	}
	
	
	@Override
	public boolean insertAni(Map<String, String[]> main_ani) {
		int cnt = SqlSession.insert(NS+"insertAni", main_ani);
		return cnt>0?true:false;
	}

	@Override
	public boolean insertObj(Map<String, String[]> main_obj) {
		int cnt = SqlSession.insert(NS+"insertObj", main_obj);
		return cnt>0?true:false;
	}




	
}
