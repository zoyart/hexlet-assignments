@import exercise.dto.users.UsersPage
@param UsersPage users

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>${users.getHeader()}</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        table {
            width: 50%;
            border-collapse: collapse;
            margin: 0 auto;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        th, td {
            padding: 12px 15px;
            text-align: left;
        }
        th {
            background-color: #007BFF;
            color: #fff;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        a {
            color: #007BFF;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
        .counter {
            width: 50px;
            text-align: center;
            background-color: #007BFF;
            color: #fff;
        }
    </style>
</head>
<body>
<table>
    <thead>
    <tr>
        <th class="counter"></th>
        <th>Имя пользователя</th>
    </tr>
    </thead>
    <tbody>

        @for (int i = 0; i < users.getUsers().size(); i++)
            <tr>
            <td class="counter">${i + 1}</td>
            <td><a href="/users/${users.getUsers().get(i).getId()}">${users.getUsers().get(i).getFirstName()} ${users.getUsers().get(i).getLastName()}</a></td>
    </tr>
        @endfor

    </tbody>
</table>
</body>
</html>