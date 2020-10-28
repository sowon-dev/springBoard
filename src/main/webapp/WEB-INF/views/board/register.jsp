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
					<h3 class="box-title">ITWILL 게시판</h3>
				</div>
				<!-- /.box-header -->
				
				<!-- 바디  -->
				<form action="" role="form" method="post">
				 <div class="box-body">
				   <div class="form-group">
				     <label for="exampleInputEmail">제목</label>
				     <input type="text" name="title" class="form-control" placeholder="제목을 입력하시오">				     			   
				  </div>
				   <div class="form-group">
				     <label for="exampleInputEmail">내용</label>
				     <textarea name="content" rows="5" class="form-control" placeholder="내용을 입력하시오"></textarea>			   
				   </div>
				   <div class="form-group">
				     <label for="exampleInputEmail">글쓴이</label>
				     <input type="text" name="writer" class="form-control" placeholder="글쓴이를 입력하시오"> 				   
				   </div>
				 </div>
				 <div class="box-footer">
				 	<button type="submit" class="btn btn-primary">글 등록</button>
				 </div>
				</form>
				
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
