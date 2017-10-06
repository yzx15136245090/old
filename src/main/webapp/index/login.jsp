
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="zh_CN">
<head>
      
   
    <link rel="stylesheet" href="${pageContext.request.contextPath}/index/css/global.css "/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/index/css/main.css"/>
  
    <title></title>
<jsp:include page="page.jsp" />
  

 
<!--  $(function(){
		  alert("ass");
	  })-->
   
	
    
</head>
<body style="overflow: hidden;">
<div class="model-tips">
    <div class="tips">
    <h3>提示</h3>
        <p>用户名不能为空!</p>
        <span class="sure-btn">确定</span>
    </div>
</div>
<div class="g-container dg-container"  style ="top:-150px;">
    <form class="dm-container" id="dm-container"  >
        <div class="logo">
            <img src="images/logo.png" alt=""/>
        </div>
        <h3>高校学生旧物交易网站</h3>
        <div class="login-form">
            <div class="form-group m-bottom-md">
            
                <input type="text" id="uname" name="uname"  placeholder="用户名："  />
                   
            </div>
          
            <div class="form-group m-bottom-md" >
                <input type="password" id="password"  name="upwd" placeholder="密码："/>
                 
            </div>
        </div>
        <div class="dm-newresiter">
            <a href="register.jsp"  class="register">新用户注册</a>&nbsp;&nbsp;
            <a href="forgetpassward.jsp">忘记密码？</a>
        </div>
        
        
        <a  class="loginbtn" id="loginbtn"  href="javascript:checkUser();" >登录</a>
       
        <hr/>
        <div class="d-bottom">
            <a href="#" class="lf">客服热线：0371-01020300</a>
            <a href="#" class="rt">公司官网：www.oudeyizhan.com</a>
        </div>
    </form>
     
</div>
      <a href="javascript:void(0);" id="scroll-to-top" class="hidden-print"><i
		class="icon-chevron-up"></i></a>
    
   

  
</body>
 <script src="${pageContext.request.contextPath}/index/js/jquery.ajaxfileupload.js"></script>
   <script src="${pageContext.request.contextPath}/index/js/jquery-1.11.3.js"></script>
    <script src="${pageContext.request.contextPath}/index/js/jquery.validate.min.js">  </script>

</html>
 <script type="text/javascript">
   function checkUser(){
	 
	//jquery 验证框架 需要监听 form 提交事件 走验证
	$("#dm-container").submit();
}
//页面加载初始化时候 ----对表单输入框 进行增加验证 --并设定验证通过够执行流程
$(function(){
	
	// 在键盘按下并释放及提交后验证提交表单
	  $("#dm-container").validate({
		 
		// 自定义规则,key:value的形式,key是要验证的元素,value可以是字符串或对象验证 
	    rules: { 	    uname: {   required: true,  minlength: 2,  maxlength:20 },
			  	    password: {   required:true,  minlength: 6,    maxlength:15  } 
	    		  },
	    messages: {   uname: {   required: "请输入用户名",   minlength: "用户名不能小于5个字符", maxlength: "用户名称不能多于20个字符"},
	                  password: {  required: "请输入密码",  minlength: "密码长度不能小于 5 个字符",   maxlength: "密码长度不能多于20个字符" } 
	              }, 
	           
	  submitHandler: function(form) 
	  // submitHandler翻译为提交处理程序
	   {    
		 
		  //验证通过后 走此出业务流程
		 $.post("${pageContext.request.contextPath}/manager/userLogin",{"username":$("#uname").val(),"password":$("#password").val()},
			   function(data){
			  if(data==1){
			 
			  window.location.href="${pageContext.request.contextPath}/index/userCenter.jsp";
			  }  else if(data==2){
    	//	   $("#tishi").html("对不起  密码输入有误，请核实再试！");
    		   window.alert("对不起  密码输入有误，请核实再试！" );
    		//   window.location.href="${pageContext.request.contextPath}/index.jsp";
    		   }
    	   else {
    	      window.alert("警告 ，此用户不服务范围!");
    	   }
	        }); 
	   } 
	});
});
</script>