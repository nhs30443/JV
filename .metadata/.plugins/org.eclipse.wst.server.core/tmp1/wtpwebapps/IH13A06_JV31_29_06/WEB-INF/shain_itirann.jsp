<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Shain" %>

<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>社員一覧</title>
  <style>
    body {
      font-family: "ヒラギノ角ゴ ProN", "Hiragino Kaku Gothic ProN", Meiryo, sans-serif;
      background-color: #f9f9f9;
      padding: 30px;
    }

    h1 {
      color: #333;
      margin-bottom: 20px;
    }

    table {
      border-collapse: collapse;
      width: 100%;
      max-width: 800px;
      background: #fff;
      border-radius: 8px;
      box-shadow: 0 2px 6px rgba(0,0,0,0.1);
    }

    th, td {
      border: 1px solid #ccc;
      padding: 10px 12px;
      text-align: left;
      font-size: 14px;
    }

    th {
      background-color: #4caf50;
      color: white;
    }

    tr:nth-child(even) {
      background-color: #f2f2f2;
    }

    a {
      color: #4caf50;
      text-decoration: none;
      font-weight: bold;
    }

    a:hover {
      text-decoration: underline;
    }

    .container {
      max-width: 820px;
      margin: 0 auto;
    }

    .btn-back {
      display: inline-block;
      margin-top: 20px;
      background-color: #4caf50;
      color: white;
      padding: 8px 16px;
      border-radius: 4px;
      text-decoration: none;
      font-weight: bold;
    }
    .btn-back:hover {
      background-color: #45a049;
    }
  </style>
</head>
<body>
  <div class="container">
    <h1>社員一覧</h1>
    <%
	    String flashMessage = (String) session.getAttribute("flashMessage");
	    String flashType = (String) session.getAttribute("flashType");
	    if (flashMessage != null) {
	        String colorClass = "flash-success";
	        if ("error".equals(flashType)) {
	            colorClass = "flash-error";
	        }
	%>
	<div id="flash-message" class="<%= colorClass %>"><%= flashMessage %></div>
	<script>
	  setTimeout(() => {
	    const flash = document.getElementById("flash-message");
	    flash.style.transition = "opacity 1s ease";
	    flash.style.opacity = "0";
	    setTimeout(() => flash.remove(), 1000);
	  }, 2000);
	</script>
	<%
	        session.removeAttribute("flashMessage");
	        session.removeAttribute("flashType");
	    }
	%>
	
	<style>
	  #flash-message {
	    position: fixed;
	    top: 10px;
	    left: 50%;
	    transform: translateX(-50%);
	    color: white;
	    padding: 12px 24px;
	    border-radius: 6px;
	    font-weight: bold;
	    box-shadow: 0 2px 8px rgba(0,0,0,0.2);
	    z-index: 9999;
	    opacity: 1;
	  }
	  .flash-success {
	    background-color: #4caf50; /* 緑 */
	  }
	  .flash-error {
	    background-color: #f44336; /* 赤 */
	  }
	</style>
    

    <% 
      List<Shain> shainList = (List<Shain>) request.getAttribute("shainList");

      if (shainList == null || shainList.isEmpty()) {
    %>
        <p>登録された社員はいません。</p>
    <% } else { %>
      <table>
        <thead>
          <tr>
            <th>社員ID</th>
            <th>氏名</th>
            <th>性別</th>
            <th>備考</th>
      		<th>操作</th>
          </tr>
        </thead>
        <tbody>
        <% for (Shain s : shainList) { %>
          <tr>
            <td><%= s.getId() %></td>
            <td><%= s.getName() %></td>
            <td><%= "M".equals(s.getGender()) ? "男性" : "女性" %></td>
            <td><%= s.getNote() != null ? s.getNote() : "" %></td>
            <td>
			  <a href="shain_hensyuu?id=<%= s.getId() %>">更新</a> |
			  <form action="shain_sakujyo" method="post" style="display:inline;">
			    <input type="hidden" name="id" value="<%= s.getId() %>">
			    <button type="submit" onclick="return confirm('本当に削除しますか？');" style="background:none; border:none; color:#4caf50; font-weight:bold; cursor:pointer;">
			      削除
			    </button>
			  </form>
			</td>
          </tr>
        <% } %>
        </tbody>
      </table>
    <% } %>

    <a href="shain_touroku" class="btn-back">社員登録へ戻る</a>
  </div>
</body>
</html>
