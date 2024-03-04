use `module5project`;

-- Init sample data for Role.
insert into role values (1, 'ROLE_USER'),
                        (2, 'ROLE_ADMIN');
-- Init sample data for Category.
insert into category (category_id, category_name, description, created_date, updated_date, status)
values (1, 'Áo', 'Các loại áo', '2023-03-03', '2024-03-03', true),
       (2, 'Quần', 'Các loại quần', '2023-04-03', '2024-03-03', true),
       (3, 'Váy', 'Các loại váy, chân váy', '2023-05-03', '2024-03-03', true),
       (4, 'Phụ kiện', 'Các loại trang sức, phụ kiện', '2023-06-03', '2024-03-03', true),
       (5, 'Nội y', 'Các loại đồ nội y nam, nữ', '2023-07-03', '2024-03-03', true),
       (6, 'Bánh', 'Các loại bánh', '2023-08-03', '2024-03-03', true),
       (7, 'Kẹo', 'Các loại kẹo', '2023-10-03', '2024-03-03', true),
       (8, 'Nước ngọt', 'Các loại nước ngọt', '2023-12-03', '2024-03-03', true),
       (9, 'Rượu', 'Các loại rượu', '2023-01-03', '2024-03-03', false),
       (10, 'Tivi', 'Các loại Tivi', '2023-02-03', '2024-03-03', true),
       (11, 'Tủ lạnh', 'Các loại tủ lạnh', '2023-09-03', '2024-03-03', true),
       (12, 'Máy giặt', 'Các loại máy giặt', '2023-10-03', '2024-03-03', false),
       (13, 'Tai nghe', 'Các loại tai nghe', '2023-11-03', '2024-03-03', true),
       (14, 'Chuột', 'Các loại chuột', '2023-12-03', '2024-03-03', true),
       (15, 'Bàn phím', 'Các loại bàn phím', '2023-03-03', '2024-03-03', true);

-- Init sample data for Products.
insert into products (product_id, product_name, sku, stock_quantity, unit_price, description, created_date, updated_date, category_id, status)
    values (1, 'Áo thun nam cổ tròn basic', 'AOTHUNNAM01', 100, 120000, 'Áo thun nam cổ tròn basic, chất liệu cotton co giãn tốt, form slimfit, phù hợp cho mọi hoạt động.', CURRENT_DATE(), CURRENT_DATE(), 1, true),
        (2, 'Quần jean nam rách gối', 'QUANJEANNAM01', 80, 250000, 'Quần jean nam rách gối, phong cách bụi bặm, cá tính, phù hợp cho các hoạt động năng động.', CURRENT_DATE(), CURRENT_DATE(), 2, true),
        (3, 'Váy maxi nữ hoa nhí', 'VAYMAXINU01', 50, 350000, 'Váy maxi nữ hoa nhí, chất liệu voan mềm mại, kiểu dáng thanh lịch, phù hợp cho các buổi đi chơi, dự tiệc.', CURRENT_DATE(), CURRENT_DATE(), 3, true),
        (4, 'Dây chuyền nữ mặt ngọc trai', 'DAYCHUYENNU01', 30, 500000, 'Dây chuyền nữ mặt ngọc trai, thiết kế sang trọng, tinh tế, phù hợp làm quà tặng.', CURRENT_DATE(), CURRENT_DATE(), 4, true),
        (5, 'Bộ đồ lót nữ ren sexy', 'BODOLOTNU01', 20, 180000, 'Bộ đồ lót nữ ren sexy, chất liệu ren mềm mại, quyến rũ, giúp tôn lên vẻ đẹp của phụ nữ.', CURRENT_DATE(), CURRENT_DATE(), 5, true),
        (6, 'Bánh kẹo Tết hộp thiếc', 'BANHKEOTET01', 100, 200000, 'Bánh kẹo Tết hộp thiếc, nhiều loại bánh kẹo thơm ngon, phù hợp cho dịp Tết Nguyên Đán.', CURRENT_DATE(), CURRENT_DATE(), 6, true),
        (7, 'Kẹo socola hộp quà Valentine', 'KEOSOCOLAVALENTINE01', 50, 150000, 'Kẹo socola hộp quà Valentine, thiết kế đẹp mắt, ngọt ngào, phù hợp làm quà tặng cho người yêu.', CURRENT_DATE(), CURRENT_DATE(), 7, true),
        (8, 'Nước ngọt Coca-Cola lon 330ml', 'NUOCNGOCCOCA01', 120, 15000, 'Nước ngọt Coca-Cola lon 330ml, giải khát hiệu quả, phù hợp cho mọi hoạt động.', CURRENT_DATE(), CURRENT_DATE(), 8, true),
        (9, 'Rượu vang đỏ Chile', 'RUOUVANGDOCHILE01', 20, 600000, 'Rượu vang đỏ Chile, hương vị đậm đà, êm dịu, phù hợp cho các bữa tiệc sang trọng.', CURRENT_DATE(), CURRENT_DATE(), 9, true),
        (10, 'Tivi Samsung 4K 55 inch', 'TIVISAMSUNG4K55INCH01', 10, 15000000, 'Tivi Samsung 4K 55 inch, hình ảnh sắc nét, âm thanh sống động, mang đến trải nghiệm giải trí tuyệt vời.', CURRENT_DATE(), CURRENT_DATE(), 10, true),
        (11, 'Tủ lạnh LG Inverter 2 cánh', 'TULANHLGINVERTER2CANH01', 5, 10000000, 'Tủ lạnh LG Inverter 2 cánh, tiết kiệm điện năng, bảo quản thực phẩm tươi ngon.', CURRENT_DATE(), CURRENT_DATE(), 11, true);