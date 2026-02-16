<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>StringのUserTools、Struts</title>
</head>
<body>
	<h1>Hello Struts</h1>
	<p>
	言語はどこまでいっても既存の枠組みに収まっており、意図を完全な形で表現することは不可能である。または思考言語を既存の言語に設定している以上、枠組みを超えて意図を生み出すこと自体が不可能であろうか。
	</p>
	<s:form action="helloStruts">
		<s:textfield name="name" label="名前" />
		<s:submit value="送信" />
	</s:form>
</body>
</html>