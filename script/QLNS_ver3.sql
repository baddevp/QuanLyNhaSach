USE [QLNS]
GO
/****** Object:  Table [dbo].[CHITIETHOADON]    Script Date: 15/11/2023 8:24:18 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CHITIETHOADON](
	[MAHD] [nchar](16) NOT NULL,
	[MASP] [nchar](10) NOT NULL,
	[SOLUONG] [int] NULL,
 CONSTRAINT [PK_CHITIETHOADON] PRIMARY KEY CLUSTERED 
(
	[MAHD] ASC,
	[MASP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CHITIETHOANTRA]    Script Date: 15/11/2023 8:24:18 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CHITIETHOANTRA](
	[MAYCTH] [nchar](16) NOT NULL,
	[MASP] [nchar](10) NOT NULL,
	[SOLUONGTRA] [int] NULL,
 CONSTRAINT [PK_CHITIETHOANTRA] PRIMARY KEY CLUSTERED 
(
	[MAYCTH] ASC,
	[MASP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CHUCVU]    Script Date: 15/11/2023 8:24:18 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CHUCVU](
	[MACHUCVU] [nchar](5) NOT NULL,
	[TENCHUCVU] [nvarchar](50) NULL,
 CONSTRAINT [PK_CHUCVU] PRIMARY KEY CLUSTERED 
(
	[MACHUCVU] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HINHANH]    Script Date: 15/11/2023 8:24:18 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HINHANH](
	[MAANH] [nvarchar](20) NOT NULL,
	[TENANH] [nvarchar](50) NOT NULL,
	[URL] [nvarchar](80) NOT NULL,
 CONSTRAINT [PK_HINHANH] PRIMARY KEY CLUSTERED 
(
	[MAANH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HOADON]    Script Date: 15/11/2023 8:24:18 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HOADON](
	[MAHOADON] [nchar](16) NOT NULL,
	[NGAYLAPHOADON] [date] NULL,
	[TIENNHAN] [money] NULL,
	[TONGTIEN] [money] NULL,
	[MANV] [nchar](13) NOT NULL,
	[MAKH] [nchar](13) NOT NULL,
	[TRANGTHAI] [bit] NULL,
 CONSTRAINT [PK_HOADON] PRIMARY KEY CLUSTERED 
(
	[MAHOADON] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HOADONTRAHANG]    Script Date: 15/11/2023 8:24:18 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HOADONTRAHANG](
	[MAYEUCAUTRAHANG] [nchar](16) NOT NULL,
	[NGAYLAPHOADONTH] [date] NULL,
	[LYDOTRAHANG] [nvarchar](50) NULL,
	[TIENHOANTRA] [money] NULL,
	[MANV] [nchar](13) NULL,
	[MAKH] [nchar](13) NULL,
	[MAHD] [nchar](16) NULL,
 CONSTRAINT [PK_HOADONTRAHANG] PRIMARY KEY CLUSTERED 
(
	[MAYEUCAUTRAHANG] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KHACHHANG]    Script Date: 15/11/2023 8:24:18 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KHACHHANG](
	[MAKH] [nchar](13) NOT NULL,
	[TENKH] [nvarchar](50) NOT NULL,
	[DIACHI] [nvarchar](50) NULL,
	[SDT] [nvarchar](12) NULL,
	[DIEMTL] [int] NULL,
	[NGAYLAP] [date] NULL,
	[EMAIL] [nvarchar](50) NULL,
 CONSTRAINT [PK_KHACHHANG] PRIMARY KEY CLUSTERED 
(
	[MAKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KHUYENMAI]    Script Date: 15/11/2023 8:24:18 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KHUYENMAI](
	[MAKM] [nvarchar](50) NOT NULL,
	[TENKM] [nvarchar](50) NULL,
	[NGAYBD] [date] NULL,
	[NGAYKT] [date] NULL,
	[CHIETKHAU] [float] NULL,
 CONSTRAINT [PK_KHUYENMAI] PRIMARY KEY CLUSTERED 
(
	[MAKM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LOAISACH]    Script Date: 15/11/2023 8:24:18 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LOAISACH](
	[MALOAISACH] [nchar](10) NOT NULL,
	[TENLOAI] [nvarchar](50) NOT NULL,
	[MOTA] [nvarchar](50) NULL,
	[VAT] [float] NULL,
 CONSTRAINT [PK_LOAISACH] PRIMARY KEY CLUSTERED 
(
	[MALOAISACH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LOAIVANPHONGPHAM]    Script Date: 15/11/2023 8:24:18 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LOAIVANPHONGPHAM](
	[MALOAIVPP] [nchar](10) NOT NULL,
	[TENLOAIVPP] [nvarchar](50) NOT NULL,
	[MOTA] [nvarchar](50) NULL,
	[VAT] [float] NULL,
 CONSTRAINT [PK_LOAIVANPHONGPHAM] PRIMARY KEY CLUSTERED 
(
	[MALOAIVPP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MAUSAC]    Script Date: 15/11/2023 8:24:18 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MAUSAC](
	[MAMAU] [nvarchar](50) NOT NULL,
	[TENMAU] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_MAUSAC] PRIMARY KEY CLUSTERED 
(
	[MAMAU] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NHANVIEN]    Script Date: 15/11/2023 8:24:18 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NHANVIEN](
	[MANV] [nchar](13) NOT NULL,
	[TENNV] [nvarchar](50) NOT NULL,
	[NGAYSINH] [date] NULL,
	[DIACHI] [nvarchar](50) NULL,
	[NGAYVAOLAM] [date] NULL,
	[SDT] [nvarchar](12) NULL,
	[CCCD] [nvarchar](50) NULL,
	[GIOITINH] [bit] NULL,
	[MACHUCVU] [nchar](5) NOT NULL,
	[MAANH] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK_NHANVIEN] PRIMARY KEY CLUSTERED 
(
	[MANV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NHASANXUAT]    Script Date: 15/11/2023 8:24:18 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NHASANXUAT](
	[MANSX] [nchar](10) NOT NULL,
	[TENNSX] [nvarchar](50) NOT NULL,
	[THANHPHO] [nvarchar](50) NULL,
	[EMAIL] [nvarchar](50) NULL,
	[SDT] [nvarchar](12) NULL,
 CONSTRAINT [PK_NHASANXUAT] PRIMARY KEY CLUSTERED 
(
	[MANSX] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SACH]    Script Date: 15/11/2023 8:24:18 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SACH](
	[MASACH] [nchar](10) NOT NULL,
	[TENSACH] [nvarchar](50) NULL,
	[GIAGOC] [money] NULL,
	[MAANH] [nvarchar](20) NOT NULL,
	[MOTA] [nvarchar](50) NULL,
	[NGAYNHAP] [date] NULL,
	[TRANGTHAI] [bit] NULL,
	[SOLUONG] [int] NULL,
	[THUE] [money] NULL,
	[GIABAN] [money] NULL,
	[MANSX] [nchar](10) NOT NULL,
	[MAKHUYENMAI] [nchar](10) NULL,
	[SOTRANG] [int] NULL,
	[LOAIBIA] [nvarchar](50) NULL,
	[TACGIA] [nvarchar](50) NULL,
	[MALOAISACH] [nchar](10) NOT NULL,
 CONSTRAINT [PK_SACH] PRIMARY KEY CLUSTERED 
(
	[MASACH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TAIKHOAN]    Script Date: 15/11/2023 8:24:18 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TAIKHOAN](
	[MATAIKHOAN] [nchar](13) NOT NULL,
	[MATKHAU] [char](6) NULL,
	[PHANQUYEN] [nvarchar](20) NULL,
 CONSTRAINT [PK_TAIKHOAN] PRIMARY KEY CLUSTERED 
(
	[MATAIKHOAN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[VANPHONGPHAM]    Script Date: 15/11/2023 8:24:18 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[VANPHONGPHAM](
	[MAVPP] [nchar](10) NOT NULL,
	[TENVPP] [nvarchar](50) NULL,
	[GIAGOC] [money] NULL,
	[MAANH] [nvarchar](20) NOT NULL,
	[MOTA] [nvarchar](50) NULL,
	[NGAYNHAP] [date] NULL,
	[TRANGTHAI] [bit] NULL,
	[SOLUONG] [int] NULL,
	[THUE] [money] NULL,
	[GIABAN] [money] NULL,
	[MANSX] [nchar](10) NOT NULL,
	[MAKHUYENMAI] [nchar](10) NULL,
	[THUONGHIEU] [nvarchar](50) NULL,
	[XUATXU] [nvarchar](50) NULL,
	[MAMAU] [nvarchar](50) NULL,
	[MALOAIVPP] [nchar](10) NULL,
 CONSTRAINT [PK_VANPHONGPHAM] PRIMARY KEY CLUSTERED 
(
	[MAVPP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[CHUCVU] ([MACHUCVU], [TENCHUCVU]) VALUES (N'CV001', N'Quản lý')
INSERT [dbo].[CHUCVU] ([MACHUCVU], [TENCHUCVU]) VALUES (N'CV002', N'Thu ngân')
GO
INSERT [dbo].[HINHANH] ([MAANH], [TENANH], [URL]) VALUES (N'NV14112023001', N'Ảnh nhân viên Văn Tiến', N'Chưa có')
INSERT [dbo].[HINHANH] ([MAANH], [TENANH], [URL]) VALUES (N'NV14112023002', N'Ảnh nhân viên Cao Trí', N'Chưa có')
INSERT [dbo].[HINHANH] ([MAANH], [TENANH], [URL]) VALUES (N'NV14112023003', N'Ảnh nhân viên Quỳnh Như', N'Chưa có')
INSERT [dbo].[HINHANH] ([MAANH], [TENANH], [URL]) VALUES (N'NV14112023004', N'Ảnh nhân viên Thanh Nguyên', N'Chưa có')
INSERT [dbo].[HINHANH] ([MAANH], [TENANH], [URL]) VALUES (N'SAH002001', N'Ảnh sách Cây Cam Ngọt Của Tôi', N'Chưa có')
INSERT [dbo].[HINHANH] ([MAANH], [TENANH], [URL]) VALUES (N'SAH004001', N'Ảnh sách Thay Đổi Cuộc Sống Với Nhân Số Học', N'Chưa có')
INSERT [dbo].[HINHANH] ([MAANH], [TENANH], [URL]) VALUES (N'SAH004002', N'Ảnh sách Hành Tinh Của Một Kẻ Nghĩ Nhiều', N'Chưa có')
INSERT [dbo].[HINHANH] ([MAANH], [TENANH], [URL]) VALUES (N'VPP001001', N'Ảnh VPP Bút Gel EnerGel Kawaii Pixel Art ', N'Chưa có')
INSERT [dbo].[HINHANH] ([MAANH], [TENANH], [URL]) VALUES (N'VPP002001', N'Ảnh VPP Bộ 2 Hộp Thực Hành Toán Lớp 2 ', N'Chưa có')
GO
INSERT [dbo].[HOADON] ([MAHOADON], [NGAYLAPHOADON], [TIENNHAN], [TONGTIEN], [MANV], [MAKH], [TRANGTHAI]) VALUES (N'HD15112023001001', CAST(N'2023-11-15' AS Date), 200000.0000, 200000.0000, N'NV14112023001', N'KH15112023001', 1)
INSERT [dbo].[HOADON] ([MAHOADON], [NGAYLAPHOADON], [TIENNHAN], [TONGTIEN], [MANV], [MAKH], [TRANGTHAI]) VALUES (N'HD15112023001002', CAST(N'2023-11-15' AS Date), 240000.0000, 235000.0000, N'NV14112023001', N'KH15112023002', 1)
GO
INSERT [dbo].[KHACHHANG] ([MAKH], [TENKH], [DIACHI], [SDT], [DIEMTL], [NGAYLAP], [EMAIL]) VALUES (N'KH09112023001', N'Nguyễn Thị Thủy', N'Thành phố Hồ Chí Minh', N'0365145845', 1450, CAST(N'2023-11-09' AS Date), N'thithuy2000@gmail.com')
INSERT [dbo].[KHACHHANG] ([MAKH], [TENKH], [DIACHI], [SDT], [DIEMTL], [NGAYLAP], [EMAIL]) VALUES (N'KH09112023002', N'Trần Văn Quyết', N'Long An', N'0788845474', 545, CAST(N'2023-11-09' AS Date), N'quyetpro123@gmail.com')
INSERT [dbo].[KHACHHANG] ([MAKH], [TENKH], [DIACHI], [SDT], [DIEMTL], [NGAYLAP], [EMAIL]) VALUES (N'KH09112023003', N'Trần Thị Tố Nữ', N'Thành phố Hồ Chí Minh', N'0788014525', 3278, CAST(N'2023-11-09' AS Date), N'tonuunu@gmail.com')
INSERT [dbo].[KHACHHANG] ([MAKH], [TENKH], [DIACHI], [SDT], [DIEMTL], [NGAYLAP], [EMAIL]) VALUES (N'KH15112023001', N'Nguyễn Anh Minh', N'Lâm Đồng', N'0978412365', 2000, CAST(N'2023-11-10' AS Date), N'nguyenanhminh109@gmail.com')
INSERT [dbo].[KHACHHANG] ([MAKH], [TENKH], [DIACHI], [SDT], [DIEMTL], [NGAYLAP], [EMAIL]) VALUES (N'KH15112023002', N'Lê Thanh Tuấn', N'Đồng Nai', N'0354785123', 2350, CAST(N'2023-11-10' AS Date), N'tuanmwg2301@gmail.com')
GO
INSERT [dbo].[LOAISACH] ([MALOAISACH], [TENLOAI], [MOTA], [VAT]) VALUES (N'LS001     ', N'Sách Tiểu Sử', N'Chưa có', 0)
INSERT [dbo].[LOAISACH] ([MALOAISACH], [TENLOAI], [MOTA], [VAT]) VALUES (N'LS002     ', N'Sách Tiểu Thuyết', N'Chưa có', 0)
INSERT [dbo].[LOAISACH] ([MALOAISACH], [TENLOAI], [MOTA], [VAT]) VALUES (N'LS003     ', N'Sách Ngoại Ngữ', N'Chưa có', 1)
INSERT [dbo].[LOAISACH] ([MALOAISACH], [TENLOAI], [MOTA], [VAT]) VALUES (N'LS004     ', N'Sách Tâm Lý - Kỹ Năng Sống', N'Chưa có', 0)
INSERT [dbo].[LOAISACH] ([MALOAISACH], [TENLOAI], [MOTA], [VAT]) VALUES (N'LS005     ', N'Sách Kinh Tế', N'Chưa có', 1)
GO
INSERT [dbo].[LOAIVANPHONGPHAM] ([MALOAIVPP], [TENLOAIVPP], [MOTA], [VAT]) VALUES (N'LV001     ', N'Bút - viết', N'Chưa có', 0)
INSERT [dbo].[LOAIVANPHONGPHAM] ([MALOAIVPP], [TENLOAIVPP], [MOTA], [VAT]) VALUES (N'LV002     ', N'Dụng cụ học sinh', N'Chưa có', 0)
INSERT [dbo].[LOAIVANPHONGPHAM] ([MALOAIVPP], [TENLOAIVPP], [MOTA], [VAT]) VALUES (N'LV003     ', N'Dụng cụ văn phòng', N'Chưa có', 0)
INSERT [dbo].[LOAIVANPHONGPHAM] ([MALOAIVPP], [TENLOAIVPP], [MOTA], [VAT]) VALUES (N'LV004     ', N'Dụng cụ vẽ', N'Chưa có', 0)
GO
INSERT [dbo].[MAUSAC] ([MAMAU], [TENMAU]) VALUES (N'MAU000', N'Không phân loại màu')
INSERT [dbo].[MAUSAC] ([MAMAU], [TENMAU]) VALUES (N'MAU001', N'Màu đỏ')
INSERT [dbo].[MAUSAC] ([MAMAU], [TENMAU]) VALUES (N'MAU002', N'Màu xanh dương')
GO
INSERT [dbo].[NHANVIEN] ([MANV], [TENNV], [NGAYSINH], [DIACHI], [NGAYVAOLAM], [SDT], [CCCD], [GIOITINH], [MACHUCVU], [MAANH]) VALUES (N'NV14112023001', N'Nguyễn Văn Tiến', CAST(N'2002-01-01' AS Date), N'Bình Dương', CAST(N'2023-11-14' AS Date), N'0932145784', N'090202001541', 1, N'CV001', N'NV14112023001')
INSERT [dbo].[NHANVIEN] ([MANV], [TENNV], [NGAYSINH], [DIACHI], [NGAYVAOLAM], [SDT], [CCCD], [GIOITINH], [MACHUCVU], [MAANH]) VALUES (N'NV14112023002', N'Nguyễn Cao Trí', CAST(N'2003-09-26' AS Date), N'Long An', CAST(N'2023-11-14' AS Date), N'0933241845', N'080203004455', 1, N'CV001', N'NV14112023002')
INSERT [dbo].[NHANVIEN] ([MANV], [TENNV], [NGAYSINH], [DIACHI], [NGAYVAOLAM], [SDT], [CCCD], [GIOITINH], [MACHUCVU], [MAANH]) VALUES (N'NV14112023003', N'Trần Thị Quỳnh Như', CAST(N'2003-04-15' AS Date), N'Long An', CAST(N'2023-11-14' AS Date), N'0377485612', N'070203001148', 0, N'CV002', N'NV14112023003')
INSERT [dbo].[NHANVIEN] ([MANV], [TENNV], [NGAYSINH], [DIACHI], [NGAYVAOLAM], [SDT], [CCCD], [GIOITINH], [MACHUCVU], [MAANH]) VALUES (N'NV14112023004', N'Nguyễn Ngọc Thanh Nguyên', CAST(N'2003-07-24' AS Date), N'Thành phố Hồ Chí MInh', CAST(N'2023-11-14' AS Date), N'0336512545', N'060203040512', 1, N'CV002', N'NV14112023004')
GO
INSERT [dbo].[NHASANXUAT] ([MANSX], [TENNSX], [THANHPHO], [EMAIL], [SDT]) VALUES (N'NSX002001 ', N'NXB Tổng Hợp TPHCM', N'Thành phố Hồ Chí MInh', N'nxhtonghop@gmail.com', N'0214457894')
INSERT [dbo].[NHASANXUAT] ([MANSX], [TENNSX], [THANHPHO], [EMAIL], [SDT]) VALUES (N'NSX002002 ', N'	NXB Hội Nhà Văn', N'Thành phố Hồ Chí MInh', N'nxbhoinhavan@gmail.com', N'0235484521')
INSERT [dbo].[NHASANXUAT] ([MANSX], [TENNSX], [THANHPHO], [EMAIL], [SDT]) VALUES (N'NSX002003 ', N'Cty Văn Phòng Sáng Tạo (Stacom)', N'Thành phố Hồ Chí MInh', N'statommwg@gmail.com', N'0212045210')
GO
INSERT [dbo].[SACH] ([MASACH], [TENSACH], [GIAGOC], [MAANH], [MOTA], [NGAYNHAP], [TRANGTHAI], [SOLUONG], [THUE], [GIABAN], [MANSX], [MAKHUYENMAI], [SOTRANG], [LOAIBIA], [TACGIA], [MALOAISACH]) VALUES (N'SAH002001 ', N'Cây Cam Ngọt Của Tôi', 180000.0000, N'SAH002001', N'Chưa có', CAST(N'2023-10-14' AS Date), 1, 10, 10.0000, 198000.0000, N'NSX002002 ', N'Chưa có   ', 244, N'Bìa cứng', N'José Mauro de Vasconcelos', N'LS002     ')
INSERT [dbo].[SACH] ([MASACH], [TENSACH], [GIAGOC], [MAANH], [MOTA], [NGAYNHAP], [TRANGTHAI], [SOLUONG], [THUE], [GIABAN], [MANSX], [MAKHUYENMAI], [SOTRANG], [LOAIBIA], [TACGIA], [MALOAISACH]) VALUES (N'SAH004001 ', N'Thay Đổi Cuộc Sống Với Nhân Số Học', 190000.0000, N'SAH004001', N'Chưa có', CAST(N'2023-10-14' AS Date), 1, 125, 5.0000, 199500.0000, N'NSX002001 ', N'Chưa có   ', 416, N'Bìa mềm', N'Lê Đỗ Quỳnh Hương', N'LS004     ')
INSERT [dbo].[SACH] ([MASACH], [TENSACH], [GIAGOC], [MAANH], [MOTA], [NGAYNHAP], [TRANGTHAI], [SOLUONG], [THUE], [GIABAN], [MANSX], [MAKHUYENMAI], [SOTRANG], [LOAIBIA], [TACGIA], [MALOAISACH]) VALUES (N'SAH004002 ', N'Hành Tinh Của Một Kẻ Nghĩ Nhiều', 60000.0000, N'SAH004002', N'Chưa có', CAST(N'2023-10-15' AS Date), 1, 203, 10.0000, 66000.0000, N'NSX002001 ', N'Chưa có   ', 200, N'Bìa mềm', N'Amateur Psychology Nguyễn Đoàn Minh Thư', N'LS004     ')
GO
INSERT [dbo].[TAIKHOAN] ([MATAIKHOAN], [MATKHAU], [PHANQUYEN]) VALUES (N'NV14112023001', N'123456', N'CV001')
INSERT [dbo].[TAIKHOAN] ([MATAIKHOAN], [MATKHAU], [PHANQUYEN]) VALUES (N'NV14112023002', N'123456', N'CV001')
INSERT [dbo].[TAIKHOAN] ([MATAIKHOAN], [MATKHAU], [PHANQUYEN]) VALUES (N'NV14112023003', N'123456', N'CV002')
INSERT [dbo].[TAIKHOAN] ([MATAIKHOAN], [MATKHAU], [PHANQUYEN]) VALUES (N'NV14112023004', N'123456', N'CV002')
GO
INSERT [dbo].[VANPHONGPHAM] ([MAVPP], [TENVPP], [GIAGOC], [MAANH], [MOTA], [NGAYNHAP], [TRANGTHAI], [SOLUONG], [THUE], [GIABAN], [MANSX], [MAKHUYENMAI], [THUONGHIEU], [XUATXU], [MAMAU], [MALOAIVPP]) VALUES (N'VPP001001 ', N'Bút Gel EnerGel Kawaii Pixel Art ', 50000.0000, N'VPP001001', N'Chưa có', CAST(N'2023-10-12' AS Date), 1, 950, 0.0000, 50000.0000, N'NSX002003 ', N'Chưa có   ', N'Pentel', N'Nhật Bản', N'MAU002', N'LV001     ')
INSERT [dbo].[VANPHONGPHAM] ([MAVPP], [TENVPP], [GIAGOC], [MAANH], [MOTA], [NGAYNHAP], [TRANGTHAI], [SOLUONG], [THUE], [GIABAN], [MANSX], [MAKHUYENMAI], [THUONGHIEU], [XUATXU], [MAMAU], [MALOAIVPP]) VALUES (N'VPP002001 ', N'Bộ 2 Hộp Thực Hành Toán Lớp 2 Dùng Cho Học Sinh', 140000.0000, N'VPP002001', N'Chưa có', CAST(N'2023-10-12' AS Date), 1, 12, 10.0000, 154000.0000, N'NSX002003 ', N'Chưa có   ', N'	Thiết Bị Trường Học TP.HCM', N'Việt Nam', N'MAU000', N'LV002     ')
GO
ALTER TABLE [dbo].[CHITIETHOADON]  WITH CHECK ADD  CONSTRAINT [FK_CHITIETHOADON_HOADON] FOREIGN KEY([MAHD])
REFERENCES [dbo].[HOADON] ([MAHOADON])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[CHITIETHOADON] CHECK CONSTRAINT [FK_CHITIETHOADON_HOADON]
GO
ALTER TABLE [dbo].[CHITIETHOADON]  WITH CHECK ADD  CONSTRAINT [FK_CHITIETHOADON_SACH] FOREIGN KEY([MASP])
REFERENCES [dbo].[SACH] ([MASACH])
GO
ALTER TABLE [dbo].[CHITIETHOADON] CHECK CONSTRAINT [FK_CHITIETHOADON_SACH]
GO
ALTER TABLE [dbo].[CHITIETHOADON]  WITH CHECK ADD  CONSTRAINT [FK_CHITIETHOADON_VANPHONGPHAM] FOREIGN KEY([MASP])
REFERENCES [dbo].[VANPHONGPHAM] ([MAVPP])
GO
ALTER TABLE [dbo].[CHITIETHOADON] CHECK CONSTRAINT [FK_CHITIETHOADON_VANPHONGPHAM]
GO
ALTER TABLE [dbo].[CHITIETHOANTRA]  WITH CHECK ADD  CONSTRAINT [FK_CHITIETHOANTRA_HOADONTRAHANG] FOREIGN KEY([MAYCTH])
REFERENCES [dbo].[HOADONTRAHANG] ([MAYEUCAUTRAHANG])
GO
ALTER TABLE [dbo].[CHITIETHOANTRA] CHECK CONSTRAINT [FK_CHITIETHOANTRA_HOADONTRAHANG]
GO
ALTER TABLE [dbo].[CHITIETHOANTRA]  WITH CHECK ADD  CONSTRAINT [FK_CHITIETHOANTRA_SACH] FOREIGN KEY([MASP])
REFERENCES [dbo].[SACH] ([MASACH])
GO
ALTER TABLE [dbo].[CHITIETHOANTRA] CHECK CONSTRAINT [FK_CHITIETHOANTRA_SACH]
GO
ALTER TABLE [dbo].[CHITIETHOANTRA]  WITH CHECK ADD  CONSTRAINT [FK_CHITIETHOANTRA_VANPHONGPHAM] FOREIGN KEY([MASP])
REFERENCES [dbo].[VANPHONGPHAM] ([MAVPP])
GO
ALTER TABLE [dbo].[CHITIETHOANTRA] CHECK CONSTRAINT [FK_CHITIETHOANTRA_VANPHONGPHAM]
GO
ALTER TABLE [dbo].[HOADON]  WITH CHECK ADD  CONSTRAINT [FK_HOADON_KHACHHANG] FOREIGN KEY([MAKH])
REFERENCES [dbo].[KHACHHANG] ([MAKH])
GO
ALTER TABLE [dbo].[HOADON] CHECK CONSTRAINT [FK_HOADON_KHACHHANG]
GO
ALTER TABLE [dbo].[HOADON]  WITH CHECK ADD  CONSTRAINT [FK_HOADON_NHANVIEN] FOREIGN KEY([MANV])
REFERENCES [dbo].[NHANVIEN] ([MANV])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[HOADON] CHECK CONSTRAINT [FK_HOADON_NHANVIEN]
GO
ALTER TABLE [dbo].[HOADONTRAHANG]  WITH CHECK ADD  CONSTRAINT [FK_HOADONTRAHANG_HOADON] FOREIGN KEY([MAHD])
REFERENCES [dbo].[HOADON] ([MAHOADON])
GO
ALTER TABLE [dbo].[HOADONTRAHANG] CHECK CONSTRAINT [FK_HOADONTRAHANG_HOADON]
GO
ALTER TABLE [dbo].[HOADONTRAHANG]  WITH CHECK ADD  CONSTRAINT [FK_HOADONTRAHANG_KHACHHANG] FOREIGN KEY([MAKH])
REFERENCES [dbo].[KHACHHANG] ([MAKH])
GO
ALTER TABLE [dbo].[HOADONTRAHANG] CHECK CONSTRAINT [FK_HOADONTRAHANG_KHACHHANG]
GO
ALTER TABLE [dbo].[HOADONTRAHANG]  WITH CHECK ADD  CONSTRAINT [FK_HOADONTRAHANG_NHANVIEN] FOREIGN KEY([MANV])
REFERENCES [dbo].[NHANVIEN] ([MANV])
GO
ALTER TABLE [dbo].[HOADONTRAHANG] CHECK CONSTRAINT [FK_HOADONTRAHANG_NHANVIEN]
GO
ALTER TABLE [dbo].[NHANVIEN]  WITH CHECK ADD  CONSTRAINT [FK_NHANVIEN_CHUCVU] FOREIGN KEY([MACHUCVU])
REFERENCES [dbo].[CHUCVU] ([MACHUCVU])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[NHANVIEN] CHECK CONSTRAINT [FK_NHANVIEN_CHUCVU]
GO
ALTER TABLE [dbo].[NHANVIEN]  WITH CHECK ADD  CONSTRAINT [FK_NHANVIEN_HINHANH] FOREIGN KEY([MAANH])
REFERENCES [dbo].[HINHANH] ([MAANH])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[NHANVIEN] CHECK CONSTRAINT [FK_NHANVIEN_HINHANH]
GO
ALTER TABLE [dbo].[SACH]  WITH CHECK ADD  CONSTRAINT [FK_SACH_HINHANH] FOREIGN KEY([MAANH])
REFERENCES [dbo].[HINHANH] ([MAANH])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[SACH] CHECK CONSTRAINT [FK_SACH_HINHANH]
GO
ALTER TABLE [dbo].[SACH]  WITH CHECK ADD  CONSTRAINT [FK_SACH_LOAISACH] FOREIGN KEY([MALOAISACH])
REFERENCES [dbo].[LOAISACH] ([MALOAISACH])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[SACH] CHECK CONSTRAINT [FK_SACH_LOAISACH]
GO
ALTER TABLE [dbo].[SACH]  WITH CHECK ADD  CONSTRAINT [FK_SACH_NHASANXUAT] FOREIGN KEY([MANSX])
REFERENCES [dbo].[NHASANXUAT] ([MANSX])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[SACH] CHECK CONSTRAINT [FK_SACH_NHASANXUAT]
GO
ALTER TABLE [dbo].[TAIKHOAN]  WITH CHECK ADD  CONSTRAINT [FK_TAIKHOAN_NHANVIEN] FOREIGN KEY([MATAIKHOAN])
REFERENCES [dbo].[NHANVIEN] ([MANV])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[TAIKHOAN] CHECK CONSTRAINT [FK_TAIKHOAN_NHANVIEN]
GO
ALTER TABLE [dbo].[VANPHONGPHAM]  WITH CHECK ADD  CONSTRAINT [FK_VANPHONGPHAM_HINHANH] FOREIGN KEY([MAANH])
REFERENCES [dbo].[HINHANH] ([MAANH])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[VANPHONGPHAM] CHECK CONSTRAINT [FK_VANPHONGPHAM_HINHANH]
GO
ALTER TABLE [dbo].[VANPHONGPHAM]  WITH CHECK ADD  CONSTRAINT [FK_VANPHONGPHAM_LOAIVANPHONGPHAM] FOREIGN KEY([MALOAIVPP])
REFERENCES [dbo].[LOAIVANPHONGPHAM] ([MALOAIVPP])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[VANPHONGPHAM] CHECK CONSTRAINT [FK_VANPHONGPHAM_LOAIVANPHONGPHAM]
GO
ALTER TABLE [dbo].[VANPHONGPHAM]  WITH CHECK ADD  CONSTRAINT [FK_VANPHONGPHAM_MAUSAC] FOREIGN KEY([MAMAU])
REFERENCES [dbo].[MAUSAC] ([MAMAU])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[VANPHONGPHAM] CHECK CONSTRAINT [FK_VANPHONGPHAM_MAUSAC]
GO
ALTER TABLE [dbo].[VANPHONGPHAM]  WITH CHECK ADD  CONSTRAINT [FK_VANPHONGPHAM_NHASANXUAT] FOREIGN KEY([MANSX])
REFERENCES [dbo].[NHASANXUAT] ([MANSX])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[VANPHONGPHAM] CHECK CONSTRAINT [FK_VANPHONGPHAM_NHASANXUAT]
GO
