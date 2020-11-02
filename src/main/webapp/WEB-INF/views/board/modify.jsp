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

				<!-- 글 번호 가져가지고 페이지이동 2번째 방법 -->
				<form method="post" role="form" action="">
					<input type="hidden" name="bno" value="${bvo.bno }">
				<!-- 바디  -->
				 <div class="box-body">
				 <div>
				  <span class="form-group">
				     <label for="exampleInputEmail">글번호</label>
				     <input type="text" name="bno" class="form-control" style="width:200px;display:inline;margin-right:100px;" value="${bvo.bno}" readonly>				     			   
				  </span>
				  <span class="form-group">
				     <label for="exampleInputEmail">글쓴이</label>
				     <input type="text" name="writer" class="form-control" style="width:200px;display:inline;margin-right:100px;" value="${bvo.writer}" readonly> 				   
				  </span>
				  <span class="form-group">
				     <label for="exampleInputEmail">작성일자</label>
				     <input type="text" name="regdate" class="form-control" style="width:200px;display:inline;margin-right:100px;" value="${bvo.regdate}" readonly> 				   
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
				 </form>
				 <div class="box-footer">
				 	<button type="submit" class="btn btn-warning" >글 수정</button>
				 	<button type="submit" class="btn btn-primary">글 목록으로</button>
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

<script type="text/javascript">
$(document).ready(function(){ 

	let formObj = $("form[role='form']");
	console.log(formObj);
	
	//목록으로
	$(".btn-primary").on("click", function(){
		location.href="/board/listAll";
	});

	//수정버튼 클릭시
	$(".btn-warning").click(function(){
		formObj.submit();
	});
	
})//end of jQuery
</script>
<%@ include file="../include/footer.jsp" %>
