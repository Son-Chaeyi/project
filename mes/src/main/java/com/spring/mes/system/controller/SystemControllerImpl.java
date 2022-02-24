package com.spring.mes.system.controller;

import java.sql.Date;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.mes.system.service.SystemService;
import com.spring.mes.system.vo.CompanyVO;
import com.spring.mes.system.vo.CustomerVO;
import com.spring.mes.system.vo.DeptVO;
import com.spring.mes.system.vo.ItemVO;

@Controller("systemController")
public class SystemControllerImpl implements SystemController {
	private static final Logger logger = LoggerFactory.getLogger(SystemControllerImpl.class);
	@Autowired
	private SystemService systemService;
	@Autowired
	private CompanyVO companyVO;
	@Autowired
	private DeptVO deptVO;
	
	@Override
	@RequestMapping(value="/system/companyInfo.do", method = RequestMethod.GET)
	public ModelAndView companyInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		System.out.println("viewName: " +viewName);
		companyVO = systemService.companyInfo(companyVO);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("company", companyVO);
		return mav;
	}

	@Override
	@RequestMapping(value="/system/insertCompany.do", method = RequestMethod.GET)
	public ModelAndView insertCompany(@ModelAttribute("company") CompanyVO company,
//						@RequestParam(value="closeDate", required=false) Date closeDate,
						HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		int result = 0;
		result = systemService.insertCompany(company);
		ModelAndView mav = new ModelAndView("redirect:/system/companyInfo.do");
		return mav;
	}

	@Override
	@RequestMapping(value="/system/departmentInfo.do", method = RequestMethod.GET)
	public ModelAndView departmentInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		String viewName = (String)request.getAttribute("viewName");
		List deptList = systemService.departmentInfo();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("deptList", deptList);
		return mav;
	}

	@Override
	@RequestMapping(value="/system/employeeInfo.do", method = RequestMethod.GET)
	public ModelAndView employeeInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("html;text/charset=utf-8");
		String viewName = (String)request.getAttribute("viewName");
		List empList = systemService.employeeInfo();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("empList",empList);
		return mav;
	}

	@Override
	@RequestMapping(value="/system/customerInfo.do", method=RequestMethod.GET)
	public ModelAndView customerInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("html;text/charset=utf-8");
		String viewName = (String)request.getAttribute("viewName");
		List customerList = systemService.customerInfo();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("customerList", customerList);
		return mav;
	}

	@Override
	@RequestMapping(value="/system/itemInfo.do", method=RequestMethod.GET)
	public ModelAndView itemInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("html;text/charset=utf-8");
		String viewName = (String) request.getAttribute("viewName");
		List itemList = systemService.itemInfo();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("itemList", itemList);
		return mav;
	}

	@Override
	@RequestMapping(value="/system/storageInfo.do", method=RequestMethod.GET)
	public ModelAndView storageInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("html;text/charset=utf-8");
		String viewName = (String) request.getAttribute("viewName");
		List storageList = systemService.storageInfo();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("storageList", storageList);
		return mav;
	}

	@Override
	@RequestMapping(value="/system/processInfo.do", method=RequestMethod.GET)
	public ModelAndView processInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("html;text/charset=utf-8");
		String viewName = (String) request.getAttribute("viewName");
		List processList = systemService.processInfo();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("processList", processList);
		return mav;
	}

	@Override
	@RequestMapping(value="/system/qualityTestCodeInfo.do", method=RequestMethod.GET)
	public ModelAndView qualityTestInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("html;text/charset=utf-8");
		String viewName = (String) request.getAttribute("viewName");
		List qualityTestList = systemService.qualityTestInfo();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("qualityTestList", qualityTestList);
		return mav;
	}

	@Override
	@RequestMapping(value="/system/insertDepartment.do", method=RequestMethod.POST)
	public ModelAndView insertDept(@ModelAttribute("dept") DeptVO deptVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("html;text/charset=utf-8");
		int result = 0;
		result = systemService.insertDept(deptVO);
		ModelAndView mav = new ModelAndView("redirect:/system/departmentInfo.do");
		return mav;
	}

	@Override
	@RequestMapping(value="/system/insertItem.do", method=RequestMethod.GET)
	public ModelAndView insertItem(@ModelAttribute("item") ItemVO itemVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		int result = 0;
		result = systemService.insertItem(itemVO);
		ModelAndView mav = new ModelAndView("redirect:/system/itemInfo.do");
		return mav;
	}
}