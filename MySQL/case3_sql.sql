create database case3;
use case3;
create table users
(
    id       int primary key auto_increment,
    name     varchar(255),
    email    varchar(255) unique,
    phone    varchar(255) unique,
    avatar   varchar(255),
    username varchar(255) unique,
    password varchar(255),
    role     varchar(255)
);


insert into users (name, email, phone, avatar, username, password, role)
values ("DucK Anh",
        "ducanh25062001@gmail.com",
        "0963212083",
        "Image/admin-avatar.jpg",
        "admin",
        "admin",
        "admin"),
       ("Trump",
        "nbtrung@gmail.com",
        "0369636368",
        "Image/trump-avatar.jpg",
        "trump311",
        "123456",
        "librarian");

create table books
(
    id        int primary key auto_increment,
    name      varchar(255),
    avatar    varchar(255),
    describes text,
    status    varchar(255),
    category  varchar(255),
    author    varchar(255)
);

insert into books(name, avatar, describes, status, category, author)
values ("Conan",
        "Image/conan.jpg",
        "Truyện xoay quanh một cậu thám tử trung học có tên là Kudo Shinichi trong lúc đang điều tra một Tổ chức Áo đen bí ẩn đã bị ép phải uống một loại thuốc độc có thể gây chết người. May mắn là đã sống sót nhưng cơ thể thì lại bị teo nhỏ như một đứa bé 6-7 tuổi. Kể từ đó để tránh bị lộ thân phận thực sự của mình, Shinichi đã lấy tên là Edogawa Conan và chuyển đến sống ở nhà của cô bạn thời thơ ấu Mori Ran cùng với cha của cô ấy là một thám tử tư tên Mori Kogoro với hy vọng một ngày nào đó cậu có thể hạ gục Tổ chức Áo Đen và lấy lại hình dáng ban đầu.",
        "Mới",
        "Thần bí, Giật gân",
        "Aoyama Gōshō"),
       ("Doraemon",
        "Image/Doraemon1.jpg",
        "Đôrêmon là một chú mèo máy được Nôbita, cháu ba đời của Nôbita gửi về quá khứ cho ông mình để giúp đỡ Nôbita tiến bộ, tức là cũng sẽ cải thiện hoàn cảnh của con cháu Nôbita sau này",
        "Mới",
        "Hài kịch, Khoa học viễn tưởng",
        "Fujiko Fujio"),
       ("Hành trình về phương đông",
        "Image/hanh_trinh_ve_phuong_dong.jpg",
        "Kể về những trải nghiệm của một đoàn khoa học gồm các chuyên gia hàng đầu của Hội Khoa Học Hoàng Gia Anh được cử sang Ấn Độ nghiên cứu về huyền học và những khả năng siêu nhiên của con người.",
        "Mới",
        "Thám Hiểm, Phương tây, Khác",
        "Dr. Blair Thomas Spalding"),
       ("Đắc Nhân Tâm",
        "Image/Dac_Nhan_tam.png",
        "Quyển sách đưa ra các lời khuyên về cách thức cư xử, ứng xử và giao tiếp với mọi người để đạt được thành công trong cuộc sống",
        "Mới",
        "Sách tự lực",
        "Dale Carnegie"),
       ("Nhà giả kim",
        "Image/nha_gia_kim.jpg",
        "Nhân vật chính trong truyện là Santiago. Cha mẹ Santiago mong muốn cậu trở thành linh mục để mang lại niềm tự hào cho gia đình, nhưng vì ước mơ từ nhỏ của chính mình là đi đây đi đó khắp thế giới, Santigo đã thuyết phục được cha cậu và trở thành một người chăn cừu.",
        "Mới",
        "Tiểu thuyết, Kịch, Nhiệm vụ, Hư cấu kỳ ảo, Tiểu thuyết phiêu lưu",
        "Paulo Coelho"),
       ("Đời thay đổi khi chúng ta thay đổi",
        "Image/Doi_thay_doi_khi_chung_ta_thay_doi.jpg",
        "Quyển sách này nói về việc tại sao có những người dường như lúc nào cũng ở đúng nơi và đúng lúc - và làm thế nào bạn cũng được như họ; tại sao hoá đơn tính tiền luôn luôn tới ngay tức khắc; tại sao đèn giao thông cứ ở màu đỏ hoài cả nửa ngày trong khi bạn đang trễ một cuộc hẹn làm ăn... Sách cũng bàn về việc nhận thức được các quy luật tự nhiên để chúng ta có thể điều chỉnh bản tính chúng ta tốt hơn.",
        "Mới",
        "Tiểu thuyết",
        "Andrew Matthews"),
       ("Những tấm lòng cao cả",
        "Image/Nhung_tam_long_cao_ca.jpg",
        "Tác phẩm được viết theo hình thức nhật ký của Enrico Bottini, một cậu học trò 11 tuổi học tiểu học ở Ý.",
        "Mới",
        "Tiểu thuyết, Hư cấu",
        "Edmondo De Amicis"),
       ("Bố già",
        "Image/bo_gia.jpg",
        "Ông chủ nhà đòn Bonasera ra tòa nghe tuyên án 2 thằng khốn can tội bạo hành, toan cưỡng dâm con gái lão. Chánh tòa tuyên mỗi đứa 3 năm tù cho hưởng án treo. Lão tức giận quyết tìm tới ông Trùm Corleone. Kép Johnny Fontane một thời lừng lẫy nhưng bây giờ xuống dốc, bị vợ sau không coi ra gì nên quyết bay về New York nhờ bố già Corleone. Ông chủ lò bánh Nazorine có cô con gái lỡ yêu và có bầu với người làm công Enzo, 1 tù binh Ý được trưng dụng làm thợ. Ông phải kiếm cách nhập tịch Mỹ cho Enzo nên phải nhờ bố già Corleone.",
        "Mới",
        "Giật gân, Giả tưởng hình sự, tội phạm giả tưởng, Thần bí",
        "Mario Puzo"),
       ("Jane Eyre",
        "Image/JaneEyre.jpg",
        "Cuốn tiểu thuyết là một câu chuyện kể ngôi thứ nhất từ góc nhìn của nhân vật chính. Bối cảnh của cuốn tiểu thuyết là một nơi nào đó ở miền bắc nước Anh, vào cuối triều đại của George III (1760–1820)",
        "Mới",
        "Tiểu thuyết, Tiểu thuyết lãng mạn, Hư cấu Gothic, Tiểu thuyết giáo dục, Tiểu thuyết tự truyện",
        "Charlotte Brontë"),
       ("Đọc vị bất kỳ ai",
        "Image/doc-vi-bat-ky-ai.jpg",
        " lựa chọn cuốn sách này với lí do muốn tìm hiểu về tâm lý con người và nó hay hơn mình mong đợi rất là nhiều. Những trích dẫn trong sách rất rõ ràng và chi tiết, Tác giả là một người có vốn hiểu biết phong phú. Rất nhiều tình huống lấy từ thực tế được lồng ghép vào cuốn sách làm dẫn chứng tăng thêm tính tin cậy và độ chính xác.",
        "Mới",
        "Tiểu thuyết",
        "David J.Lieberman"),
       (" 7 thói quen để thành đạt",
        "Image/7-thoi-quen-de-thanh-dat.jpg",
        "Trong cuốn sách, Covey thảo luận tìm cách giúp thanh thiếu niên có thể trở nên tự lập và làm việc có hiệu quả hơn thông qua bảy thói quen cơ bản.[6] Các thói quen tốt được định nghĩa là sự chủ động trong mọi khía cạnh của cuộc sống từ  lập kế hoạch và ưu tiên những việc quan trọng trong cuộc sống hàng ngày và sống có trách nhiệm",
        "Mới",
        "Sách tự lực",
        "Sean Covey");

 create table customer (
 id int primary key auto_increment,
 name varchar(255),
 className varchar(255),
 address varchar(255),
 dateOfBirth date
 );

 insert into customer (name, className, address, dateOfBirth)
 values("Dlinh","11a5","31 Nguyễn Ngọc Vũ","2003-02-17"),
 ("Nam","C0823H1","Hà Nội","2002-02-02"),
 ("Ngô Đức Thắng","12a1","030 Vũ Văn Mật","2002-10-10"),
 ("Nguyễn Việt Thái","10a3","027 Tôn Thất Thuyết","2004-01-09"),
 ("Nguyễn Việt Hoàn","10a3","031 Cầu Gồ","2004-10-26");
 
 
 create table orders(
 id int primary key auto_increment,
 customer_id int,
 books_id int,
 foreign key (customer_id) references customer(id),
 foreign key (books_id) references books(id)
 );
 
 create table orderDetail(
 orders_id int,
 books_id int,
 foreign key (orders_id) references orders(id),
 foreign key (books_id) references books(id),
borroweDay DATETIME DEFAULT CURRENT_TIMESTAMP,
payDay date
 );
SELECT day(borroweDay) from orderDetail;
insert into orders(customer_id,books_id)
values(1,5),
(2,11),
(3,4),
(5,9),
(5,3),
(2,8);

insert into orderDetail(orders_id,books_id,payDay)
values(2,5,"2023-12-15");

select o.id, c.name, b.name from orders o
join customer c on o.customer_id=c.id
join books b on o.books_id=b.id

