<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%  String  sourceUrl=application.getInitParameter("sourceURL");
  request.setAttribute("sourceUrl", sourceUrl);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head lang="en">

    <title>修改密码</title>
    <link rel="stylesheet" href="css/global.css"/>
    <link rel="stylesheet" href="css/main.css"/>
    <jsp:include page="page.jsp" />
    
    
    
    
</head>
<body style="background:#f4f8fb;overflow: hidden">

<script type="text/javascript">
   function check(){
	 alert("zxcvbndfghjkertyui" );
	//jquery 验证框架 需要监听 form 提交事件 走验证
	$("#form-register").submit();
}

//页面加载初始化时候 ----对表单输入框 进行增加验证 --并设定验证通过够执行流程
$(document).ready(function(){
	 alert("ssssssssssssssssssss" );
	// 在键盘按下并释放及提交后验证提交表单
	  $("#form-register").validate({
		 
		// 自定义规则,key:value的形式,key是要验证的元素,value可以是字符串或对象验证 
	    rules: { 	    uname: {   required: true,  minlength: 2,  maxlength:20 },
			  	    answer: {   required:true,  email:true} 
	    		  },
	    messages: {   uname: {   required: "请输入用户名",   minlength: "用户名不能小于2个字符", maxlength: "用户名称不能多于20个字符"},
	                  answer: {  required: "请输入邮箱",  email:"请正确书写邮箱格式！" } 
	              }, 
	              errorPlacement: function (error, element) {//第一个参数是错误的提示文字，第二个参数是当前输入框
				         error.appendTo(element.siblings("span"));//用的是jQuery，这里设置的是，错误提示文本显示在当前文本框的兄弟span中
				        },
	           
	  submitHandler: function(form) 
	  // submitHandler翻译为提交处理程序
	   {    
		 
		  //验证通过后 走此出业务流程
		 $.post("${pageContext.request.contextPath}/manager/forgetpwd",{"username":$("#uname").val(),"answer":$("#answer").val()},
			   function(data){
			   
			   alert("nnnnnnnnnnnnnn" );
			   
			  if(data==4){
			  window.alert("操作成功,已经发送找回密码到您邮箱。" );
			  window.location.href="${pageContext.request.contextPath}/index/login.jsp";
			  }  else if(data==5){
    	//	   $("#tishi").html("对不起  密码输入有误，请核实再试！");
    		   window.alert("邮箱不是有效邮箱！" );
    		//   window.location.href="${pageContext.request.contextPath}/index.jsp";
    		   }else if(data==0){
			  window.alert("用户不存在！" );
			   }  else if(data==1){
    	//	   $("#tishi").html("对不起  密码输入有误，请核实再试！");
    		   window.alert("邮箱不存在！" );
    		//   window.location.href="${pageContext.request.contextPath}/index.jsp";
    		   }else if(data==2){
			  window.alert("用户名与邮箱不符！" );
			  }  else if(data==3){
    	//	   $("#tishi").html("对不起  密码输入有误，请核实再试！");
    		   window.alert("用户名与邮箱不符！！！" );
    		//   window.location.href="${pageContext.request.contextPath}/index.jsp";
    		   }
    	   
	        }); 
	   } 
	});
});
</script>





<div class="head">
    <div id="headMain" class="clearfix">
        <a href="#" class="lf logo-title">
            <img src="images/logo.png" alt="LOGO" />
            <h3 class="rt">忘记密码</h3>
        </a>
    </div>
</div>
<div class="g-container zg-container">
    <div class="">
    <div class="zm-rgtitle content-box1">
        <span>您现在的位置：<a href="firstPage.jsp">网站首页</a>&nbsp;>&nbsp;忘记密码</span>
        <h3>密码找回</h3>
    </div>
    <div class="zm-container">
        <form id="form-register">
            <div class="form-group1">
                <label for="uname"><i></i>用户名：</label>
                <input  type="text" placeholder="请输入用户名"  name="uname" id="uname"/>
                 <span style="height: 30px; width: 140px; "></span>
           
            </div>
            
            <div class="form-group1">
                <label for="answer"><i></i>email:</label>
                <input    type="text" placeholder="请输入您的邮箱" name="answer" id="answer"/>
                <span style="height: 30px; width: 140px; "></span>
           
            </div>
            <div class="form-group1">
            
                <a href="javascript:check();" id="forgetPwd-btn"style="height: 35px;width: 80px;display:block;  "/> 提交</a>
            </div>
            
        </form>
    </div>
    </div>
</div>
</body>
</html>