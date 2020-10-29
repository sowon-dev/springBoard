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
					<h3 class="box-title">ITWILL 게시글 상세페이지</h3>
				</div>
				<!-- /.box-header -->
				
				<!-- 바디  -->
				 <div class="box-body">
				 <div style="text-align: center;">
				  <span class="form-group">
				     <label for="exampleInputEmail">글번호</label>
				     <input type="text" name="title" class="form-control" style="width:200px;display:inline;margin-right:100px;" value="${bvo.bno}" readonly>				     			   
				  </span>
				  <span class="form-group">
				     <label for="exampleInputEmail">글쓴이</label>
				     <input type="text" name="writer" class="form-control" style="width:200px;display:inline;margin-right:100px;" value="${bvo.writer}" readonly> 				   
				  </span>
				  <span class="form-group">
				     <label for="exampleInputEmail">작성일자</label>
				     <input type="text" name="writer" class="form-control" style="width:200px;display:inline;margin-right:100px;" value="${bvo.regdate}" readonly> 				   
				  </span>
				  </div>
				  <div class="form-group">
				     <label for="exampleInputEmail">제목</label>
				     <input type="text" name="title" class="form-control" value="${bvo.title}">				     			   
				  </div>
				   <div class="form-group">
				     <label for="exampleInputEmail">내용</label>
				     <textarea name="content" rows="5" class="form-control">${bvo.content}</textarea>			   
				   </div>
				 </div>
				 <div class="box-footer">
				 	<button type="button" class="btn btn-warning" onclick="">글 수정</button>
				 	<button type="button" class="btn btn-danger" onclick="">글 삭제</button>
				 	<button type="button" class="btn btn-primary" onclick="location.href='/board/listAll'">글 목록으로</button>
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
