<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Danh sách sản phẩm</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f5f6fa;
                margin: 0;
                padding: 0;
            }

            h1 {
                text-align: center;
                margin-top: 20px;
                color: #2c3e50;
            }

            /* Grid hiển thị sản phẩm */
            .product-grid {
                display: grid;
                grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
                gap: 20px;
                padding: 20px;
                width: 90%;
                margin: auto;
            }

            .product {
                background-color: #fff;
                border: 1px solid #ddd;
                border-radius: 10px;
                padding: 15px;
                text-align: center;
                box-shadow: 0 2px 6px rgba(0,0,0,0.1);
                transition: transform 0.2s, box-shadow 0.2s;
            }

            .product:hover {
                transform: translateY(-5px);
                box-shadow: 0 4px 10px rgba(0,0,0,0.15);
            }

            .product img {
                width: 100%;
                height: 200px;
                object-fit: cover;
                border-radius: 8px;
                background-color: #eee;
            }

            .product h4 {
                margin: 10px 0 5px;
                color: #007bff;
            }

            .product p {
                margin: 5px 0;
                color: #555;
            }

            .product-price {
                font-weight: bold;
                color: #d9534f;
                font-size: 18px;
            }

            .empty {
                text-align: center;
                margin-top: 50px;
                color: #888;
            }
            .category-bar {
                display: flex;
                justify-content: center;
                flex-wrap: wrap;
                gap: 15px;
                background-color: #fff;
                padding: 10px 0;
                border-bottom: 1px solid #ddd;
            }

            .category-bar a {
                text-decoration: none;
                color: #333;
                padding: 8px 16px;
                border-radius: 5px;
                transition: all 0.2s;
                font-weight: bold;
            }

            .category-bar a:hover {
                background-color: #007bff;
                color: white;
            }

            .category-bar a.active {
                background-color: #007bff;
                color: white;
            }
            .search-container {
                text-align: center;
                margin: 20px 0;
            }

            .search-container input[type="text"] {
                width: 300px;
                padding: 8px;
                font-size: 16px;
                border: 1px solid #ccc;
                border-radius: 5px;
            }

            .search-container button {
                padding: 8px 16px;
                font-size: 16px;
                background-color: #007bff;
                color: white;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                margin-left: 5px;
            }

            .search-container button:hover {
                background-color: #0056b3;
            }
        </style>
    </head>

    <body>

        <!-- Thanh trên cùng -->
        <div style="text-align: right; background-color: #fff; padding: 10px 20px; border-bottom: 1px solid #ddd;">
            <a href="login.jsp"
               style="text-decoration: none; color: white; background-color: #007bff;
               padding: 8px 16px; border-radius: 5px; font-weight: bold;">
                Đăng nhập
            </a>
        </div>
        <!-- Thanh category -->
        <<form action="categoryController" method="get" style="text-align:center; margin:20px 0;">
            <div class="category-bar">
                <a href="categoryController" 
                   class="${empty selectedCategory ? 'active' : ''}">Tất cả</a>
                <c:forEach var="c" items="${listC}">
                    <a href="categoryController?cid=${c.categoryId}" 
                       class="${selectedCategory == c.categoryId ? 'active' : ''}">
                        ${c.categoryName}
                    </a>
                </c:forEach>
            </div>
        </form>

        <!-- ✅ Thanh tìm kiếm sản phẩm -->
        <div class="search-container">
            <form action="searchController" method="get">
                <input value="${txtS}" type="text" name="txtSearchProduct" placeholder="Nhập tên sản phẩm..." value="${param.txtSearchProduct}">
                <button type="submit">Tìm kiếm</button>
            </form>
        </div>


        <h1>Danh sách sản phẩm</h1>

        <c:choose>
            <c:when test="${not empty listP}">
                <div class="product-grid">
                    <c:forEach var="p" items="${listP}">
                        <a href="detailController?pid=${p.productId}" style="text-decoration:none; color:inherit;">
                            <div class="product">
                                <c:choose>
                                    <c:when test="${not empty p.image}">
                                        <img src="data:image/jpeg;base64,${p.image}" alt="${p.productName}">
                                    </c:when>
                                    <c:otherwise>
                                        <img src="https://via.placeholder.com/250x200?text=No+Image" alt="No image">
                                    </c:otherwise>
                                </c:choose>
                                <h4>${p.productName}</h4>
                                <p class="product-price">
                                <fmt:formatNumber value="${p.price}" type="number" groupingUsed="true"/> VND
                                </p>
                                <p>Màu: ${p.color}</p>
                                <p>Size: ${p.size}</p>
                                <p>Tồn kho: ${p.quantity}</p>
                            </div>
                        </a>
                    </c:forEach>
                </div>

                <h3 style="text-align:center;">
                    Tổng cộng: ${fn:length(listP)} sản phẩm
                </h3>
            </c:when>

            <c:otherwise>
                <div class="empty">
                    <h3>Không có sản phẩm nào để hiển thị.</h3>
                </div>
            </c:otherwise>
        </c:choose>
    </body>
</html>
