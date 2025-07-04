<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ログイン画面</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css">
    </head>

    <body>
        <h2>ログイン画面</h2>
        <form method="post" action="/post">
            <table>
                <tr>
                    <td>ユーザID:</td>
                    <td><input type="text" name="user" /></td>
                </tr>
                <tr>
                    <td>パスワード：</td>
                    <td><input type="password" name="password" /></td>
                </tr>
            </table>
            <button type="submit">ログイン</button>
        </form>
    </body>

    </html>