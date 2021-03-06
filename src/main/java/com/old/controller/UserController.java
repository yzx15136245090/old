package com.old.controller;


import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.old.model.User;
import com.old.service.UserService;
import com.old.util.SendmailUtil;


@Controller
@RequestMapping(value = "/manager")
public class UserController {
	@Autowired
	UserService service;

	@RequestMapping(value = "/userLogin", method = { RequestMethod.POST })
	@ResponseBody
	public String loginSystem(String username, String password,
			HttpSession session) {

		
		User user = service.queryUserByUserid(username);
		

		if (user != null) {
			if (user.getPassword().equals(password)) {
				//保存登陆者信息
				session.setAttribute("user", user);
				User users=new User();
				users.setUsername(username);
				return "1";
			} else {
				return "2";
			}
		} else {
			return "0";
		}

	}

	@RequestMapping(value = "/register")
	public String registerSystem() {
		return "index/register.jsp";
	}
	
	@ResponseBody
	@RequestMapping(value = "/islogin")
	
	public String islogin(HttpServletRequest request,HttpSession session) {
		User user=new User();
		user = (User) session.getAttribute("user");
		if(user!=null){
			System.out.println(0);
			return "0";
		}
		else{
			System.out.println(1);
			return "1";
		}
	}

	@RequestMapping(value = "/toHomePage")
	public String toHomePage() {
		return "";
	}

	@SuppressWarnings("null")
	@RequestMapping(value = "/insertUserSystem", method = { RequestMethod.POST })
	@ResponseBody
	public String insertUserSystem(String uname,String nicheng, String upwd, String email,
			Model model) {
		User user = service.queryUserByUserid(uname);
		User user1 = service.queryUserByUseremail(email);

		if (user1==null) {
			user = new User();
			user.setUserid(uname);
			user.setUsername(nicheng);
			user.setPassword(upwd);
			user.setEmail(email);
			
			
			int a = service.insertUser(user);
			System.out.println("99999999999999999999999");
			System.out.println(a);
			if (a == 1) {
				System.out.println(uname + "9999999999999999999999" + upwd
						+ "      " + email);
				return "1";
			} else {
				return "0";
			}
		} 
		
		else  {
			return "2";
		}

	}

	@RequestMapping(value = "/updateUserSystem")
	public String updateUserSystem(User user, HttpServletRequest request,
			Model model,HttpSession session) {
		user = (User) session.getAttribute("user");
		// user = (User) request.getSession().getAttribute("user");
		System.out.println(user);
		model.addAttribute("user", user);

		return "detail/html/userCenter.jsp";
	}

	@RequestMapping(value = "/updateToUserSystem")
	public String updateToUserSystem(String currPwd,String newPwd,HttpServletRequest request,
			Model model) {
		
		User user = service.queryUserByUserid(currPwd);
		System.out.println(currPwd);
		System.out.println(newPwd);
		if(user!=null){
			User user1=new User();
			user1.setUsername(currPwd);
			
			user1.setPassword(newPwd);
			//从session中获取当前登陆的用户
		//User loginedUser = SessionState.getLoginedUser(request);
		if (service.updateUser(user)) {
			return  "1";
			
		}
		else{
		return  "2";
	   }
	}else{
		return  "2";
	 }	
	}
		
	
	
	/*public String updateToUserSystem(User user,HttpServletRequest request,
			Model model) {
		//从session中获取当前登陆的用户
		//User user = (User)request.getAttribute("current_user");
		//User loginedUser = SessionState.getLoginedUser(request);
		if (service.updateUser(user)) {
			return "index/login.jsp";
		}
		return "detail/html/userCenter.jsp";
	}*/

	
	
	
/*邮箱找回密码*/
	@RequestMapping(value = "/forgetpwd")
	   @ResponseBody
	   public String forgetPass(HttpServletRequest request,String username,String answer,Model model){
	       
	       User user=service.queryUserByUserid(username);
	       User user1=service.queryUserByUseremail(answer);
	       if(user==null){              //用户名不存在
	           
	         return "0";
	           
	       }
	       if(user1 == null){              //邮箱不存在
	           return "1";
	       }else if(user!=null && user.getEmail().equals(answer )){
	    	   return "2";
	       }else if(user1!=null && user1.getUserid().equals(username )){
	    	   return "3";
	       }else{
	       try{
	           String secretKey= UUID.randomUUID().toString();  //密钥
	           String emailTitle = "密码找回";
	          
	           String localstr=request.getLocalAddr();
	           System.out.println(localstr);
	         //  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	          
	           SendmailUtil.class.newInstance().doSendHtmlEmail(emailTitle,user.getPassword(),answer);//调用工具类里面的发送发放
	           return "4";
	       }catch (Exception e){
	           e.printStackTrace();
	           return "5";
	       }
	          
	       }
	      
	   }
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
