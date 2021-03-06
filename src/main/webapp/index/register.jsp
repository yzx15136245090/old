<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%  String  sourceUrl=application.getInitParameter("sourceURL");
  request.setAttribute("sourceUrl", sourceUrl);
%>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>注册页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/index/css/global.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/index/css/main.css"/>
    
    <jsp:include page="page.jsp" />
 
    <script src="${pageContext.request.contextPath}/index/js/jquery.ajaxfileupload.js"></script>
    <script type="text/javascript">
    
		function checkRegisterUser(){
		
			//jquery 验证框架 需要监听 form 提交事件 走验证
			$("#form-register").submit();
			
			
		}
		
		//页面加载初始化时候 ----对表单输入框 进行增加验证 --并设定验证通过够执行流程
		$(document).ready(function(){
			// 在键盘按下并释放及提交后验证提交表单
			  $("#form-register").validate({
				// 验证规则 
			    rules: {   uname: {   required: true,  minlength: 5,  maxlength:30 },
					  	   upwd: {   required:true,  minlength: 6,    maxlength:12  } ,
					  	   corfirmupwd:{required:true,equalTo: "#upwd"},
					  	   email: {required:true,email:true},
					  	   ch:{required:true,checked:true },
					  	   nicheng:{required: true,  minlength: 2,  maxlength:30}
			    		  },
			    messages: {   uname: {   required: "请输入用户名",   minlength: "2-30位字母、数字或“_”组合", maxlength: "6-30位字母、数字或“_”组合"},
			                 upwd: {  required: "请输入密码",  minlength: "密码长度不能小于 6 个字符",   maxlength: "密码长度不能多于12个字符" }, 
			                 nicheng: {  required: "请输入昵称",  minlength: "2-30位字母、数字或“_”组合",   maxlength: "2-30位字母、数字或“_”组合" }, 
			                 
			                 corfirmupwd:{required:"内容不能为空",equalTo:"密码不一致"},
			                 email: {required:"请输入邮箱好",email:"请正确填写邮箱" },
			                 ch:{required:"请输入邮箱好",checked:function(){}}
			              },
			 /*   */
			              /*错误提示位置*/
			           errorPlacement: function (error, element) {//第一个参数是错误的提示文字，第二个参数是当前输入框
				         error.appendTo(element.siblings("span"));//用的是jQuery，这里设置的是，错误提示文本显示在当前文本框的兄弟span中
				        },
				        
				        
			  submitHandler: function(form) 
			   {   
			    
			     /* $(function(){
		         var confirmBox = document.getElementById("ch");//ch为checkbox的ID
			      if(confirmBox.checked){
			      form.submit();
					 }
					 else{
					  alert("你必须在同意协议，后才能注册");
					  return false;
			 }
		}), */  
				 
				  //验证通过后 走此出业务流程
				 $.post("${pageContext.request.contextPath}/manager/insertUserSystem",{"uname":$("#uname").val(),"nicheng":$("#nicheng").val(),"upwd":$("#upwd").val(), "email":$("#email").val()},
				function(data){
					    
					  if(data==1){
					  window.alert("恭喜你注册成功");
					  window.location.href="${pageContext.request.contextPath}/index/login.jsp";
					  } 
					  else if(data==0){
					   window.alert("注册失败，请重新注册!");
					   }
					  
					  
					  else if(data == 2){
					  window.alert("注册失败,此邮箱已经存在请从新输入！");
					  }
					  
					 
			        }); 
			   } 
			});
		});
	
    
		</script>


    
    
    
    
    
</head>
<body style="background:#f4f8fb;">
<div class="head">
    <div id="headMain" class="clearfix">
        <a href="#" class="lf logo-title">
            <img src="images/logo.png" alt="LOGO" />
            <h3  class="rt">注册用户</h3>
        </a>
    </div>
</div>
<div class="g-container zg-container">
    <div class="zm-rgtitle">
        <span>您现在的位置：<a href="firstPage.jsp">网站首页</a>&nbsp; > &nbsp;注册</span>
        <h3>账户注册</h3>
    </div>
    <div class="content-box1">
        <div class="zm-container">
         <form id="form-register">
         
             <div class="form-group1">
                 <label for="uname"><i></i>用户名：</label>
                 <input type="text" placeholder="用户名设置成功后不可修改" autofocus name="uname" id="uname"/>
                 <span></span>
             </div>
             <div class="form-group1">
                 <label for="nicheng"><i></i>昵称：</label>
                 <input type="text" placeholder="昵称名设置成功后不可修改" autofocus name="nicheng" id="nicheng"/>
                 <span></span>
             </div>
             <div class="form-group1">
                 <label for="upwd"><i></i>登录密码：</label>
                 <input type="password" placeholder="请输入密码" name="upwd" id="upwd"/>
                  <span class=""></span>
                
             </div>
             <div class="form-group1">
                 <label for="corfirmupwd"><i></i>确认密码：</label>
                 <input type="password" placeholder="再次输入登录密码" name="corfirmupwd" id="corfirmupwd"/>
                  <span><i class="msg-deafult"></i> <i></i> <i></i></span>
                
             </div>
             <div class="form-group1" id="form-group1">
                 <label for="email"><i></i>email号：</label>
                 <input type="text"  name="email" id="email"/>
                 <span class=""></span>
             </div>
           
             <div class="form-group1">
                 <input type="checkbox" id="ch"  />我已阅读并同意 <a href="">&lt;&lt;偶的驿站网站服务条款&gt;&gt;</a>
             </div>
            
                 <a  id="register-btn" class="register-btn" style="height: 35px;width: 80px;display:block;position:absolute;left: 370px;  "href="javascript:checkRegisterUser();"> 注册</a>
           
         </form>
     </div>
    </div>
</div>


</body>
</html>