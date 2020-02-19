package com.min.edu.ctrl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.edu.dto.AllObj_Dto;
import com.min.edu.dto.Hospi_Dto;
import com.min.edu.dto.Obj_Dto;
import com.min.edu.dto.Reserv_Dto;
import com.min.edu.dto.User_Dto;
import com.min.edu.model.Hospi.Hospi_IService;
import com.min.edu.model.Reserv.Reserv_IService;

@Controller
public class ReservController {
//예약관련 Controller

    Logger log = LoggerFactory.getLogger(ReservController.class);

    @Autowired
    Reserv_IService service;

    @Autowired
    Hospi_IService hService;

    @RequestMapping(value = "/reserS.do",method=RequestMethod.GET)
	public String reser(Model model) {
		log.info("resr.do 작동");
		List<AllObj_Dto> lists = service.selectAllObj();
		model.addAttribute("lists",lists);
		return "reserS";
	}


    @RequestMapping(value = "/objAjax.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, List<AllObj_Dto>> objAjax(String main_obj) {
        log.info("objAjax 작동\t:{}", main_obj);
        Map<String, List<AllObj_Dto>> map = new HashMap<String, List<AllObj_Dto>>();
        List<AllObj_Dto> DLists = service.selectAllODetail(main_obj);
        map.put("DLists", DLists);
        return map;
    }

    @RequestMapping(value = "/serchReser.do", method = RequestMethod.GET)
    public String serchReser(String r_date, String main_obj, String obj_detail_code, String time, Model model) {
        log.info("serchReser 작동");
        System.out.println(time);
        System.out.println(main_obj);
        System.out.println(obj_detail_code);
        r_date = r_date.substring(0, 4) + r_date.substring(6, 8) + r_date.substring(10, 12) + time;
        System.out.println(r_date);
        Map<String, String> map = new HashMap<String, String>();
        map.put("main_obj", main_obj);
        map.put("r_date", r_date);
        map.put("obj_detail_code", obj_detail_code);
        List<Hospi_Dto> srLists = service.serchReser(map);
        model.addAttribute("lists", srLists);
        System.out.println(srLists);
        return "serchreserList";
    }

    @RequestMapping(value = "/sReserList_detail.do", method = RequestMethod.GET)
    public String sReserList_detail(String h_regi, Model model) {
        log.info("sReserList_detail 작동\t:{}", h_regi);
        Hospi_Dto dto = service.selectOneHospital2(h_regi);
        model.addAttribute("hDetail", dto);
        log.info("selectOneHospital2 list 작동\t:{}", dto);
        List<Hospi_Dto> oDto = service.selectHObj(h_regi);
        log.info("selectHObj list 작동\t:{}", oDto);
        List<Hospi_Dto> aDto = service.selectHAni(h_regi);
        log.info("selectHAni list 작동\t:{}", aDto);
        model.addAttribute("HObj", oDto);
        model.addAttribute("HAni", aDto);
        return "serchReserDetail";
    }

    @RequestMapping(value = "/insertReserForm.do", method = RequestMethod.GET)
    public String insertReserForm(String h_regi, Model model) {
        log.info("sReserList_detail 작동\t:{}", h_regi);
        Hospi_Dto dto = service.selectOneHospital2(h_regi);
        model.addAttribute("hDetail", dto);
        log.info("selectOneHospital2 list 작동\t:{}", dto);
        List<Hospi_Dto> oDto = service.selectHObj(h_regi);
        log.info("selectHObj list 작동\t:{}", oDto);
        List<Hospi_Dto> aDto = service.selectHAni(h_regi);
        log.info("selectHAni list 작동\t:{}", aDto);
        List<Reserv_Dto> rDto = service.serchR_Date(h_regi);
        log.info("serchR_Date list 작동\t:{}", rDto);

        model.addAttribute("HObj", oDto);
        model.addAttribute("HAni", aDto);
        model.addAttribute("rDto", rDto);
        return "insertReserForm";
    }

    @RequestMapping(value = "/insertReser.do", method = RequestMethod.POST)
    public String insertReser(Reserv_Dto rDto, HttpSession session, String time, String r_date, String main_obj, String obj_detail_code, String r_content) {
        log.info("insertReser 작동\t:{}", rDto);
        System.out.println(time);
        System.out.println(r_date);
        r_date = r_date.substring(0, 4) + r_date.substring(6, 8) + r_date.substring(10, 12) + time;
        rDto.setR_date(r_date);
        System.out.println(rDto);
        User_Dto dto = (User_Dto) session.getAttribute("user");
        rDto.setU_id(dto.getU_id());
        System.out.println(dto);
        System.out.println(rDto);
        rDto.setR_content(r_content + "진료동물 : " + main_obj + "진료과 : " + obj_detail_code);
        System.out.println(rDto);
        boolean isc = service.insertReser(rDto);

        return isc ? "redirect:/reser.do" : "redirect/insertReserForm.do";
    }

    //병원 예약조회
    @RequestMapping(value = "/selectAllHReser.do", method = RequestMethod.GET)
    public String selectAllHReser(HttpSession session, Model model) {
        log.info("selectAllHReser 작동\t:{}", new Date());
        Hospi_Dto hdto = (Hospi_Dto) session.getAttribute("Hdto");
        User_Dto udto = (User_Dto) session.getAttribute("user");
//		Map<String, String> map = new HashMap<String, String>();
        log.info("hdto session\t:{}", hdto);
        log.info("udto session\t:{}", udto);

//		map.put("u_auth", udto.getU_auth());
        List<Reserv_Dto> Hlists = service.selectAllHReser(hdto.getH_regi());
        System.out.println(Hlists);
        List<Reserv_Dto> Ulists = service.selectAllUReser(udto.getU_id());
        System.out.println(Ulists);

        model.addAttribute("lists", Hlists);
        model.addAttribute("Ulists", Ulists);
        model.addAttribute("u_auth", udto);
        return "reser";
    }

    @RequestMapping(value = "/Rmodify.do", method = RequestMethod.GET)
    public String selectOneHReser(HttpSession session, Model model, String r_date, String r_status, String seq) {
    	System.out.println(seq);
        Map<String, String> map = new HashMap<String, String>();
        Hospi_Dto hdto = (Hospi_Dto) session.getAttribute("Hdto");
        User_Dto udto = (User_Dto) session.getAttribute("user");
        Reserv_Dto rdto = new Reserv_Dto();

        map.put("h_regi", hdto.getH_regi());
        map.put("r_status", r_status);
//		2019-12-18 18:00:00
        r_date = r_date.substring(0, 4) + r_date.substring(5, 7) + r_date.substring(8, 10) + r_date.substring(11, 13) + r_date.substring(14, 16) + r_date.substring(17, 19);
        map.put("r_date", r_date);
        map.put("u_id", udto.getU_id());
        map.put("seq", seq);
        boolean isc = service.delReser(map);
        return isc ? "redirect:/reserS.do" : "redirect:/reser.do";
    }

}
