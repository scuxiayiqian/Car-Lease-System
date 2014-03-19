<%@ page language="java" import="java.lang.*,scu.sw.business.RentTablesVo,java.sql.Date" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
	<title>汽车出租</title>
	<meta charset="gb2312" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
		<link rel="stylesheet" href="css/unicorn.main.css" />
		<link rel="stylesheet" href="css/unicorn.grey.css" class="skin-color" />

		<link rel="stylesheet" href="css/uniform.css" />
		<link rel="stylesheet" href="css/select2.css" />
		
		
		<link href='https://fonts.googleapis.com/css?family=Maven+Pro:400,500,700,900' rel='stylesheet' type='text/css'>
	    <link href="/assets/application-c378a238ede22e5e595f45d12363b909.css" media="all" rel="stylesheet" type="text/css" />
	    <script src="https://js.stripe.com/v2/" type="text/javascript"></script>
	    <script src="/assets/application-e812694a9f89b2a8c4f2318ae988950c.js" type="text/javascript"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
</head>

<body>
<%
RentTablesVo rentTableVo = (RentTablesVo)request.getAttribute("rentTableVo");
String tableid = rentTableVo.getTableid();
double imprest = rentTableVo.getImprest();
double shouldpayprice = rentTableVo.getShouldpayprice();
double price = rentTableVo.getPrice();
Date begindate = rentTableVo.getBegindate();
Date shouldrutumdate = rentTableVo.getShouldretumdate();
int rentflag = rentTableVo.getRentflag();
int cusrid = rentTableVo.getCusrid();
int carsid = rentTableVo.getCarsid();
int userid = rentTableVo.getUserid();
%>

	<div id="header">
			<h1><a href="./dashboard.html">Unicorn Admin</a></h1>		
		</div>
		
		<div id="search">
			<input type="text" placeholder="Search here..." /><button type="submit" class="tip-right" title="Search"><i class="icon-search icon-white"></i></button>
		</div>
		<div id="user-nav" class="navbar navbar-inverse">
            <ul class="nav btn-group">
                <li class="btn btn-inverse"><a title="" href="#"><i class="icon icon-user"></i> <span class="text">Profile</span></a></li>
                <li class="btn btn-inverse dropdown" id="menu-messages"><a href="#" data-toggle="dropdown" data-target="#menu-messages" class="dropdown-toggle"><i class="icon icon-envelope"></i> <span class="text">Messages</span> <span class="label label-important">5</span> <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a class="sAdd" title="" href="#">new message</a></li>
                        <li><a class="sInbox" title="" href="#">inbox</a></li>
                        <li><a class="sOutbox" title="" href="#">outbox</a></li>
                        <li><a class="sTrash" title="" href="#">trash</a></li>
                    </ul>
                </li>
                <li class="btn btn-inverse"><a title="" href="#"><i class="icon icon-cog"></i> <span class="text">Settings</span></a></li>
                <li class="btn btn-inverse"><a title="" href="login.html"><i class="icon icon-share-alt"></i> <span class="text">Logout</span></a></li>
            </ul>
        </div>
            
		<div id="sidebar">
			<a href="#" class="visible-phone"><i class="icon icon-home"></i> Dashboard</a>
			<ul>
				<li><a href="index.html"><i class="icon icon-home"></i><span>首页</span></a></li>
				<li class="submenu">
					<a href="addUser.jsp"><i class="icon icon-th-list"></i> <span>用户管理</span> <span class="label">2</span></a>
					<ul>
						<li><a href="addUser.jsp">添加用户</a></li>
						<li><a href="ShowUsersServlet">查询用户</a></li>
					</ul>
				</li>
				<li class="submenu">
					<a href="addCustomer.jsp"><i class="icon icon-th-list"></i> <span>客户管理</span> <span class="label">2</span></a>
					<ul>
						<li><a href="addCustomer.jsp">添加客户信息</a></li>
						<li><a href="ShowAllCustomerServlet">查询客户信息</a></li>
					</ul>
				</li>
				<li class="submenu">
					<a href="addCar.jsp"><i class="icon icon-th-list"></i> <span>汽车管理</span> <span class="label">2</span></a>
					<ul>
						<li><a href="addCar.jsp">添加汽车信息</a></li>
						<li><a href="ShowCarsServlet">查询汽车信息</a></li>
					</ul>
				</li>
				<li class="submenu active open">
					<a href="#"><i class="icon icon-th-list"></i> <span>业务管理</span> <span class="label">4</span></a>
					<ul>
						<li class="active"><a href="business_carRent_inputIdNum.jsp">汽车出租</a></li>
						<li><a href="business_carReturn_inputIdNum.jsp">汽车入库</a></li>
						<li><a href="ShowAllRentRecordServlet">出租单管理</a></li>
						<li><a href="ShowAllCheckRecordServlet">检查单管理</a></li>
					</ul>
				</li>
				<li class="submenu">
					<a href="#"><i class="icon icon-th-list"></i> <span>业务统计</span> <span class="label">1</span></a>
					<ul>
						<li><a href="SearchReturnWithinOneMonthServlet">当月应还汽车</a></li>
					</ul>
				</li>
		</div>
		
		<div id="style-switcher">
			<i class="icon-arrow-left icon-white"></i>
			<span>Style:</span>
			<a href="#grey" style="background-color: #555555;border-color: #aaaaaa;"></a>
			<a href="#blue" style="background-color: #2D2F57;"></a>
			<a href="#red" style="background-color: #673232;"></a>
		</div>
		
		<div id="content">
			<div id="content-header">
				<h1>汽车出租</h1>
				
			</div>
			<div id="breadcrumb">
				<a href="index.html" title="回到首页" class="tip-bottom"><i class="icon-home"></i>首页</a>
				<a href="business_carRent_inputIdNum.jsp" class="tip-bottom">业务管理</a>
				<a href="business_carRent_inputIdNum.jsp" title="当前页" class="current">汽车出租</a>
			</div>
			
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="span12">
						<div class="alert alert-success">
							<button class="close" data-dismiss="alert">×</button>
							<strong>租车成功！以下是详细租车信息：</strong> .
						</div>
					</div>	
				</div>
			</div>
			
			
			
			<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<table class="table table-hover table-bordered">
				<thead>
					<tr>
						<th>
							表列名
						</th>
						<th>
							提交信息
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							出租单编号
						</td>
						<td>
							<%out.print(tableid); %>
						</td>
					</tr>
					<tr class="success">
						<td>
							预付金额
						</td>
						<td>
							<%out.print(imprest); %>
						</td>
					</tr>
					<tr class="error">
						<td>
							应付金额
						</td>
						<td>
							<%out.print(shouldpayprice); %>
						</td>
					</tr>
					<tr class="warning">
						<td>
							实际交付金额
						</td>
						<td>
							<%out.print(price); %>
						</td>	
					</tr>
					<tr class="info">
						<td>
							起租日期
						</td>
						<td>
							<%out.print(begindate.toString()); %>
						</td>
					</tr>
					<tr>
						<td>
							应归还日期
						</td>
						<td>
							<%out.print(shouldrutumdate.toString()); %>
						</td>
					</tr>
					<tr class="success">
						<td>
							出租单状态
						</td>
						<td>
							<%out.print("出租成功"); %>
						</td>
					</tr>
					<tr class="error">
						<td>
							客户号
						</td>
						<td>
							<%out.print(cusrid); %>
						</td>
					</tr>
					<tr class="warning">
						<td>
							车号
						</td>
						<td>
							<%out.print(carsid); %>
						</td>	
					</tr>
					<tr class="info">
						<td>
							服务人员编号
						</td>
						<td>
							<%out.print(userid); %>
						</td>
					</tr>
				</tbody>
			</table>
			 
		</div>
	</div>
</div>
			
			
			
			
		</div>
		    
            <script src="js/jquery.min.js"></script>
            <script src="js/jquery.ui.custom.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script src="js/jquery.uniform.js"></script>
            <script src="js/select2.min.js"></script>
            <script src="js/jquery.validate.js"></script>
            <script src="js/unicorn.js"></script>
            <script src="js/unicorn.form_validation.js"></script>
</body>

</html>
