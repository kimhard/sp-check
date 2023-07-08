<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function registerCheck() {
		var memID = $("#memID").val();
		$.ajax({
			url : "${contextPath}/memregisterCheck.do",
			type : "get",
			data : {
				"memID" : memID
			},
			success : function(result) {

				//중복 유무 출력(result=1 : 사용할 수 있는 id, 0이면 사용할 수 없는)
				if (result == 1) {
					$("#checkMessage").html("사용할수 있는 아이디입니다.")
					$("#checkType")
							.attr("class", "modal-content panel-success")

				} else {
					$("#checkMessage").html("사용할수 없는 아이디입니다.")
					$("#checkType")
							.attr("class", "modal-content panel-warning");
				}
				$("#myModal").modal("show");
			},
			error : function() {
				alert("error");
			}
		})

	}
	function passwordCheck() {
		var memPassword1 = $("#memPassword1").val();
		var memPassword2 = $("#memPassword2").val();
		if (memPassword1 != memPassword2) {
			$("#passMessage").html("비밀번호가 서로 일치하지 않습니다.");
		} else {
			$("#passMessage").html(" ");
			$("#memPassword").val("memPassword1");
		}
	}
	function goInsert(){
		var memAge=$("memAge").val();
		if(memAge==null || memAge=="" || memAge ==0){
			alert("나이를 입력하세요");
			return false;
		}
		document.frm.submit(); //전송
	}
</script>
</head>
<body>
	<div class="container">
		<jsp:include page="../common/header.jsp" />
		<h2>성욱스 블로그</h2>
		<div class="panel panel-default">
			<div class="panel-heading">회원가입</div>
			<div class="panel-body">
				<form name ="frm" action="${contextPath}/memregister.do" method="post">
					<input type="hidden" id="memPassword" name="memPassword" value="" /> <!-- 사용자가 설정하는 패스워드는 password로 받아들이나 가입당시에는 ps1 ps2로 보내기 때문에 hidden으로 하나주자는 의미로 하나설정함  -->
					<table class="table table-bordered"
						style="text-align: center; border: 1px solid #dddddd">
						<tr>
							<td style="width: 110px; vertical-align: middle;">아이디</td>
							<td><input id="memID" name="memID" class="form-control"
								type="text" max length="20" placeholder="아이디를 입력하세요." /></td>
							<td style="width: 100px;"><button type="button"
									class="btn btn-primary btn-sm" onclick="registerCheck()">중복확인</button></td>
						</tr>
						<tr>
							<td style="width: 110px; vertical-align: middle;">비밀번호</td>
							<td colspan="2"><input id="memPassword1" name="memPassword1"
								onkeyup="passwordCheck()" class="form-control" type="password"
								max length="20" placeholder="비밀번호를 입력하세요." /></td>

						</tr>
						<tr>
							<td style="width: 110px; vertical-align: middle;">비밀번호 확인</td>
							<td colspan="2"><input id="memPassword2" name="memPassword2"
								onkeyup="passwordCheck()" class="form-control" type="password"
								max length="20" placeholder="비밀번호를 입력하세요." /></td>

						</tr>

						<tr>
							<td style="width: 110px; vertical-align: middle;">사용자 이름</td>
							<td colspan="2"><input id="memName" name="memName"
								class="form-control" type="text" max length="20"
								placeholder="이름을 입력하세요." /></td>
						</tr>
						<tr>
							<td style="width: 110px; vertical-align: middle;">사용자 나이</td>
							<td colspan="2"><input id="memAge" name="memAge"
								class="form-control" type="text" max length="20"
								placeholder="나이를 입력하세요." /></td>
						</tr>
						<tr>
							<td style="width: 110px; vertical-align: middle;">성별</td>
							<td colspan="2">
								<div class="form-group"
									style="text-align: center; margin: 0 auto;">
									<div class="btn-group" data-toggle="buttons">
										<lable class="btn btn-primary active"> <input
											type="radio" id="memGender" name="memGender"
											autocomplete="off" value="남자" checked /> 남자 </lable>
										<lable class="btn btn-primary active"> <input
											type="radio" id="memGender" name="memGender"
											autocomplete="off" value="여자" checked /> 여자 </lable>
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<td style="width: 110px; vertical-align: middle;">이메일</td>
							<td colspan="2"><input id="memEmail" name="memEmail"
								class="form-control" type="text" max length="20"
								placeholder="이메일을 입력하세요." /></td>
						</tr>
						<tr>
							<td colspan="3" style="text-align: Left;"><span
								id="passMessage" style="color: red"></span> <input type="button"
								class="btn btn-primary btn-sm pull-right" value="등록" /></td>
						</tr>
					</table>
				</form>


			</div>
			<!--  다이얼로그창(모달) -->
			<!-- Modal -->
			<div class="modal fade" id="myModal" role="dialog">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div id="checkType" class="modal-content panel-info">
						<div class="modal-header panel-heading">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">메세지를 확인하세요</h4>
						</div>
						<div class="modal-body">
							<p id="checkMessage"></p>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
						</div>
					</div>

				</div>
			</div>


			<div class="panel-footer">김성욱</div>
		</div>
	</div>

</body>
</html>
