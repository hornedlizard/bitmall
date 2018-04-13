<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
<title>비트닷컴 쇼핑몰</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.servletContext.contextPath }/assets/css/font.css" rel="stylesheet" type="text/css">
<script src="//code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	/* 회원 가입 */
	$("#btn-join").click(function(event){
		event.preventDefault();
		var birth = $("#birth1").val() + $("#birth2").val() + $("#birth3").val();
		var tel = $("#tel1").val() + $("#tel2").val() + $("#tel3").val();
		var phone = $("#phone1").val() + $("#phone2").val() + $("#phone3").val();
		var address = $("#zip1").val() + $("#zip2").val() + $("#address").val();
		var form = $("#join-form");
		form.append("<input name='birth' value="+birth+">")
			.append("<input name='tel' value="+tel+">")
			.append("<input name='phone' value="+phone+">")
			.append("<input name='address' value="+address+">");
		form[0].submit();
	});
	
	/* 폼 리셋 */
	$("#btn-reset").click(function(){
		event.preventDefault();
		$("#join-form")[0].reset();
	});
	
	/* id 중복확인 */
	$("#checkId").click(function(event){
		event.preventDefault();
		var id = $("#id").val();
		if (id == "") {
			$("#idChecking").text("아이디를 입력해주세요.").css("color","red");
			return;
		}
		$.ajax({
			url: "${pageContext.servletContext.contextPath }/api/member/checkId",
			dataType: "json",
			type: "post",
			data: {"id": id},
			success: function(response){
				console.log(response.data);
				if (response.result != "success") {
					return;
				}
				if (response.data == "exist") {
					$("#idChecking").text("이미 사용중인 아이디 입니다.").css("color","red");
					$("#id").val("").focus();
					return;
				}
				$("#idChecking").text("사용할 수 있는 아이디입니다.");
			},
			error: function(xhr, status, e){
				console.error(status + ":" + e);
			}
		});
	});
	
	/* 패스워드 재확인 폼 인식 */
	$("#password").on("input", function(){
		checkPassword();
	});
	$("#password2").on("input", function(){
		checkPassword();
	});
	/* 패스워드 재확인 */
	var checkPassword = function() {	
		var pw = $("#password").val();
		var repw = $("#password2").val();
		if (pw == repw) {
	        $("#rePwChecking").text("");
	    } else {
	        $("#rePwChecking").text("패스워드가 다릅니다").css("color","red");
	    }
	};
});
</script>
</head>
<body style="margin:0">
<jsp:include page="/WEB-INF/views/include/head.jsp"/>
<jsp:include page="/WEB-INF/views/include/search.jsp"/>
<table width="959" border="0" cellspacing="0" cellpadding="0" align="center">
	<tr><td height="10" colspan="2"></td></tr>
	<tr>
		<td height="100%" valign="top">
			<jsp:include page="/WEB-INF/views/include/navigation.jsp"/>
		</td>
		<td width="10"></td>
		<td valign="top">

		<!-------------------------------------------------------------------------------------------->	
		<!-- 시작 : 다른 웹페이지 삽입할 부분                                                                                                                                                            -->
		<!-------------------------------------------------------------------------------------------->	

			<table border="0" cellpadding="0" cellspacing="0" width="747">
				<tr><td height="13"></td></tr>
				<tr>
					<td height="30" align="center">
						<img src="${pageContext.servletContext.contextPath }/assets/images/login_title.gif" width="747" height="30" border="0">
					</td>
				</tr>
				<tr><td height="13"></td></tr>
			</table>
			<table border="0" cellpadding="0" cellspacing="0" width="685" class="cmfont">
				<tr>
					<td><img src="${pageContext.servletContext.contextPath }/assets/images/login_title2.gif" border="0"></td>
				</tr>
				<tr><td height="10"></td></tr>
			</table>

			<%-- <form name="form2" id="join-form" method="post"> --%>
			<form:form modelAttribute="memberVo" id="join-form" name="form2" method="post" 
					action="${pageContext.servletContext.contextPath }/member/join">
			<table border="0" cellpadding="5" cellspacing="1" width="685" bgcolor="cccccc">
				<tr>
					<td align="center" bgcolor="efefef">
						<table border="0" cellpadding="0" cellspacing="5" width="100%" bgcolor="white">
							<tr>
								<td align="center">
									<table border="0" cellpadding="0" cellspacing="0" width="635" class="cmfont">
										<tr>
											<td width="127" height="30">
												<img align="absmiddle" src="${pageContext.servletContext.contextPath }/assets/images/i_dot.gif" border="0"> <font color="898989"><b>아이디</b></font>
											</td>
											<td style="padding-top: 10px;">
												<!-- <input type="text" id="id" name="id" maxlength = "12" value="" size="20" class="cmfont1"> -->
												<form:input path="id"/>
												<a href="" id="checkId"><img align="absmiddle" src="${pageContext.servletContext.contextPath }/assets/images/b_idcheck.gif" border="0"/></a>
												<spring:hasBindErrors name="memberVo">
													<c:if test="${errors.hasFieldErrors('id') }">
													<p style="display:inline; text-align:left; color:red">
												        <strong>
												        	<spring:message code="${errors.getFieldError('id').codes[0] }" 
												        	text="${errors.getFieldError('id').defaultMessage }"/>
												        </strong>
												   </p>
												   </c:if>
												</spring:hasBindErrors>
										        <span id="idChecking"></span>
											</td>
										</tr>
										<tr>
											<td width="127" height="30">
												<img align="absmiddle" src="${pageContext.servletContext.contextPath }/assets/images/i_dot.gif" border="0"> <font color="898989"><b>비밀번호</b></font>
											</td>
											<td style="padding-top: 10px;">
												<input TYPE="password" id="password" name="password" maxlength = "10" size="20" class="cmfont1">
												<spring:hasBindErrors name="memberVo">
													<c:if test="${errors.hasFieldErrors('password') }">
													<p style="display:inline; text-align:left; color:red">
												        <strong>
												        	<spring:message code="${errors.getFieldError('password').codes[0] }" 
												        	text="${errors.getFieldError('password').defaultMessage }"/>
												        </strong>
												   </p>
												   </c:if>
												</spring:hasBindErrors>
											</td>
										</tr>
										<tr>
											<td width="127" height="30">
												<img align="absmiddle" src="${pageContext.servletContext.contextPath }/assets/images/i_dot.gif" border="0"> <font color="898989"><b>비밀번호 확인</b></font>
											</td>
											<td>
												<input TYPE="password" id="password2" name="password2" maxlength = "10" size="20" class="cmfont1">
												<span id="rePwChecking"></span>
											</td>
										</tr>
										<tr><td colspan="2" height="10"></td></tr>
										<tr><td colspan="2" bgcolor="E6DDD5"></td></tr>
										<tr><td colspan="2" height="10"></td></tr>
									</table>
									<table border="0" cellpadding="0" cellspacing="0" width="635" class="cmfont">
										<tr>
											<td width="127" height="30">
												<img align="absmiddle" src="${pageContext.servletContext.contextPath }/assets/images/i_dot.gif" border="0"> <font color="898989"><b>이 름</b></font>
											</td>
											<td style="padding-top: 10px;">
												<!-- <input type="text" id="name" name="name" maxlength = "10" value = "" size="20" class="cmfont1"> -->
												<form:input path="name"/>
												<spring:hasBindErrors name="memberVo">
													<c:if test="${errors.hasFieldErrors('name') }">
													<p style="display:inline; text-align:left; color:red">
												        <strong>
												        	<spring:message code="${errors.getFieldError('name').codes[0] }" 
												        	text="${errors.getFieldError('name').defaultMessage }"/>
												        </strong>
												   </p>
												   </c:if>
												</spring:hasBindErrors>
											</td>
										</tr>
										<tr>
											<td width="127" height="30">
												<img align="absmiddle" src="${pageContext.servletContext.contextPath }/assets/images/i_dot.gif" border="0"> <font color="898989"><b>생년월일</b></font>
											</td>
											<td style="padding-top: 10px;">
												<input type="text" id="birth1" name='birth1' size = "4" maxlength = "4" value = "${fn:substring(vo.birth, 0, 4) }" class="cmfont1"> <font color="898989">년</font> 
												<input type="text" id="birth2" name='birth2' size = "2" maxlength = "2" value = "${fn:substring(vo.birth, 4, 6) }" class="cmfont1"> <font color="898989">월</font> 
												<input type="text" id="birth3" name='birth3' size = "2" maxlength = "2" value = "${fn:substring(vo.birth, 6, 8) }" class="cmfont1"> <font color="898989">일</font> 
												<spring:hasBindErrors name="memberVo">
													<c:if test="${errors.hasFieldErrors('birth') }">
													<p style="display:inline; text-align:left; color:red">
												        <strong>
												        	<spring:message code="${errors.getFieldError('birth').codes[0] }" 
												        	text="${errors.getFieldError('birth').defaultMessage }"/>
												        </strong>
												   </p>
												   </c:if>
												</spring:hasBindErrors>
												<!-- <input type="radio" name='sm' value = "1" checked> <font color="898989">양력</font> 
												<input type="radio" name='sm' value = "2" > <font color="898989">음력</font></td> -->
											</td>
										</tr>
										<tr><td colspan="2" height="10"></td></tr>
										<tr><td colspan="2" bgcolor="E6DDD5"></td></tr>
										<tr><td colspan="2" height="10"></td></tr>
									</table>
									<table border="0" cellpadding="0" cellspacing="0" width="635" class="cmfont">
										<tr>
											<td width="127" height="30">
												<img align="absmiddle" src="${pageContext.servletContext.contextPath }/assets/images/i_dot.gif" border="0"> <font color="898989"><b>전화 번호</b></font>
											</td>
											<td style="padding-top: 10px;">
												<input type="text" id="tel1" name='tel1' size = "4" maxlength = "4" value = "${fn:substring(vo.tel, 0, 3) }" class="cmfont1"><font color="898989">-</font>
												<input type="text" id="tel2" name='tel2' size = "4" maxlength = "4" value = "${fn:length(vo.tel) == 10 ? fn:substring(vo.tel, 3, 6) : fn:substring(vo.tel, 3, 7) }" class="cmfont1"><font color="898989">-</font>
												<input type="text" id="tel3" name='tel3' size = "4" maxlength = "4" value = "${fn:length(vo.tel) == 10 ? fn:substring(vo.tel, 6, 10) : fn:substring(vo.tel, 6, 11) }" class="cmfont1">
												
											</td>
										</tr>
										<tr>
											<td width="127" height="30">
												<img align="absmiddle" src="${pageContext.servletContext.contextPath }/assets/images/i_dot.gif" border="0"> <font color="898989"><b>핸드폰 번호</b></font>
											</td>
											<td style="padding-top: 10px;">
												<input type="text" id="phone1" name='phone1' size = "4" maxlength = "4" value = "${fn:substring(vo.phone, 0, 3) }" class="cmfont1"><font color="898989">-</font>
												<input type="text" id="phone2" name='phone2' size = "4" maxlength = "4" value = "${fn:length(vo.phone) == 10 ? fn:substring(vo.phone, 3, 6) : fn:substring(vo.phone, 3, 7) }" class="cmfont1"><font color="898989">-</font>
												<input type="text" id="phone3" name='phone3' size = "4" maxlength = "4" value = "${fn:length(vo.phone) == 10 ? fn:substring(vo.phone, 6, 10) : fn:substring(vo.phone, 6, 11) }" class="cmfont1">
												<spring:hasBindErrors name="memberVo">
													<c:if test="${errors.hasFieldErrors('phone') }">
													<p style="display:inline; text-align:left; color:red">
												        <strong>
												        	<spring:message code="${errors.getFieldError('phone').codes[0] }" 
												        	text="${errors.getFieldError('phone').defaultMessage }"/>
												        </strong>
												   </p>
												   </c:if>
												</spring:hasBindErrors>
											</td>
										</tr>
										<tr>
											<td width="127" height="50">
												<img align="absmiddle" src="${pageContext.servletContext.contextPath }/assets/images/i_dot.gif" border="0"> <font color="898989"><b>주 소</b></font>
											</td>
											<td style="padding-top: 10px;">
												<input type="text" id="zip1" name='zip1' size = "4" maxlength = "3" value = "" class="cmfont1"><font color="898989">-</font>
												<input type="text" id="zip2" name='zip2' size = "4" maxlength = "3" value = "" class="cmfont1"> 
												<a href="javascript:FindZip(0)"><img align="absmiddle" src="${pageContext.servletContext.contextPath }/assets/images/b_zip.gif" border="0"></a><br>
												<input type="text" id="address" size = "50" maxlength = "200" value = "" class="cmfont1"><br>
												<spring:hasBindErrors name="memberVo">
													<c:if test="${errors.hasFieldErrors('address') }">
													<p style="padding:0; margin-top:0px; margin-bottom:12px; text-align:left; color:red">
												        <strong>
												        	<spring:message code="${errors.getFieldError('address').codes[0] }" 
												        	text="${errors.getFieldError('address').defaultMessage }"/>
												        </strong>
												   </p>
												   </c:if>
												</spring:hasBindErrors>
											</td>
										</tr>
										<tr>
											<td width="127" height="30" style="padding-top: 13px;">
												<img align="absmiddle" src="${pageContext.servletContext.contextPath }/assets/images/i_dot.gif" border="0"> <font color="898989"><b>E-Mail</b></font>
											</td>
											<td style="padding-top: 13px;">
												<input type="text" id="email" name='email' size = "50" maxlength = "50" value = "" class="cmfont1">
												<spring:hasBindErrors name="memberVo">
													<c:if test="${errors.hasFieldErrors('email') }">
													<p style="padding:0; margin-top:0px; margin-bottom:12px; text-align:left; color:red">
												        <strong>
												        	<spring:message code="${errors.getFieldError('email').codes[0] }" 
												        	text="${errors.getFieldError('email').defaultMessage }"/>
												        </strong>
												   </p>
												   </c:if>
												</spring:hasBindErrors>
											</td>
										</tr>
									</table>
			
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<table border="0" cellpadding="0" cellspacing="0" width="685" class="cmfont">
				<tr>
					<td height="45" align="right">
						<input id="btn-join" type="image" src="${pageContext.servletContext.contextPath }/assets/images/b_add.gif" border="0">&nbsp;&nbsp;
						<a href="" id="btn-reset"><img src="${pageContext.servletContext.contextPath }/assets/images/b_reset.gif" border="0"></a>
					</td>
				</tr>
			</table>
			</form:form>
			<%-- </form> --%>

		<!-------------------------------------------------------------------------------------------->	
		<!-- 끝 : 다른 웹페이지 삽입할 부분                                                                                                                                                              -->
		<!-------------------------------------------------------------------------------------------->	

		</td>
	</tr>
</table>
<br><br>
<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
</body>
</html>