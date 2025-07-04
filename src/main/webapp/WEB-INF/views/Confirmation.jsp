<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>書籍予約確認</title>
    </head>

    <body>
        <h2>ご予約が完了しました！</h2>
        <p>・ご予約内容の確認の連絡をSMSで通知いたしました。</p>
        <p>・後日、入荷した際に金額などの情報を通知いたします</p>
        <h2>ご予約内容</h2>
        <form method="post" action="/post">
            <table>
                <tr>
                    <td>書籍名（タイトル）:</td>
                    <td><input type="text" name="title" /></td>
                </tr>
                <tr>
                    <td>出版社名：</td>
                    <td><input type="text" name="publisher" /></td>
                </tr>
                <tr>
                    <td>冊数：</td>
                    <td><input type="text" name="count" /></td>
                </tr>
                <tr>
                    <td>お名前：</td>
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
            </table>
            <button type="submit">予約画面に戻る</button>
        </form>
    </body>

    </html>