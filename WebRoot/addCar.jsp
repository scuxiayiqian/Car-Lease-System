<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
		<title>���������Ϣ</title>
		<meta charset="gb2312" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
		<link rel="stylesheet" href="css/fullcalendar.css" />	
		<link rel="stylesheet" href="css/unicorn.main.css" />
		<link rel="stylesheet" href="css/unicorn.grey.css" class="skin-color" />
	    <link href='https://fonts.googleapis.com/css?family=Maven+Pro:400,500,700,900' rel='stylesheet' type='text/css'>
	    <link href="/assets/application-c378a238ede22e5e595f45d12363b909.css" media="all" rel="stylesheet" type="text/css" />
	    <script src="https://js.stripe.com/v2/" type="text/javascript"></script>
	    <script src="/assets/application-e812694a9f89b2a8c4f2318ae988950c.js" type="text/javascript"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	</head>
	
	<body>
	<div id="header">
			<h1><a href="./dashboard.html">Unicorn Admin</a></h1>		
		</div>
		
		<div id="search">
			<input type="text" placeholder="Search here..." /><button type="submit" class="tip-right" title="Search"><i class="icon-search icon-white"></i></button>
		</div>
		<div id="user-nav" class="navbar navbar-inverse">
            <ul class="nav btn-group">
                <li class="btn btn-inverse"><a title="" href="#"><i class="icon icon-user"></i> <span class="text">��</span></a></li>
                <li class="btn btn-inverse dropdown" id="menu-messages"><a href="#" data-toggle="dropdown" data-target="#menu-messages" class="dropdown-toggle"><i class="icon icon-envelope"></i> <span class="text">����Ϣ</span> <span class="label label-important">5</span> <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a class="sAdd" title="" href="#">����Ϣ</a></li>
                        <li><a class="sInbox" title="" href="#">�ռ���</a></li>
                        <li><a class="sOutbox" title="" href="#">������</a></li>
                        <li><a class="sTrash" title="" href="#">������</a></li>
                    </ul>
                </li>
                <li class="btn btn-inverse"><a title="" href="#"><i class="icon icon-cog"></i> <span class="text">����</span></a></li>
                <li class="btn btn-inverse"><a title="" href="login.html"><i class="icon icon-share-alt"></i> <span class="text">�˳�ϵͳ</span></a></li>
            </ul>
        </div>
            
		<div id="sidebar">
			
			<ul>
				<li><a href="index.html"><i class="icon icon-home"></i><span>��ҳ</span></a></li>
				
				<li class="submenu">
					<a href="addUser.jsp"><i class="icon icon-th-list"></i> <span>�û�����</span> <span class="label">2</span></a>
					<ul>
						<li><a href="addUser.jsp">����û�</a></li>
						<li><a href="ShowUsersServlet">��ѯ�û�</a></li>
					</ul>
				</li>

				<li class="submenu">
					<a href="addCustomer.jsp"><i class="icon icon-th-list"></i> <span>�ͻ�����</span> <span class="label">2</span></a>
					<ul>
						<li><a href="addCustomer.jsp">��ӿͻ���Ϣ</a></li>
						<li><a href="ShowAllCustomerServlet">��ѯ�ͻ���Ϣ</a></li>
					</ul>
				</li>
				<li class="submenu active open">
					<a href="addCar.jsp"><i class="icon icon-th-list"></i> <span>��������</span> <span class="label">2</span></a>
					<ul>
						<li class="active"><a href="addCar.jsp">���������Ϣ</a></li>
						<li><a href="ShowCarsServlet">��ѯ������Ϣ</a></li>
					</ul>
				</li>
				<li class="submenu">
					<a href="#"><i class="icon icon-th-list"></i> <span>ҵ�����</span> <span class="label">4</span></a>
					<ul>
						<li><a href="business_carRent_inputIdNum.jsp">��������</a></li>
						<li><a href="business_carReturn_inputIdNum.jsp">�������</a></li>
						<li><a href="ShowAllRentRecordServlet">���ⵥ����</a></li>
						<li><a href="ShowAllCheckRecordServlet">��鵥����</a></li>
					</ul>
				</li>
				<li class="submenu">
					<a href="#"><i class="icon icon-th-list"></i> <span>ҵ��ͳ��</span> <span class="label">1</span></a>
					<ul>
						<li><a href="SearchReturnWithinOneMonthServlet">����Ӧ������</a></li>
					</ul>
				</li>
			</ul>
		</div>
	
		<div id="content">
			<div id="content-header">
				<h1>���������Ϣ</h1>
		</div>
		
		<div id="breadcrumb">
				<a href="index.html" title="�ص���ҳ" class="tip-bottom"><i class="icon-home"></i>��ҳ</a>
				<a href="addCar.jsp" class="tip-bottom">��������</a>
				<a href="addCar.jsp" title="��ǰҳ" class="current">���������Ϣ</a>
		</div>
		
		<div class="container-fluid">
				<div class="row-fluid">
					<div class="span12">
						<div class="widget-box">
							<div class="widget-title">
								<span class="icon">
									<i class="icon-align-justify"></i>									
								</span>
								<h5>����д���µ�������Ϣ��</h5>
							</div>
							<div class="widget-content nopadding">
								<form name="form" action="<%=basePath%>AddCarServlet" method="post" class="form-horizontal" />
									<div class="control-group">
										<label class="control-label">����</label>
										<div class="controls">
											<input type="text" name="carnumber" id="carnumber"/>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">�ͺ�</label>
										<div class="controls">
											<input type="text" name="cartype" id="cartype"/>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">��ɫ</label>
										<div class="controls">
											<input type="text" name="color" id="color"/>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">��ֵ</label>
										<div class="controls">
											<input type="text" name="price" id="price"/>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">���</label>
										<div class="controls">
											<input type="text" name="rentprice" id="rentprice"/>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">Ѻ��</label>
										<div class="controls">
											<input type="text" name="deposit" id="deposit"/>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">�������</label>
										<div class="controls">
											<label><input type="radio" name="isrenting" value="0"/>δ����</label>
											<label><input type="radio" name="isrenting" value="1"/>�ѳ���</label>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">���</label>
										<div class="controls">
											<textarea name="description"></textarea>
										</div>
									</div>
									<div class="form-actions">
										<button type="submit" data-loading-text="�����ύ..." class="btn btn-success btn-large">&nbsp;&nbsp;�ύ &nbsp;&nbsp;</button>
									</div>
								</form>
							</div>
						</div>						
					</div>
				</div>
				
	
					</div>
				</div>
	
			<script src="js/excanvas.min.js"></script>
            <script src="js/jquery.min.js"></script>
            <script src="js/jquery.ui.custom.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script src="js/jquery.flot.min.js"></script>
            <script src="js/jquery.flot.resize.min.js"></script>
            <script src="js/jquery.peity.min.js"></script>
            <script src="js/fullcalendar.min.js"></script>
            <script src="js/unicorn.js"></script>
            <script src="js/unicorn.dashboard.js"></script>
	</body>
</html>