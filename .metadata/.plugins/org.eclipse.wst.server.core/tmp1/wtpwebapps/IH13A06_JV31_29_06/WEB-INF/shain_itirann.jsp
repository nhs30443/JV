<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Shain" %>

<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>社員一覧</title>
  <style>
    body { font-family: "ヒラギノ角ゴ ProN", Meiryo, sans-serif; background-color: #f9f9f9; padding:30px; }
    h1 { color:#333; margin-bottom:20px; }
    table { border-collapse: collapse; width:100%; max-width:800px; background:#fff; border-radius:8px; box-shadow:0 2px 6px rgba(0,0,0,0.1); }
    th, td { border:1px solid #ccc; padding:10px 12px; text-align:left; font-size:14px; }
    th { background-color:#4caf50; color:white; }
    tr:nth-child(even){ background-color:#f2f2f2; }
    a { color:#4caf50; text-decoration:none; font-weight:bold; }
    a:hover { text-decoration:underline; }
    .container { max-width:820px; margin:0 auto; }
    .btn-back { display:inline-block; margin-top:20px; background-color:#4caf50; color:white; padding:8px 16px; border-radius:4px; text-decoration:none; font-weight:bold; }
    .btn-back:hover { background-color:#45a049; }

    /* 検索フォーム用テーブル風デザイン */
    .search-form { width:100%; max-width:800px; margin-bottom:20px; border-collapse: collapse; background:#fff; border-radius:8px; box-shadow:0 2px 6px rgba(0,0,0,0.1); }
    .search-form td { padding:8px 12px; font-size:14px; }
    .search-form input, .search-form select { padding:4px 6px; border:1px solid #ccc; border-radius:4px; }
    .search-form button { background-color:#4caf50; color:white; padding:6px 12px; border:none; border-radius:4px; cursor:pointer; font-weight:bold; }
    .search-form button:hover { background-color:#45a049; }
  </style>
</head>
<body>
<div class="container">
  <h1>社員一覧</h1>

  <!-- 検索フォーム -->
  <form class="search-form" action="shain_itirann" method="get">
    <table>
      <tr>
        <td>氏名</td>
        <td><input type="text" name="name" value="<%= request.getParameter("name") != null ? request.getParameter("name") : "" %>"></td>
        <td>性別</td>
        <td>
          <select name="gender">
            <option value="">全て</option>
            <option value="M" <%= "M".equals(request.getParameter("gender")) ? "selected" : "" %>>男性</option>
            <option value="F" <%= "F".equals(request.getParameter("gender")) ? "selected" : "" %>>女性</option>
          </select>
        </td>
      </tr>
      <tr>
        <td>備考</td>
        <td><input type="text" name="note" value="<%= request.getParameter("note") != null ? request.getParameter("note") : "" %>"></td>
        <td>ソート</td>
        <td>
          <select name="sort">
            <option value="id" <%= "id".equals(request.getParameter("sort")) ? "selected" : "" %>>社員ID</option>
            <option value="name" <%= "name".equals(request.getParameter("sort")) ? "selected" : "" %>>氏名</option>
            <option value="gender" <%= "gender".equals(request.getParameter("sort")) ? "selected" : "" %>>性別</option>
            <option value="note" <%= "note".equals(request.getParameter("sort")) ? "selected" : "" %>>備考</option>
          </select>
        </td>
      </tr>
      <tr>
        <td>順序</td>
        <td>
          <select name="order">
            <option value="asc" <%= "asc".equals(request.getParameter("order")) ? "selected" : "" %>>昇順</option>
            <option value="desc" <%= "desc".equals(request.getParameter("order")) ? "selected" : "" %>>降順</option>
          </select>
        </td>
        <td colspan="2"><button type="submit">検索</button></td>
      </tr>
    </table>
  </form>

  <% 
    List<Shain> shainList = (List<Shain>) request.getAttribute("shainList");
    if (shainList == null || shainList.isEmpty()) {
  %>
      <p>条件に一致する社員はいません。</p>
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
              <button type="submit" onclick="return confirm('本当に削除しますか？');" style="background:none; border:none; color:#4caf50; font-weight:bold; cursor:pointer;">削除</button>
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
