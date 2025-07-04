<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    request.setCharacterEncoding("UTF-8");

    String title = request.getParameter("title");
    String publisher = request.getParameter("publisher");
    String count = request.getParameter("count");
    String name = request.getParameter("name");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>予約承認する</title>
    <style>
        .horizontal {
            display: flex;
            gap: 20px;
        }
        .vertical {
            display: flex;
            flex-direction: column;
            gap: 10px;
        }
        .section {
            margin: 20px 0;
        }
    </style>
</head>
<body>
    <button onclick="location.href='logout.jsp'">ログアウト</button>

    <h2>予約承認</h2>

    <!-- 横表示 -->
    <div class="section horizontal">
        <div>タイトル：<%= title %></div>
        <div>出版社：<%= publisher %></div>
        <div>冊数：<%= count %></div>
        <div>名前：<%= name %></div>
    </div>

    <!-- 承認フォーム開始 -->
    <form method="post" action="orderhistory.jsp">
        <!-- 隠し項目 -->
        <input type="hidden" name="title" value="<%= title %>" />
        <input type="hidden" name="publisher" value="<%= publisher %>" />
        <input type="hidden" name="count" value="<%= count %>" />
        <input type="hidden" name="name" value="<%= name %>" />

        <!-- ISBNコード（ここに置きたい） -->
        <table>
            <tr>
                <td>ISBNコード：</td>
                <td><input type="text" name="ISBNcode" /></td>
            </tr>
        </table>

        <!-- 縦表示（確認用） -->
        <div class="section vertical">
            <div>タイトル：<%= title %></div>
            <div>出版社：<%= publisher %></div>
            <div>冊数：<%= count %></div>
        </div>

        <!-- 金額入力 -->
        <table>
            <tr>
                <td>金額：</td>
                <td><input type="text" name="amount" /></td>
            </tr>
        </table>

        <!-- 承認ボタン -->
        <button type="submit">承認する</button>
        <!-- 注文履歴に戻るボタン -->
<button type="button" onclick="location.href='orderhistory.jsp'">注文履歴に戻る</button>
    </form>
</body>
</html>