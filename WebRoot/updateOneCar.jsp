<%@ page language="java" import="java.util.*,scu.sw.car.CarsVo" contentType="text/html; charset=gb2312"
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
		<title>���ⵥ����</title>
		<meta charset="gb2312" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
		<link rel="stylesheet" href="css/uniform.css" />
		<link rel="stylesheet" href="css/select2.css" />		
		<link rel="stylesheet" href="css/unicorn.main.css" />
		<link rel="stylesheet" href="css/unicorn.grey.css" class="skin-color" />
		<link rel="stylesheet" href="css/fullcalendar.css" />
		<link rel="stylesheet" href="css/colorpicker.css" />
        <link rel="stylesheet" href="css/datepicker.css" />	
		
		<link rel="stylesheet" href="css/fullcalendar.css" />	
	    <link href='https://fonts.googleapis.com/css?family=Maven+Pro:400,500,700,900' rel='stylesheet' type='text/css'>
	    <link href="/assets/application-c378a238ede22e5e595f45d12363b909.css" media="all" rel="stylesheet" type="text/css" />
	    	
		<script src="https://js.stripe.com/v2/" type="text/javascript"></script>
	    <script src="/assets/application-e812694a9f89b2a8c4f2318ae988950c.js" type="text/javascript"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	</head>
	
	<body>
	<%
		CarsVo vo = (CarsVo)request.getAttribute("vo");
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
				<li><a href="index.html"><i class="icon icon-home"></i> <span>��ҳ</span></a></li>
				
				<li class="submenu active open">
					<a href="addUser.jsp"><i class="icon icon-th-list"></i> <span>�û�����</span> <span class="label">2</span></a>
					<ul>
						<li><a href="addUser.jsp">����û�</a></li>
						<li class="active"><a href="ShowUsersServlet">��ѯ�û�</a></li>
					</ul>
				</li>

				<li class="submenu">
					<a href="addCustomer.jsp"><i class="icon icon-th-list"></i> <span>�ͻ�����</span> <span class="label">2</span></a>
					<ul>
						<li><a href="addCustomer.jsp">��ӿͻ���Ϣ</a></li>
						<li><a href="ShowAllCustomerServlet">��ѯ�ͻ���Ϣ</a></li>
					</ul>
				</li>
				<li class="submenu">
					<a href="addCar.jsp"><i class="icon icon-th-list"></i> <span>��������</span> <span class="label">2</span></a>
					<ul>
						<li><a href="addCar.jsp">���������Ϣ</a></li>
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
				<h1>�޸�������Ϣ</h1>
		</div>
		
		<div id="breadcrumb">
				<a href="index.html" title="�ص���ҳ" class="tip-bottom"><i class="icon-home"></i>��ҳ</a>
				<a href="addCar.jsp" class="tip-bottom">��������</a>
				<a href="ShowUsersServlet" class="tip-bottom">��ѯ����</a>
				<a href="#" title="��ǰҳ" class="current">�޸�����</a>
		</div>
		
		<div class="container-fluid">
		<div class="row-fluid">
			<form name="form" action="<%=basePath%>UpdateOneCarFromJspServlet" method="post" class="form-horizontal" />
				<div class="row-fluid">
					<div class="span12">
						<table class="table table-hover table-bordered">
							<thead>
							<tr>
							<th>
							������
							</th>
							<th>
							����
							</th>
							</tr>
							</thead>
					<tbody>
					<tr>
						<td>
							�������
						</td>
						<td>
							<input type="text" readonly="true" name="id" id="id" value="<%out.print(vo.getId()); %>"/>	
						</td>
					</tr>
					<tr class="success">
						<td>
							�������
						</td>
						<td>
							<input type="text" readonly="true" name="isrenting" id="isrenting"
							value="<%
									if(vo.getIsrenting() == 0) {
										out.print("δ���");
									}
									else {
										out.print("�����");
									}
									%>"
							/>		
						</td>
					</tr>
					<tr class="error">
						<td>
							���ƺ�
						</td>
						<td>
							<input type="text" name="carnumber" id="carnumber" value="<%out.print(vo.getCarnumber()); %>"/>	
						</td>
					</tr>
					<tr class="warning">
						<td>
							�ͺ�
						</td>
						<td>
							<input type="text" name="cartype" id="cartype" value="<%out.print(vo.getCartype()); %>"/>	
						</td>	
					</tr>
					<tr class="info">
						<td>
							��ɫ
						</td>
						<td>
							<input type="text" readonly="true" name="color" id="color" value="<%out.print(vo.getColor()); %>"/>	
						</td>
					</tr>
					<tr>
						<td>
							��ֵ
						</td>
						<td>
							<input type="text" name="price" id="price" value="<%out.print(vo.getPrice()); %>"/>	
						</td>
					</tr>
					<tr class="success">
						<td>
							���
						</td>
						<td>
							<input type="text" name="rentprice" id="rentprice" value="<%out.print(vo.getRentprice()); %>"/>	
						</td>
					</tr>
					<tr class="error">
						<td>
							Ѻ��
						</td>
						<td>
							<input type="text" name="deposit" id="deposit" value="<%out.print(vo.getDeposit()); %>"/>	
						</td>
					</tr>
					<tr class="warning">
						<td>
							���
						</td>
						<td>
							<input type="text" name="description" id="description" value="<%out.print(vo.getDescription()); %>"/>	
						</td>
					</tr>
					
				</tbody>
			 </table>
			 </div>
			</div>	
			<div class="form-actions">
				<button type="submit" data-loading-text="�����ύ..." class="btn btn-success btn-large">&nbsp;&nbsp;�޸� &nbsp;&nbsp;</button>
			</div>			
		</form>
					
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
            <script src="js/jquery.validate.js"></script>
            <script src="js/bootstrap-colorpicker.js"></script>
            <script src="js/bootstrap-datepicker.js"></script>
            <script src="js/unicorn.form_validation.js"></script>
            <script src="js/unicorn.form_common.js"></script>
          	
         </body>
      </html>
        
				
				