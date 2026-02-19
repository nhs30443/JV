<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

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
  body { display: flex; justify-content: center; align-items: center; }
  .form-container {
    background: #fff;
    padding: 30px 40px;
    border-radius: 8px;
    box-shadow: 0 2px 6px rgba(0,0,0,0.1);
    width: 450px;
  }
  h1 { color: #333; margin-bottom: 20px; text-align: center; }
  label { display: inline-block; width: 70px; font-weight: bold; vertical-align: top; margin-bottom: 10px; }
  input[type="text"], textarea {
    width: calc(100% - 80px);
    padding: 6px 8px;
    border: 1px solid #ccc;
    border-radius: 4px;
    font-size: 14px;
    margin-bottom: 20px;
  }
  textarea { resize: vertical; }
  input[type="radio"] { margin-left: 10px; margin-right: 4px; }
  .btn-group { margin-top: 15px; display: flex; justify-content: space-between; align-items: center; }
  .btn-left { display: flex; gap: 8px; }
  input[type="submit"], input[type="reset"], .btn-list {
    background-color: #4caf50;
    color: white;
    border: none;
    padding: 8px 16px;
    border-radius: 4px;
    cursor: pointer;
    font-size: 15px;
    transition: 0.3s ease;
    text-decoration: none;
    display: inline-block;
  }
  input[type="reset"] { background-color: #f44336; }
  input[type="submit"]:hover { background-color: #45a049; }
  input[type="reset"]:hover { background-color: #d32f2f; }
  .btn-list:hover { background-color: #388e3c; }
  .error { color:red; font-size:14px; margin-bottom:10px; }
</style>
</head>

<body>
  <div class="form-container">
    <h1>社員編集フォーム</h1>

    <s:form action="shain_hensyuu" method="post" theme="simple">
      <s:hidden name="id" value="%{id}"/>

      <div class="input-row">
        <label for="name">氏名：</label>
        <s:textfield id="name" name="name" required="true" value="%{name}" theme="simple"/>
      </div>

      <div class="input-row">
        <label>性別：</label>
        <s:radio name="gender" list="#{'M':'男性','F':'女性'}" value="%{gender}" theme="simple"/>
      </div>

      <div class="input-row">
        <label for="note">備考：</label>
        <s:textarea id="note" name="note" rows="5" cols="40" value="%{note}" theme="simple"/>
      </div>

      <s:if test="errorMessage != null">
        <div class="error"><s:property value="errorMessage"/></div>
      </s:if>

      <div class="btn-group">
        <div class="btn-left">
          <s:submit value="更新"/>
          <s:reset value="リセット"/>
        </div>
        <s:a action="shain_itirann" cssClass="btn-list">社員一覧へ</s:a>
      </div>
    </s:form>
  </div>
</body>
</html>
