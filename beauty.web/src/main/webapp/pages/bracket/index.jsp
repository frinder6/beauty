<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<jsp:include page="import-css.jsp" />
<title>首页</title>
</head>
<body class="leftpanel-collapsed stickyheader">

	<!-- Preloader -->
	<div id="preloader">
		<div id="status">
			<i class="fa fa-spinner fa-spin"></i>
		</div>
	</div>

	<section>

		<div class="leftpanel sticky-leftpanel">

			<div class="logopanel">
				<h1>
					<span>[</span> 我的后台 <span>]</span>
				</h1>
			</div>
			<!-- logopanel -->

			<div class="leftpanelinner">

				<!-- This is only visible to small devices -->
				<div class="visible-xs hidden-sm hidden-md hidden-lg">
					<div class="media userlogged">
						<img alt="" src="${basePath }/resources/bracket/images/photos/loggeduser.png" class="media-object">
						<div class="media-body">
							<h4>John Doe</h4>
							<span>"Life is so..."</span>
						</div>
					</div>

					<h5 class="sidebartitle actitle">Account</h5>
					<ul class="nav nav-pills nav-stacked nav-bracket mb30">
						<li><a href="profile.html"><i class="fa fa-user"></i> <span>Profile</span></a></li>
						<li><a href=""><i class="fa fa-cog"></i> <span>Account Settings</span></a></li>
						<li><a href=""><i class="fa fa-question-circle"></i> <span>Help</span></a></li>
						<li><a href="signout.html"><i class="fa fa-sign-out"></i> <span>Sign Out</span></a></li>
					</ul>
				</div>

				<h5 class="sidebartitle">Navigation</h5>
				<ul class="nav nav-pills nav-stacked nav-bracket">
					<li class="active"><a href="index.html"><i class="fa fa-home"></i> <span>Dashboard</span></a></li>
					<li><a href="email.html"><span class="pull-right badge badge-success">2</span><i class="fa fa-envelope-o"></i> <span>Email</span></a></li>
					<li class="nav-parent"><a href=""><i class="fa fa-edit"></i> <span>Forms</span></a>
						<ul class="children">
							<li><a href="general-forms.html"><i class="fa fa-caret-right"></i> General Forms</a></li>
							<li><a href="form-layouts.html"><i class="fa fa-caret-right"></i> Form Layouts</a></li>
							<li><a href="form-validation.html"><i class="fa fa-caret-right"></i> Form Validation</a></li>
							<li><a href="form-wizards.html"><i class="fa fa-caret-right"></i> Form Wizards</a></li>
							<li><a href="wysiwyg.html"><i class="fa fa-caret-right"></i> Text Editor</a></li>
							<li><a href="code-editor.html"><i class="fa fa-caret-right"></i> Code Editor</a></li>
							<li><a href="x-editable.html"><i class="fa fa-caret-right"></i> X-Editable</a></li>
						</ul></li>
					<li class="nav-parent"><a href=""><i class="fa fa-suitcase"></i> <span>UI Elements</span></a>
						<ul class="children">
							<li><a href="buttons.html"><i class="fa fa-caret-right"></i> Buttons</a></li>
							<li><a href="icons.html"><span class="pull-right badge badge-danger">updated</span><i class="fa fa-caret-right"></i> Icons</a></li>
							<li><a href="typography.html"><i class="fa fa-caret-right"></i> Typography</a></li>
							<li><a href="alerts.html"><i class="fa fa-caret-right"></i> Alerts &amp; Notifications</a></li>
							<li><a href="modals.html"><i class="fa fa-caret-right"></i> Modals</a></li>
							<li><a href="tabs-accordions.html"><i class="fa fa-caret-right"></i> Tabs &amp; Accordions</a></li>
							<li><a href="sliders.html"><i class="fa fa-caret-right"></i> Sliders</a></li>
							<li><a href="graphs.html"><i class="fa fa-caret-right"></i> Graphs &amp; Charts</a></li>
							<li><a href="widgets.html"><i class="fa fa-caret-right"></i> Panels &amp; Widgets</a></li>
							<li><a href="extras.html"><i class="fa fa-caret-right"></i> Extras</a></li>
						</ul></li>
					<li><a href="tables.html"><i class="fa fa-th-list"></i> <span>Tables</span></a></li>
					<li class="nav-parent"><a href=""><i class="fa fa-bug"></i> <span>Bug Tracker</span></a>
						<ul class="children">
							<li><a href="bug-tracker.html"><i class="fa fa-caret-right"></i> Summary</a></li>
							<li><a href="bug-issues.html"><i class="fa fa-caret-right"></i> Issues</a></li>
							<li><a href="view-issue.html"><i class="fa fa-caret-right"></i> View Issue</a></li>
						</ul></li>
					<li><a href="maps.html"><i class="fa fa-map-marker"></i> <span>Maps</span></a></li>
					<li class="nav-parent"><a href=""><i class="fa fa-file-text"></i> <span>Pages</span></a>
						<ul class="children">
							<li><a href="calendar.html"><i class="fa fa-caret-right"></i> Calendar</a></li>
							<li><a href="media-manager.html"><i class="fa fa-caret-right"></i> Media Manager</a></li>
							<li><a href="timeline.html"><i class="fa fa-caret-right"></i> Timeline</a></li>
							<li><a href="blog-list.html"><i class="fa fa-caret-right"></i> Blog List</a></li>
							<li><a href="blog-single.html"><i class="fa fa-caret-right"></i> Blog Single</a></li>
							<li><a href="people-directory.html"><i class="fa fa-caret-right"></i> People Directory</a></li>
							<li><a href="profile.html"><i class="fa fa-caret-right"></i> Profile</a></li>
							<li><a href="invoice.html"><i class="fa fa-caret-right"></i> Invoice</a></li>
							<li><a href="search-results.html"><i class="fa fa-caret-right"></i> Search Results</a></li>
							<li><a href="blank.html"><i class="fa fa-caret-right"></i> Blank Page</a></li>
							<li><a href="notfound.html"><i class="fa fa-caret-right"></i> 404 Page</a></li>
							<li><a href="locked.html"><i class="fa fa-caret-right"></i> Locked Screen</a></li>
							<li><a href="signin.html"><i class="fa fa-caret-right"></i> Sign In</a></li>
							<li><a href="signup.html"><i class="fa fa-caret-right"></i> Sign Up</a></li>
						</ul></li>
					<li class="nav-parent"><a href="layouts.html"><i class="fa fa-laptop"></i> <span>Skins &amp; Layouts</span></a>
						<ul class="children">
							<li><a href="layouts.html"><i class="fa fa-caret-right"></i> General Layouts</a></li>
							<li><a href="horizontal-menu.html"><i class="fa fa-caret-right"></i> Top Menu</a></li>
							<li><a href="horizontal-menu2.html"><i class="fa fa-caret-right"></i> Top Menu w/ Sidebar</a></li>
							<li><a href="fixed-width.html"><i class="fa fa-caret-right"></i> Fixed Width Page</a></li>
							<li><a href="fixed-width2.html"><i class="fa fa-caret-right"></i> Fixed Width w/ Menu</a></li>
						</ul></li>
				</ul>

				<div class="infosummary">
					<h5 class="sidebartitle">Information Summary</h5>
					<ul>
						<li>
							<div class="datainfo">
								<span class="text-muted">Daily Traffic</span>
								<h4>630, 201</h4>
							</div>
							<div id="sidebar-chart" class="chart"></div>
						</li>
						<li>
							<div class="datainfo">
								<span class="text-muted">Average Users</span>
								<h4>1, 332, 801</h4>
							</div>
							<div id="sidebar-chart2" class="chart"></div>
						</li>
						<li>
							<div class="datainfo">
								<span class="text-muted">Disk Usage</span>
								<h4>82.2%</h4>
							</div>
							<div id="sidebar-chart3" class="chart"></div>
						</li>
						<li>
							<div class="datainfo">
								<span class="text-muted">CPU Usage</span>
								<h4>140.05 - 32</h4>
							</div>
							<div id="sidebar-chart4" class="chart"></div>
						</li>
						<li>
							<div class="datainfo">
								<span class="text-muted">Memory Usage</span>
								<h4>32.2%</h4>
							</div>
							<div id="sidebar-chart5" class="chart"></div>
						</li>
					</ul>
				</div>
				<!-- infosummary -->

			</div>
			<!-- leftpanelinner -->
		</div>
		<!-- leftpanel -->

		<div class="mainpanel">

			<div class="headerbar">

				<!-- 折叠按钮 -->
				<a class="menutoggle"><i class="fa fa-bars"></i></a>

				<div class="header-right">
					<ul class="headermenu">
						<li>
							<div class="btn-group">
								<button class="btn btn-default dropdown-toggle tp-icon" data-toggle="dropdown">
									<i class="glyphicon glyphicon-user"></i> <span class="badge">2</span>
								</button>
								<div class="dropdown-menu dropdown-menu-head pull-right">
									<h5 class="title">2 Newly Registered Users</h5>
									<ul class="dropdown-list user-list">
										<li class="new">
											<div class="thumb">
												<a href=""><img src="${basePath }/resources/bracket/images/photos/user1.png" alt="" /></a>
											</div>
											<div class="desc">
												<h5>
													<a href="">Draniem Daamul (@draniem)</a> <span class="badge badge-success">new</span>
												</h5>
											</div>
										</li>
										<li class="new">
											<div class="thumb">
												<a href=""><img src="${basePath }/resources/bracket/images/photos/user2.png" alt="" /></a>
											</div>
											<div class="desc">
												<h5>
													<a href="">Zaham Sindilmaca (@zaham)</a> <span class="badge badge-success">new</span>
												</h5>
											</div>
										</li>
										<li>
											<div class="thumb">
												<a href=""><img src="${basePath }/resources/bracket/images/photos/user3.png" alt="" /></a>
											</div>
											<div class="desc">
												<h5>
													<a href="">Weno Carasbong (@wenocar)</a>
												</h5>
											</div>
										</li>
										<li>
											<div class="thumb">
												<a href=""><img src="${basePath }/resources/bracket/images/photos/user4.png" alt="" /></a>
											</div>
											<div class="desc">
												<h5>
													<a href="">Nusja Nawancali (@nusja)</a>
												</h5>
											</div>
										</li>
										<li>
											<div class="thumb">
												<a href=""><img src="${basePath }/resources/bracket/images/photos/user5.png" alt="" /></a>
											</div>
											<div class="desc">
												<h5>
													<a href="">Lane Kitmari (@lane_kitmare)</a>
												</h5>
											</div>
										</li>
										<li class="new"><a href="">See All Users</a></li>
									</ul>
								</div>
							</div>
						</li>
						<li>
							<div class="btn-group">
								<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
									<img src="${basePath }/resources/bracket/images/photos/loggeduser.png" alt="" /> John Doe <span class="caret"></span>
								</button>
								<ul class="dropdown-menu dropdown-menu-usermenu pull-right">
									<li><a href="profile.html"><i class="glyphicon glyphicon-user"></i> My Profile</a></li>
									<li><a href="#"><i class="glyphicon glyphicon-cog"></i> Account Settings</a></li>
									<li><a href="#"><i class="glyphicon glyphicon-question-sign"></i> Help</a></li>
									<li><a href="signin.html"><i class="glyphicon glyphicon-log-out"></i> Log Out</a></li>
								</ul>
							</div>
						</li>
					</ul>
				</div>
				<!-- header-right -->

			</div>
			<!-- headerbar -->

			<div class="pageheader">
				<h2>
					<i class="fa fa-home"></i> Dashboard <span>Subtitle goes here...</span>
				</h2>
				<div class="breadcrumb-wrapper">
					<span class="label">You are here:</span>
					<ol class="breadcrumb">
						<li><a href="index.html">Bracket</a></li>
						<li class="active">Dashboard</li>
					</ol>
				</div>
			</div>

			<div class="contentpanel" style="height: 90%;padding: 10px;">
				<div class="row">
					<div class="col-sm-12">
					
						<!-- table-responsive -->
						<iframe id="iframe-main" src="${basePath }/pages/bracket/sys/menu-list.jsp" name="iframe-main" frameborder="0" width="100%" scrolling="no"></iframe>

					</div>
					<!-- col-sm-12 -->
				</div>
				<!-- row -->
			</div>
			<!-- contentpanel -->

		</div>
		<!-- mainpanel -->


	</section>


	<jsp:include page="import-js.jsp" />
</body>
</html>