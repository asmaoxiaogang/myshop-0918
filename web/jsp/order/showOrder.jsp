<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/9/16
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>orderMsgShow</title>
    <style>
        .four{
            background-color: #ECF1F6;
            border: 2px solid #FFF;
            height: 45px;
            line-height: 45px;
            color: #212121;
            font-weight: normal;
        }

        td {
            background-color: #F6F6F7;
            border: 2px solid #FFF;
            height: 45px;
            line-height: 45px;
            color: #555555;
            text-align: center;
        }

        #buttonBuy-a{
            border: 1px solid black;
            padding: 2px;
            background-color: #ffeded;
            border-radius: 15px
        }

    </style>
</head>
<body>
<h1><span style="color: darkred">${sessionScope.username}</span>Welcome Come MyShop</h1>
    <table width="900px" border="1px solid black" align="center" cellspacing="0" cellpadding="0">
        <tr>
            <td class="four">订单编号</td>
            <td class="four">用户名</td>
            <td class="four">金额</td>
            <td class="four">状态</td>
            <td class="four">创建时间</td>
            <td class="four">收获地址</td>
            <td class="four">操作</td>

        </tr>

        <c:if test="${not empty orderList}">
            <c:forEach items="${orderList}" var="order">
                <form action="order.action?method=pay" method="post">
                    <tr>
                        <td>${order.id}</td>

                        <input type="hidden" name="orderId" value="${order.id}">
                        <td>${sessionScope.username}</td>
                        <td>${order.money}</td>
                        <input type="hidden" name="money" value="${order.money}">
                        <input type="hidden" name="testName" value="${order.uid}">
                        <input type="hidden" name="details" value="myShopBuy">
                        <td>${order.status}</td>
                        <td>${order.time}</td>
                        <td>${order.aid}</td>
                        <td>
                            <a id="buttonBuy-a" href="order.action?method=deleteOrder&orderId=${order.id}" style="width:46px; height:24px;font-size: 15px;text-decoration: none">删-除</a>
                                <%--点击确认按钮后就跳转到首页--%>
                            <input id="buttonBuy-a" type="submit" value="去支付">
                        </td>
                    </tr>
                </form>

            </c:forEach>
        </c:if>

    </table>

<form action="address.action?method=addAddress" method="get">
    <table width="900px" style="margin-top: 100px" border="1px solid black" align="center" cellspacing="0" cellpadding="0">
        <c:if test="${not empty addressList}">
            <tr>
<%--                <td>id</td>--%>
                <td>详细地址</td>
                <td>收货人姓名</td>
                <td>收货人号码</td>
                <td>订单所有者</td>
            </tr>
            <c:forEach items="${addressList}" var="address">
                <tr>
                    <td>${address.detail}</td>
                    <td>${address.name}</td>
                    <td>${address.phone}</td>
                    <td>${sessionScope.username}</td>
                </tr>
            </c:forEach>
        </c:if>
        <%--            --%>
        <c:if test="${empty addressList}">
            <tr>
                <td class="four">地址信息:</td>
                <td class="show" colspan="6">
					<span>
					<select name="province">
						<option>省份</option>
						<option>河南</option>
						<option>江苏</option>
					</select>
				</span>
                    <span>
					<select name="city" >
						<option>市</option>
						<option>安阳市</option>
						<option>苏州市</option>
					</select>
				</span>
                    <span>
					<select name="area" >
						<option>区/县</option>
						<option>文峰区</option>
						<option>昆山市</option>
					</select>
				</span>
                    <span>
					<select name="street" >
						<option>街道/镇</option>
						<option>南关街道</option>
						<option>开发区</option>
					</select>
				</span>

                </td>
            </tr>
            <tr>
                <td class="four">详细信息:</td>
                <td class="show" colspan="6"><span>
					<input type="text" name="details"  style="color: #999" value="请输入详细地址"
                           onfocus="if( this.value=='请输入详细地址'){this.value='';this.style.color='#424242'}"
                           onblur="if(this.value=='') {this.value='请输入详细地址';this.style.color='#999'}">
				</span></td>
            </tr>
            <tr>
				<span>
					<td class="four">收货人姓名:</td>
					<td class="show" colspan="6"><input type="text" name="name"  style="color: #999" value="请输入收货人姓名"
                                                        onfocus="if( this.value=='请输入收货人姓名'){this.value='';this.style.color='#424242'}"
                                                        onblur="if(this.value=='') {this.value='请输入收货人姓名';this.style.color='#999'}"></td>
				</span>
            </tr>

            <tr>
				<span>
					<td class="four">手机号:</td>
					<td class="show" colspan="6"><input type="text" name="phone"  style="color: #999" value="请输入手机号"
                                                        onfocus="if( this.value=='请输入手机号'){this.value='';this.style.color='#424242'}"
                                                        onblur="if(this.value=='') {this.value='请输入手机号';this.style.color='#999'}"></td>

				</span>

            </tr>
            <tr>
                <td class="four">操作:</td>
                <input type="hidden" name="method" value="addAddress">
                <td class="show" colspan="6"><input type="submit" value="确认"> </td>
            </tr>
        </c:if>
        <%--            --%>
    </table>
</form>

</body>
</html>
