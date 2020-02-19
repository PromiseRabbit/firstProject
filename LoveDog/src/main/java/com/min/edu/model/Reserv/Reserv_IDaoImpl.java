package com.min.edu.model.Reserv;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.dto.AllObj_Dto;
import com.min.edu.dto.Hospi_Dto;
import com.min.edu.dto.Obj_Dto;
import com.min.edu.dto.Reserv_Dto;

@Repository
public class Reserv_IDaoImpl implements Reserv_IDao {

    @Autowired
    SqlSessionTemplate session;

    String NS = "sarang.hagae.reser.";

    @Override
    public List<Hospi_Dto> selectHObj(String h_regi) {

        return session.selectList(NS + "selectHObj", h_regi);
    }

    @Override
    public List<Hospi_Dto> selectHAni(String h_regi) {

        return session.selectList(NS + "selectHAni", h_regi);
    }

    @Override
    public boolean insertReser(Reserv_Dto rDto) {
        int cnt = session.insert(NS + "insertReser", rDto);
        return cnt > 0 ? true : false;
    }

    @Override
    public List<Hospi_Dto> serchReser(Map<String, String> map) {

        return session.selectList(NS + "serchReser", map);
    }

    @Override
    public boolean delReser(Map<String, String> map) {
        int cnt = session.update(NS + "delReser", map);
        return cnt > 0 ? true : false;
    }

    @Override
    public boolean modifyReser(Map<String, String> map) {
        int cnt = session.update(NS + "modifyReser", map);
        return cnt > 0 ? true : false;
    }

    @Override
    public List<AllObj_Dto> selectAllObj() {

        return session.selectList(NS + "selectAllObj");
    }

    @Override
    public List<AllObj_Dto> selectAllODetail(String main_obj) {

        return session.selectList(NS + "selectAllODetail", main_obj);
    }

    @Override
    public Hospi_Dto selectOneHospital2(String h_regi) {

        return session.selectOne(NS + "selectOneHospital2", h_regi);
    }

    @Override
    public List<Reserv_Dto> serchR_Date(String h_regi) {

        return session.selectList(NS + "serchR_Date", h_regi);
    }

    @Override
    public List<Reserv_Dto> selectAllHReser(String h_regi) {

        return session.selectList(NS + "selectAllHReser", h_regi);
    }

    @Override
    public List<Reserv_Dto> selectAllUReser(String u_id) {

        return session.selectList(NS + "selectAllUReser", u_id);
    }

    @Override
    public Reserv_Dto selectOneHReser(String h_regi) {

        return session.selectOne(NS + "selectOneHReser", h_regi);
    }

    @Override
    public Reserv_Dto selectOneUReser(String u_id) {

        return session.selectOne(NS + "selectOneUReser", u_id);
    }


}
