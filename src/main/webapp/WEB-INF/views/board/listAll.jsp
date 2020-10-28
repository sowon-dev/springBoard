<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/header.jsp" %>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">게시판 글 조희</h3>
				</div>
				<!-- /.box-header -->
				
				<!-- 바디  -->
				 <div class="box-body">
				 	<table class="table table-bodered">
				 		<tr>
				 			<th>번호</th>
				 			<th>글쓴이</th>
				 			<th>제목</th>
				 			<th>내용</th>
				 			<th>작성일</th>
				 			<th>조회수</th>
				 		</tr>
				 		<c:forEach var="i" items="${boardList }">
				 		<tr>
				 			<td>${i.bno }</td>
				 			<td>${i.writer }</td>
				 			<td>${i.title }</td>
				 			<td>${i.content }</td>
				 			<td>${i.regdate }</td>
				 			<td>${i.viewcnt }</td>
				 		</tr>
				 		</c:forEach>
				 	</table>
				 </div>
				 
				 <div class="box-footer">
				    <h3> 결과 : ${result } </h3>
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
	//alert("성공적으로 글 작성되었습니다")
	let result="${result}";
	if(result == 'success'){
		alert('성공적으로 글 작성되었습니다.');
	}else{
		alert('글쓰기가 실패하였습니다.');
	}
</script>

<%@ include file="../include/footer.jsp" %>
