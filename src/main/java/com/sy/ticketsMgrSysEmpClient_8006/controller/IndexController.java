package com.sy.ticketsMgrSysEmpClient_8006.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sy.ticketsMgrSysEmpClient_8006.feignClientService.EmpFeignService;
import com.yueqian.ticketsMgr_domain_9000.domain.empMgr.EmpVO;

@Controller
public class IndexController {
	
	
	@Resource
	private EmpFeignService empService;
//	@RequestMapping({"/","","/index"})
//	public String index(ModelMap mm) {
//		mm.addAttribute("emps", empFeignService.getEmps());
//		return "index";
//	}
	@RequestMapping({"","/","/loginPage"})
	public String loginPage() {
		return "login";
	}
	
	
	@RequestMapping("/isTelephoneExists")
	@ResponseBody
	public boolean isTelephoneExists(String telephone) {
		return empService.getTelephone(telephone);
	}
	@RequestMapping("/isIdCardNumExists")
	@ResponseBody
	public boolean isIdCardNumExists(String idCardNum) {
		return empService.getIdCardNum(idCardNum);
	}
	


}
