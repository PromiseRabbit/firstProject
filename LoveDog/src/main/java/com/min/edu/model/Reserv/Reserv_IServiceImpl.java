package com.min.edu.model.Reserv;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.dto.AllObj_Dto;
import com.min.edu.dto.Hospi_Dto;
import com.min.edu.dto.Obj_Dto;
import com.min.edu.dto.Reserv_Dto;

@Service
public class Reserv_IServiceImpl implements Reserv_IService {

    @Autowired
    Reserv_IDao dao;

    Logger logger = LoggerFactory.getLogger(Reserv_IServiceImpl.class);

    @Override
    public List<Hospi_Dto> selectHObj(String h_regi) {
        logger.info("selectHObj 실행 : \t{}", h_regi);
        return dao.selectHObj(h_regi);
    }

    @Override
    public List<Hospi_Dto> selectHAni(String h_regi) {
        logger.info("selectHAni 실행 : \t{}", h_regi);
        return dao.selectHAni(h_regi);
    }

    @Override
    public boolean insertReser(Reserv_Dto rDto) {
        logger.info("insertReser 실행 : \t{}", rDto);
        return dao.insertReser(rDto);
    }

    @Override
    public List<Hospi_Dto> serchReser(Map<String, String> map) {
        logger.info("serchReser 실행 : \t{}", map);
        return dao.serchReser(map);
    }

    @Override
    public boolean delReser(Map<String, String> map) {
        logger.info("delReser 실행 : \t{}", map);
        return dao.delReser(map);
    }

    @Override
    public boolean modifyReser(Map<String, String> map) {
        logger.info("modifyReser 실행 : \t{}", map);
        return dao.modifyReser(map);
    }

    @Override
    public List<AllObj_Dto> selectAllObj() {
        logger.info("selectAllObj 실행 : \t{}", new Date());
        return dao.selectAllObj();
    }

    @Override
    public List<AllObj_Dto> selectAllODetail(String main_obj) {
        logger.info("selectAllODetail 실행 : \t{}", main_obj);
        return dao.selectAllODetail(main_obj);
    }

    @Override
    public Hospi_Dto selectOneHospital2(String h_regi) {
        logger.info("selectOneHospital2 실행 : \t{}", h_regi);
        return dao.selectOneHospital2(h_regi);
    }

    @Override
    public List<Reserv_Dto> serchR_Date(String h_regi) {
        logger.info("serchR_Date 실행 : \t{}", h_regi);
        return dao.serchR_Date(h_regi);
    }

    @Override
    public List<Reserv_Dto> selectAllHReser(String h_regi) {
        logger.info("selectAllHReser 실행 : \t{}", h_regi);
        return dao.selectAllHReser(h_regi);
    }

    @Override
    public List<Reserv_Dto> selectAllUReser(String u_id) {
        logger.info("selectAllUReser 실행 : \t{}", u_id);
        return dao.selectAllUReser(u_id);
    }

    @Override
    public Reserv_Dto selectOneHReser(String h_regi) {
        logger.info("selectOneHReser 실행 : \t{}", h_regi);
        return dao.selectOneHReser(h_regi);
    }

    @Override
    public Reserv_Dto selectOneUReser(String u_id) {
        logger.info("selectOneHReser 실행 : \t{}", u_id);
        return dao.selectOneUReser(u_id);
    }

}
