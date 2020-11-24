package com.sy.ticketsMgrSysEmpClient_8006.feignClientService;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sy.ticketsMgrSysEmpClient_8006.feignClientService.impl.EmpFeignServiceImpl;
import com.yueqian.ticketsMgr_domain_9000.domain.empMgr.EmpVO;
import com.yueqian.ticketsMgr_domain_9000.domain.sysMgr.RolesVO;

@FeignClient(name="emp-service",path= "empProvider/emp",fallback=EmpFeignServiceImpl.class)
public interface EmpFeignService {
	
	@RequestMapping("/getEmpById/{empId}")
	public EmpVO getEmpById(@PathVariable int empId);
	
	@RequestMapping("/getEmps")
	public List<EmpVO> getEmps();
	/**
	 * 获取指定的角色
	 */
	@RequestMapping("/getEmpsByDuty/{roleId}")
	public List<EmpVO> getEmpsByDuty(@PathVariable int roleId);
	/**
	 * 登录
	 */
	@RequestMapping("/login")
	public EmpVO login(EmpVO emp);
	/**
	 * 查询账号和密码
	 */
	@RequestMapping("/findEmpByAccountAndPwd")
	public boolean findEmpByAccountAndPwd(EmpVO emp);
	/**
	 * 获取所有的角色信息
	 */
	@RequestMapping("/getRoles")
	public List<RolesVO> getRoles() ;
	
	/**
	 * 新增 
	 */
	@RequestMapping("/addEmp")
	public boolean addEmp(EmpVO emp) ;
	/**
	 * 删除
	 */
	@RequestMapping("/removeEmpById/{empId}")
	public boolean removeEmpById(@PathVariable int empId) ;
	/**
	 * 删除
	 */
	
	/**
	 * 修改
	 */
	@RequestMapping("/modifyEmp")
	public boolean modifyEmp(EmpVO emp) ;
	/**
	 * 修改密码
	 */
	@RequestMapping("/modifyPwd")
	public boolean modifyPwd( EmpVO emp); 

	/**
	 * 检测电话是否存在
	 */
	@RequestMapping("/getTelephone/{telephone}")
	public boolean getTelephone(@PathVariable String telephone);
	/**
	 * 检测身份证号是否重复
	 */
	@RequestMapping("/getIdCardNum/{idCardNum}")
	public boolean getIdCardNum(@PathVariable String idCardNum) ;


}
