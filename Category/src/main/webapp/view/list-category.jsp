<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách danh mục</title>
</head>
<body>
    <h2>Danh sách danh mục</h2>
    <a href="<c:url value='/admin/category/add' />">+ Thêm danh mục</a>
    <br><br>

    <table border="1" width="80%" cellspacing="0" cellpadding="5">
        <tr>
            <th>STT</th>
            <th>Icon</th>
            <th>Tên danh mục</th>
            <th>Hành động</th>
        </tr>

        <c:forEach items="${cateList}" var="cate" varStatus="STT">
            <tr>
                <td>${STT.index + 1}</td>
                <c:url value="/image?fname=${cate.icon}" var="imgUrl"></c:url>
                <td><img src="${imgUrl}" width="120" height="100" /></td>
                <td>${cate.catename}</td>
                <td>
                    <a href="<c:url value='/admin/category/edit?id=${cate.cateid}'/>">Sửa</a>
                    |
                    <a href="<c:url value='/admin/category/delete?id=${cate.cateid}'/>">Xóa</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
