<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>登録完了</title>
  <style>
    body {
      font-family: sans-serif;
      background-color: #f0f0f0;
      padding: 50px;
      text-align: center;
    }

    .box {
      background: #fff;
      display: inline-block;
      padding: 30px 50px;
      border-radius: 10px;
      box-shadow: 0 2px 10px rgba(0,0,0,0.1);
    }

    h1 {
      color: #4CAF50;
      margin-bottom: 20px;
    }

    a, .btn-back {
      display: inline-block;
      margin-top: 20px;
      text-decoration: none;
      color: #2196F3;
      font-weight: bold;
    }

    a:hover, .btn-back:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>
  <div class="box">
    <h1>登録が完了しました！</h1>
    <s:a action="shain_touroku" cssClass="btn-back">戻る</s:a>
  </div>
</body>
</html>
