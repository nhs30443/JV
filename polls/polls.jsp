<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>アンケートフォーム</title>
  <style>
    body {
      font-family: "Arial", "メイリオ", sans-serif;
      background-color: #f9f9f9;
      padding: 20px;
    }

    h1 {
      text-align: center;
      color: #333;
    }

    form {
      background-color: #fff;
      max-width: 500px;
      margin: 0 auto;
      padding: 20px;
      border-radius: 10px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    label {
      display: inline-block;
      margin-bottom: 5px;
      font-weight: bold;
    }

    input[type="text"], select {
      width: 100%;
      padding: 8px;
      margin-bottom: 15px;
      border: 1px solid #ccc;
      border-radius: 5px;
    }

    input[type="radio"],
    input[type="checkbox"] {
      margin-right: 5px;
    }

    p {
      margin: 15px 0 5px;
      font-weight: bold;
    }

    input[type="submit"] {
      background-color: #4CAF50;
      color: white;
      padding: 10px 20px;
      border: none;
      border-radius: 5px;
      cursor: pointer;
    }

    input[type="submit"]:hover {
      background-color: #45a049;
    }
  </style>
</head>
<body>
  <h1>アンケートフォーム</h1>
  <form action="/polls/polls" method="post">
    <div style="color:red;">
      <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %>
    </div>

    <!-- テキストボックス -->
    <label for="name">名前:</label>
    <input type="text" id="name" name="name" value="<%= request.getParameter("name") != null ? request.getParameter("name") : "" %>"><br><br>

    <!-- ラジオボタン -->
    <p>性別:</p>
    <input type="radio" id="male" name="gender" value="male"
      <%= "male".equals(request.getParameter("gender")) ? "checked" : "" %> >
    <label for="male">男性</label>
    <input type="radio" id="female" name="gender" value="female"
      <%= "female".equals(request.getParameter("gender")) ? "checked" : "" %> >
    <label for="female">女性</label><br><br>

    <!-- チェックボックス -->
    <p>興味のある分野（複数選択可）:</p>
    <%
      String[] interests = request.getParameterValues("interest");
      java.util.List<String> selected = interests != null ? java.util.Arrays.asList(interests) : java.util.Collections.emptyList();
    %>
    <input type="checkbox" id="tech" name="interest" value="technology"
      <%= selected.contains("technology") ? "checked" : "" %>>
    <label for="tech">技術</label>
    <input type="checkbox" id="design" name="interest" value="design"
      <%= selected.contains("design") ? "checked" : "" %>>
    <label for="design">デザイン</label>
    <input type="checkbox" id="business" name="interest" value="business"
      <%= selected.contains("business") ? "checked" : "" %>>
    <label for="business">ビジネス</label><br><br>

    <!-- セレクトボックス -->
    <label for="age">年齢:</label>
    <select id="age" name="age">
      <option value="">選択してください</option>
      <option value="teens" <%= "teens".equals(request.getParameter("age")) ? "selected" : "" %>>10代</option>
      <option value="20s" <%= "20s".equals(request.getParameter("age")) ? "selected" : "" %>>20代</option>
      <option value="30s" <%= "30s".equals(request.getParameter("age")) ? "selected" : "" %>>30代</option>
      <option value="40s" <%= "40s".equals(request.getParameter("age")) ? "selected" : "" %>>40代以上</option>
    </select><br><br>

    <input type="submit" value="送信">
  </form>
</body>
</html>
