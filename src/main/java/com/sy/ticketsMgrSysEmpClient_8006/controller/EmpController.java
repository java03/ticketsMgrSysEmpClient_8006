package com.sy.ticketsMgrSysEmpClient_8006.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sy.ticketsMgrSysEmpClient_8006.feignClientService.EmpFeignService;
import com.yueqian.ticketsMgr_domain_9000.domain.empMgr.EmpVO;
import com.yueqian.ticketsMgr_domain_9000.domain.sysMgr.RolesVO;
import com.yueqian.ticketsMgr_domain_9000.util.GetEmpAccount;
import com.yueqian.ticketsMgr_domain_9000.util.PhoneNumUtil;





@Controller
@RequestMapping("/emp")
public class EmpController {
	@Resource
	private EmpFeignService empService;
	
	
	
	
	@RequestMapping("/login")
	public String login(ModelMap mm,EmpVO emp,HttpSession session) {
		EmpVO result = empService.login(emp);
		
		//记录登录的用户
		session.setAttribute("session",result);
		System.out.println("qqqqqqq"+result);
		
		if(result!=null) {
			//如果是管理员，跳转到主页面
			if(result.getRole().getRoleName().equals("管理员")) {
				return "redirect:/emp/getEmps";
			}else if(result.getRole().getRoleName().equals("售票员")) {
				return "error";
			}else if(result.getRole().getRoleName().equals("站务员")) {
				return "error";
			}else  if(result.getRole().getRoleName().equals("司机")) {
				return "error";
				
			}else {
				return "login";
			} 
		}else {
			System.out.println("false------------");
			mm.addAttribute("errMsg", "账号或者密码错误，请重新登录！");
			return "login";
		}
	}
	
//	@RequestMapping("/getEmpById/{empId}")
//	public String getEmpById(@PathVariable int empId,ModelMap mm) {
////		mm.addAttribute("emp",)
//		return "addemp";
//	}
	
	@RequestMapping("/getEmps")
	public String showEmps(ModelMap mm) {
		mm.addAttribute("emps",empService.getEmps());
		return "index";
	}
	/**
	 * 根据id修改信息modifyEmpWhoLoginPage
	 */
	@RequestMapping("/modifyEmpPage/{empId}")
	public String modifyEmpPage(@PathVariable int empId,ModelMap mm) {
		//所有角色信息
		List<RolesVO> roleList = empService.getRoles();
		mm.addAttribute("roleList",roleList);
		//查询指定编号的员工
		mm.addAttribute("modEmp",empService.getEmpById(empId));
		
		return "modifyEmp";
	}
	@RequestMapping("/modifyEmp")
	public String modifyEmp(EmpVO emp,ModelMap mm) {
		
		boolean flag = empService.modifyEmp(emp);
		
		if(flag) {
						
			return "forward:/emp/getEmps";
		}else {
			return "forward:/modifyEmp";			
		}
	}
	/**
	 * 根据登录的人修改个人信息
	 */
	@RequestMapping("/modifyEmpWhoLoginPage")
	public String modifyEmpWhoLoginPage(ModelMap mm,HttpSession session) {
		EmpVO emp = (EmpVO) session.getAttribute("session");
		System.out.println(emp);
		mm.addAttribute("modEmp", emp);
		//所有角色信息
		List<RolesVO> roleList = empService.getRoles();
		mm.addAttribute("roleList",roleList);
		
		return "modifyEmpWhoLogin";
	}
	@RequestMapping("/modifyEmpWhoLogin")
	public String modifyEmpWhoLogin(EmpVO emp,ModelMap mm) {
		
		boolean flag = empService.modifyEmp(emp);
		if(flag) {
						
			return "forward:/emp/getEmps";
		}else {
			return "forward:/modifyEmpWhoLogin";			
		}
	}
	/**
	 * 新增
	 */
	@RequestMapping("/addEmpPage")
	public String addEmpPage(ModelMap mm,EmpVO emp) {
		GetEmpAccount acc  = new GetEmpAccount();
		String account = acc.getAccountRandom();
		emp.setAccount(account);
		mm.addAttribute("empList",emp);
		mm.addAttribute("roleList", empService.getRoles());
		return "addemp";
	}

	/**
	 * 新增
	 */
	@RequestMapping("/addEmp")
	public String addEmp(ModelMap mm,EmpVO emp) {
		//验证电话
		String phoneNum = emp.getTelephone();
		PhoneNumUtil phone = new PhoneNumUtil();
		//电话符合要求
		if(phone.isPhoneNum(phoneNum)) {
			boolean flag = empService.addEmp(emp);
			
			if(flag) {
				return "redirect:http://192.168.0.21/tickets/empMgr/emp/getEmps";			
			}else {
				return "addemp";
			}
		}
		mm.addAttribute("errorMsg","请输入正确的手机号！");
		return "error";
	}


	/**
	 * 删除
	 */
	@RequestMapping("/removeEmpById/{empId}")
	public String removeEmpById(@PathVariable int empId) {
		boolean flag = empService.removeEmpById(empId);
		if(flag) {
//			List<EmpVO> list = empService.getEmps();
//			System.out.println(list);
			return "forward:/emp/getEmps";			
		}else {
			return "forward:/emp/getEmps";
		}
	}
	
	/**
	 * 修改密码
	 */
	@RequestMapping("/modifyPwdPage")
	public String modifyPwdPage( ModelMap mm,HttpSession session){
		EmpVO emp = (EmpVO) session.getAttribute("session");
		System.out.println(emp);
		mm.addAttribute("empList", emp);
		return "password";
	};
	@RequestMapping("/modifyPwd")
	public String modifyPwd( EmpVO emp,ModelMap mm) {
		boolean flag = empService.modifyPwd(emp);
		if(flag) {
			return "forward:/emp/getEmps";
		}
		return "password";
	}
	
	
	

}
