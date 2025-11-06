<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8" />
<title>社員編集フォーム</title>
<style>
  html, body {
    height: 100%;
    margin: 0;
    font-family: "ヒラギノ角ゴ ProN", "Hiragino Kaku Gothic ProN", Meiryo, sans-serif;
    background-color: #f9f9f9;
  }
  body {
    display: flex;
    justify-content: center;
    align-items: center;
  }
  .form-container {
    background: #fff;
    padding: 30px 40px;
    border-radius: 8px;
    box-shadow: 0 2px 6px rgba(0,0,0,0.1);
    width: 450px;
  }

  h1 {
    color: #333;
    margin-bottom: 20px;
    text-align: center;
  }

  label {
    display: inline-block;
    width: 70px;
    font-weight: bold;
    vertical-align: top;
    margin-bottom: 10px;
  }

  input[type="text"],
  textarea {
    width: calc(100% - 80px);
    padding: 6px 8px;
    border: 1px solid #ccc;
    border-radius: 4px;
    font-size: 14px;
  }

  textarea {
    resize: vertical;
  }

  input[type="radio"] {
    margin-left: 10px;
    margin-right: 4px;
  }

  .btn-group {
    margin-top: 15px;
    display: flex;
    justify-content: space-between;
    align-items: center;
  }

  .btn-left {
    display: flex;
    gap: 8px;
  }

  input[type="submit"],
  input[type="reset"],
  .btn-list {
    background-color: #4caf50;
    color: white;
    border: none;
    padding: 8px 16px;
    border-radius: 4px;
    cursor: pointer;
    font-size: 15px;
    transition: background-color 0.3s ease;
    text-decoration: none;
    display: inline-block;
  }

  input[type="reset"] {
    background-color: #f44336;
  }

  input[type="submit"]:hover {
    background-color: #45a049;
  }

  input[type="reset"]:hover {
    background-color: #d32f2f;
  }

  .btn-list:hover {
    background-color: #388e3c;
  }
</style>
</head>
<body>
  <div class="form-container">
    <h1>社員編集フォーム</h1>

    <% String id = (String) request.getAttribute("ユーザーID"); %>

    <form action="shain_hensyuu" method="post">
      <input type="hidden" name="ユーザーID" value="<%= id != null ? id : "" %>">

      <label for="name">氏名：</label>
      <input type="text" id="name" name="氏名" required value="<%= request.getAttribute("氏名") != null ? request.getAttribute("氏名") : "" %>">
      <br><br>

      <label>性別：</label>
      <input type="radio" id="male" name="性別" value="M"
        <%= "M".equals(request.getAttribute("性別")) ? "checked" : "" %>>
      <label for="male">男性</label>

      <input type="radio" id="female" name="性別" value="F"
        <%= "F".equals(request.getAttribute("性別")) ? "checked" : "" %>>
      <label for="female">女性</label>
      <br><br>

      <label for="bikou">備考：</label><br>
      <textarea id="bikou" name="備考" rows="5" cols="40"><%= request.getAttribute("備考") != null ? request.getAttribute("備考") : "" %></textarea>
      <br><br>

      <% String error = (String) request.getAttribute("errorMessage"); %>
      <% if (error != null) { %>
        <div style="color:red; font-size: 14px;"><%= error %></div><br>
      <% } %>

      <div class="btn-group">
        <div class="btn-left">
          <input type="submit" value="更新">
          <input type="reset" value="リセット">
        </div>
        <a href="shain_itirann" class="btn-list">社員一覧へ</a>
      </div>
    </form>
  </div>
</body>
</html>
