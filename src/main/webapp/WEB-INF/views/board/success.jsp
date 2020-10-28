<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">게시판 글쓰기 성공</h3>
				</div>
				<!-- /.box-header -->
				
				<!-- 바디  -->
				 <div class="box-body">
				 	<h2>글쓰기 성공</h2>
				 	${vo }
				 </div>
				 <div class="box-footer">
				 	<h2>글쓰기 성공 footer</h2>
				 </div>
				
				<!-- 바디 끝 -->
			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->
	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<%@ include file="../include/footer.jsp" %>
