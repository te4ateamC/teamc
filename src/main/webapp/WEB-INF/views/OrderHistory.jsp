<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>注文履歴</title>
    </head>

    <body>
        <button type="submit">ログアウト</button>
        <h2>注文履歴</h2>
        <form method="post" action="/post">
            <table>
                <tr>
                    <td>書籍名（タイトル）:</td>
                    <td><input type="text" name="title" /></td>
                </tr>
                <tr>
                    <td>出版社：</td>
                    <td><input type="text" name="publisher" /></td>
                </tr>
                <tr>
                    <td>冊数：</td>
                    <td><input type="text" name="count" /></td>
                </tr>
                <tr>
                    <td>名前：</td>
                    <td><input type="text" name="name" /></td>
                </tr>
                <tr>
                    <td>電話番号:</td>
                    <td><input type="text" name="tel" /></td>
                </tr>
                <tr>
                    <td>メールアドレス：</td>
                    <td><input type="text" name="address" /></td>
                </tr>
                <tr>
                    <td>ISBNコード：</td>
                    <td><input type="text" name="ISBNcode" /></td>
                </tr>
                <tr>
                    <td>承認日時：</td>
                    <td><input type="text" name="date" /></td>
                </tr>
                <tr>
                    <td>金額：</td>
                    <td><input type="text" name="amount" /></td>
                </tr>
            </table>
            <button type="submit">承認する</button>
        </form>
    </body>

    </html>