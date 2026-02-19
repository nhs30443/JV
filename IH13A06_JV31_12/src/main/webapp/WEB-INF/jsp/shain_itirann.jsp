<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

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

    .search-form { width:100%; max-width:800px; margin-bottom:20px; border-collapse: collapse; background:#fff; border-radius:8px; box-shadow:0 2px 6px rgba(0,0,0,0.1); }
    .search-form td { padding:8px 12px; font-size:14px; }
    .search-form input, .search-form select { padding:4px 6px; border:1px solid #ccc; border-radius:4px; font-size:14px; }
    .search-form button { background-color:#4caf50; color:white; padding:6px 12px; border:none; border-radius:4px; cursor:pointer; font-weight:bold; }
    .search-form button:hover { background-color:#45a049; }

    .btn-pdf { display:inline-block; margin-top:20px; background-color:#ff9800; color:white; padding:8px 16px; border:none; border-radius:4px; font-weight:bold; cursor:pointer; text-decoration:none; }
    .btn-pdf:hover { background-color:#fb8c00; }
  </style>
</head>
<body>
<div class="container">
  <h1>社員一覧</h1>

  <s:form cssClass="search-form" action="shain_itirann" method="get" theme="simple">
    <table>
      <tr>
        <td>氏名</td>
        <td><s:textfield name="name" cssClass=""/></td>
        <td>性別</td>
        <td>
          <s:select name="gender" cssClass="" list="#{'':'全て','M':'男性','F':'女性'}"/>
        </td>
      </tr>
      <tr>
        <td>備考</td>
        <td><s:textfield name="note" cssClass=""/></td>
        <td>ソート</td>
        <td>
          <s:select name="sort" cssClass="" list="#{'id':'社員ID','name':'氏名','gender':'性別','note':'備考'}"/>
        </td>
      </tr>
      <tr>
        <td>順序</td>
        <td>
          <s:select name="order" cssClass="" list="#{'asc':'昇順','desc':'降順'}"/>
        </td>
        <td colspan="2">
          <s:submit value="検索" cssClass=""/>
        </td>
      </tr>
    </table>
  </s:form>

  <s:if test="shainList == null || shainList.size() == 0">
    <p>条件に一致する社員はいません。</p>
  </s:if>

  <s:else>
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
        <s:iterator value="shainList" var="s">
          <tr>
            <td><s:property value="#s.id"/></td>
            <td><s:property value="#s.name"/></td>
            <td><s:property value="#s.gender"/></td>
            <td><s:property value="#s.note"/></td>
            <td>
              <a href="shain_hensyuu?id=<s:property value='#s.id'/>">更新</a> |
              <form action="shain_sakujyo" method="post" style="display:inline;">
                <input type="hidden" name="id" value="<s:property value='#s.id'/>">
                <button type="submit" style="background:none; border:none; color:#4caf50; font-weight:bold; cursor:pointer;" onclick="return confirm('本当に削除しますか？');">削除</button>
              </form>
            </td>
          </tr>
        </s:iterator>
      </tbody>
    </table>
  </s:else>

  <s:form action="shain_pdf" method="get" theme="simple">
    <s:hidden name="name"/>
    <s:hidden name="gender"/>
    <s:hidden name="note"/>
    <s:hidden name="sort"/>
    <s:hidden name="order"/>
    <button type="submit" class="btn-pdf">帳票出力（PDF）</button>
  </s:form>

  <a href="shain_touroku" class="btn-back">社員登録へ戻る</a>
</div>
</body>
</html>
