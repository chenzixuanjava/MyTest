<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/9 0009
  Time: 下午 4:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<html>
<head>
    <title>Spittr</title>
    <style type="text/css">
        span.error {
            color: red;
        }

        div.errors {
            background-color: #ffcccc;
            border: 2px solid red;
        }

        label.error {
            color: red;
        }

        input.error {
            background-color: #ffcccc;
        }
    </style>
    <script type="application/javascript" src="/source/jquery-3.3.1.js"></script>
</head>
<body>
<h1>Register</h1>
<%--<form id="regForm" action="/spitter/registerSub" method="post" enctype="multipart/form-data">
    Username:<input type="text" name="username"/><br/>
    Password:<input type="password" name="password"/><br/>
    照片: <input type="file" name="file"/>
    <input type="submit" value="提交"/>
</form>--%>
<form id="regForm" action="/spitter/registerSub" method="post">
    Username:<input type="text" name="username"/><br/>
    Password:<input type="password" name="password"/><br/>
    <input id="sub" type="submit" value="提交"/>
</form>

<script type="application/javascript">
    $("#regForm").ready(function () {
        $.ajax({
            type: "get",
            url: "/spitter/registerSub",
            data: "&name=che&n&age=24",
            processData:true
        })
    })
</script>

<%--用JSP表单标签库--%>
<%--commandName中的是模型中的key，所以模型中必须有这个key，表单的其它元素都引用这个key对应对象的属性--%>
<%--表单元素的path属性里的属性值填充原生表单的value值--%>
<%--<sf:form commandName="spitter" method="post" action="/spitter/register" enctype="multipart/form-data">
    <sf:errors path="*" element="div" cssClass="errors"/>
    <sf:label path="username" cssErrorClass="error">用户名不符合规范</sf:label>
    用户名：<sf:input path="username" cssErrorClass="error"/><br/>
    密码： <sf:password path="password"/><br/>
    &lt;%&ndash;<sf:errors path="password" cssClass="error"/>&ndash;%&gt;
    邮箱： <sf:input path="email" type="email"/><br/>
    照片: <input type="file" value="file"/>
    <input type="submit" value="提交"/>
</sf:form>--%>
</body>
</html>
