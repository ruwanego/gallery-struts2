<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title><decorator:title default="Gallery"/></title>
		<link rel="stylesheet" href="/css/bootstrap.css">
		<link rel="stylesheet" href="/css/font-awesome.css">
		<link rel="stylesheet" href="/css/override.css">
		<link rel="shortcut icon" href="/favicon.ico">
	</head>
	<body>
		<article>
			<div class="wrapper container">
				<header class="page-header">
					<nav>
						<ul class="nav nav-pills nav-justified">
							<li>
								<a href="/Gallery">
									<i class="icon-home"></i>
								</a>
							</li>
							<li>
								<a href="/Gallery">
									<img src="/logo.png" alt="Piece-Work logo">
								</a>
							</li>
							<li>
								<a href="javascript:;">
									<i class="icon-search"></i>
								</a>
							</li>
						</ul>
					</nav>
				</header>

				<section>
					<decorator:body/>
				</section>
			</div>

			<footer class="container">
				<ul class="nav nav-pills pull-right">
					<li>
						<a href="/Administration">Administration</a>
					</li>
				</ul>
			</footer>
		</article>

		<script src="//code.jquery.com/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>