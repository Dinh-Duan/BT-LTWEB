<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chỉnh sửa danh mục</title>
</head>
<body>
    <h2>Chỉnh sửa danh mục</h2>

    <!-- URL xử lý edit -->
    <c:url value="/admin/category/edit" var="editUrl"></c:url>

    <form role="form" action="${editUrl}" method="post" enctype="multipart/form-data">
        <!-- hidden id -->
        <input type="hidden" name="id" value="${category.cateid}" />

        <div class="form-group">
            <label>Tên danh mục:</label><br>
            <input type="text" class="form-control" 
                   name="name" value="${category.catename}" required />
        </div>
        <br>

        <div class="form-group">
            <label>Ảnh hiện tại:</label><br>
            <c:url value="/image?fname=${category.icon}" var="imgUrl"></c:url>
            <img class="img-responsive" width="150" src="${imgUrl}" alt="Category Icon" />
        </div>
        <br>

        <div class="form-group">
            <label>Chọn ảnh mới:</label><br>
            <input type="file" name="icon" />
        </div>
        <br>

        <button type="submit" class="btn btn-default">Cập nhật</button>
        <button type="reset" class="btn btn-primary">Reset</button>
    </form>
</body>
</html>
