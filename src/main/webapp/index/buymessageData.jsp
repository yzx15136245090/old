
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<c:forEach var="buymessage" items="${buymessageList}">
   			 <li>
            <b id="buy_name">${buymessage.buygoodsname }</b>
            <span>求购价格：￥${buymessage.wantprice }</span>
            <span class="belong-somebody">求购人：${buymessage.username }</span>
            <textarea class="buy_des" disabled="disabled" >${buymessage.buygoodsdescrip} </textarea>
            <a href="chat.html" class="connect-buy"> 联系求购人</a>
        </li>
   
   </c:forEach>
      <input type="hidden" id="totalPages" value="${totalPages }"/> 
        <input  type="hidden" id="startPageTemp" value="1">