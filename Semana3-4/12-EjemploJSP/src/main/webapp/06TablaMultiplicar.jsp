<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Tabla de Multiplicar</title>
      <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            text-align: center;
            padding: 5px;
        }
    </style> 
</head>
<body>
    <table>
        
            <% 
                for (int i = 1; i <= 10; i++) {
            %>
                <tr>
                    <% 
                        for (int j = 1; j <= 10; j++) { 
                    %>
                                <td><%= i * j %></td>
                    <% 
                        }
                    %>
                </tr>
            <% 
                }
            %>
        
    </table>
</body>
</html>
