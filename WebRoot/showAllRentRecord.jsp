<%@ page language="java" import="java.util.*,scu.sw.business.RentTablesVo" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<%@page import="scu.sw.customers.customersVo"%>
<%@page import="scu.sw.car.CarsVo"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int i;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="zh">
	<head>
		<title>出租单管理</title>
		<meta charset="gb2312" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
		<link rel="stylesheet" href="css/uniform.css" />
		<link rel="stylesheet" href="css/select2.css" />		
		<link rel="stylesheet" href="css/unicorn.main.css" />
		<link rel="stylesheet" href="css/unicorn.grey.css" class="skin-color" />
		<link rel="stylesheet" href="css/fullcalendar.css" />
		
		<link rel="stylesheet" href="css/fullcalendar.css" />	
	    <link href='https://fonts.googleapis.com/css?family=Maven+Pro:400,500,700,900' rel='stylesheet' type='text/css'>
	    <link href="/assets/application-c378a238ede22e5e595f45d12363b909.css" media="all" rel="stylesheet" type="text/css" />
	    	
		<script src="https://js.stripe.com/v2/" type="text/javascript"></script>
	    <script src="/assets/application-e812694a9f89b2a8c4f2318ae988950c.js" type="text/javascript"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	</head>
	
	<body>
	<%
		ArrayList<RentTablesVo> rentList = (ArrayList<RentTablesVo>)request.getAttribute("rentRecord");
	//	String identity = (String)request.getAttribute("identity");
	 %>
	<div id="header"><div align="left"> 
			</div><h1 align="left"><a href="./dashboard.html">Unicorn Admin</a></h1>		
		</div>
		
		<div id="search">
			<input type="text" placeholder="Search here..." /><button type="submit" class="tip-right" title="Search"><i class="icon-search icon-white"></i></button>
		</div>
		<div id="user-nav" class="navbar navbar-inverse">
            <ul class="nav btn-group">
                <li class="btn btn-inverse"><a title="" href="#"><i class="icon icon-user"></i> <span class="text">我</span></a></li>
                <li class="btn btn-inverse dropdown" id="menu-messages"><a href="#" data-toggle="dropdown" data-target="#menu-messages" class="dropdown-toggle"><i class="icon icon-envelope"></i> <span class="text">新消息</span> <span class="label label-important">5</span> <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a class="sAdd" title="" href="#">新消息</a></li>
                        <li><a class="sInbox" title="" href="#">收件箱</a></li>
                        <li><a class="sOutbox" title="" href="#">发件箱</a></li>
                        <li><a class="sTrash" title="" href="#">垃圾箱</a></li>
                    </ul>
                </li>
                <li class="btn btn-inverse"><a title="" href="#"><i class="icon icon-cog"></i> <span class="text">设置</span></a></li>
                <li class="btn btn-inverse"><a title="" href="login.html"><i class="icon icon-share-alt"></i> <span class="text">退出系统</span></a></li>
            </ul>
        </div>
            
		<div id="sidebar">
			
			<ul>
				<li><a href="index.html"><i class="icon icon-home"></i> <span>首页</span></a></li>
				
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
						<li><a href="business_carRent_inputIdNum.jsp">汽车出租</a></li>
						<li><a href="business_carReturn_inputIdNum.jsp">汽车入库</a></li>
						<li class="active"><a href="ShowAllRentRecordServlet">出租单管理</a></li>
						<li><a href="ShowAllCheckRecordServlet">检查单管理</a></li>
					</ul>
				</li>
				<li class="submenu">
					<a href="#"><i class="icon icon-th-list"></i> <span>业务统计</span> <span class="label">1</span></a>
					<ul>
						<li><a href="SearchReturnWithinOneMonthServlet">当月应还汽车</a></li>
					</ul>
				</li>
			</ul>
		</div>
		
		<div id="content">
			<div id="content-header">
				<h1>出租单管理</h1>
		</div>
		
		<div id="breadcrumb">
				<a href="index.html" title="回到首页" class="tip-bottom"><i class="icon-home"></i>首页</a>
				<a href="#" class="tip-bottom">业务管理</a>
				<a href="ShowAllRentRecordServlet" title="当前页" class="current">出租单管理</a>
		</div>
		
		<div class="container-fluid">
				
		
				<div class="row-fluid">
					<div class="span12">
						<div class="widget-box">
							<div class="widget-title">
							<h5>出租单管理（未入库列表）</h5>
							</div>
							<div class="widget-content nopadding">
							
							<!-- 
							out.println("<td><a href=\"" + basePath + "QueryBySortServlet?ClassName=" + clist.getNewClassName() + "\">删除</a></td>");
							<a href="ShowCarsServlet?id="+rentList.get(i).getId() title="当前页" class="btn ">归还入库</a>
							 -->
							 
								<table class="table table-bordered data-table">
									<thead>
									<tr>
									<th>出租单编号</th>
									<th>出租单状态</th>
									<th>客户号</th>
									<th>车号</th>
									<th>出租单编号</th>
									<th>应付金额</th>
									<th>实际交付金额</th>
									<th>应归还日期</th>
									<th>服务人员编号</th>		
									<th>操作</th>
									</tr>
									</thead>
									<tbody>

									<%		
									for(i=0;i<rentList.size();i++)
									{
										out.println("<tr class=\"gradeX\">");
											out.println("<td>" + rentList.get(i).getId() + "</td>");
											out.println("<td>" + "出租中" + "</td>");
											out.println("<td>" + rentList.get(i).getCusrid() + "</td>");
											out.println("<td>" + rentList.get(i).getCarsid() + "</td>");
											out.println("<td>" + rentList.get(i).getTableid() + "</td>");
											out.println("<td>" + rentList.get(i).getShouldpayprice() + "</td>");
											out.println("<td>" + rentList.get(i).getPrice() + "</td>");
											out.println("<td>" + rentList.get(i).getShouldretumdate() + "</td>");
											out.println("<td>" + rentList.get(i).getUserid() + "</td>");
											
											out.println("<td><a href=\"ShowRentTableServlet?id="+rentList.get(i).getId()+"\" title=\"查看出租单\" class=\"btn btn-success \">查看</a> <a href=\"UpdateRentTableServlet?id="+rentList.get(i).getId()+"\" title=\"修改出租单\" class=\"btn btn-primary \">修改</a> <a href=\"DeleteRentTableServlet?id="+rentList.get(i).getId()+"\" title=\"删除出租单\" class=\"btn btn-danger \">删除</a></td>");
											
										out.println("</tr>");
									}
																
									 %>
									</tbody>
									</table>  
						</div>
					</div>
				</div>
				 </div></div></div>
				
				
            <script src="js/jquery.min.js"></script>
            <script src="js/jquery.ui.custom.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script src="js/jquery.uniform.js"></script>
            <script src="js/select2.min.js"></script>
            <script src="js/jquery.dataTables.min.js"></script>
            <script src="js/unicorn.js"></script>
            <script src="js/unicorn.tables.js"></script>     
          	<script src="js/bootstrap.min.js"></script>
          	
         </body>
      </html>
        
				
				