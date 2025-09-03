<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm danh mục</title>
</head>
<body>
    <h2>Thêm danh mục mới</h2>

    <form role="form" action="add" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label>Tên danh mục:</label><br>
            <input class="form-control" type="text" name="name" 
                   placeholder="please enter category name" required />
        </div>
        <br>
        <div class="form-group">
            <label>Ảnh đại diện:</label><br>
            <input type="file" name="icon" />
        </div>
        <br>
        <button type="submit" class="btn btn-default">Thêm</button>
        <button type="reset" class="btn btn-primary">Hủy</button>
    </form>
</body>
</html>
