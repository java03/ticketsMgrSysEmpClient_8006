package com.sy.ticketsMgrSysEmpClient_8006.feignClientService.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sy.ticketsMgrSysEmpClient_8006.feignClientService.EmpFeignService;
import com.yueqian.ticketsMgr_domain_9000.domain.empMgr.EmpVO;
import com.yueqian.ticketsMgr_domain_9000.domain.sysMgr.RolesVO;

@Component
public class EmpFeignServiceImpl implements EmpFeignService {

	@Override
	@RequestMapping("/getEmpById/{empId}")
	public EmpVO getEmpById(@PathVariable int empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping("/getEmps")
	public List<EmpVO> getEmps() {
		return null;
	}

	@Override
	@RequestMapping("/login")
	public EmpVO login( EmpVO emp){
		return null;
	}

	@Override
	@RequestMapping("/addEmp")
	public boolean addEmp(EmpVO emp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@RequestMapping("/removeEmpById/{empId}")
	public boolean removeEmpById(int empId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@RequestMapping("/modifyEmp")
	public boolean modifyEmp(EmpVO emp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@RequestMapping("/getEmpsByDuty/{roleId}")
	public List<EmpVO> getEmpsByDuty(int roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping("/getRoles")
	public List<RolesVO> getRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modifyPwd(EmpVO emp) {
		return false;
	}
	
	@Override
	@RequestMapping("/findEmpByAccountAndPwd")
	public boolean findEmpByAccountAndPwd(EmpVO emp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getTelephone(String telephone) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getIdCardNum(String idCardNum) {
		// TODO Auto-generated method stub
		return false;
	}

}
