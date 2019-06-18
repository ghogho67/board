<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    
    <!-- 쿠키 값 조회해버리기 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/js.cookie.js"></script>
    
    <script type="text/javascript">
    	
    	$(document).ready(function(){
    		
    		var remember = Cookies.get("remember");
    		if(remember == 'true'){
    			$("#remember").prop("checked", true);
    			$("#userId").val(Cookies.get("userId"));
    			$("#password").focus();
    		}
    		
    		$("#signinBtn").on("click", function(){
    			$('#frm').submit();
				
    		});
    		
		});
    </script>
    
	
	
    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/css/signin.css" rel="stylesheet">
  </head>

  <body>
    <div class="container">

      <form id="frm" class="form-signin" action="${pageContext.request.contextPath}/login" method="post">
      
        <h2 class="form-signin-heading">Please sign in</h2>
      
        <label for="userId" class="sr-only">userId</label>
        <input name="userId" type="text" id="userId" class="form-control" placeholder="UserId"  required>
       
        <label for="inputPassword" class="sr-only">Password</label>
        <input name="password" type="password" id="password" class="form-control" placeholder="Password"  required>
       
        <div class="checkbox">
          <label>
            <input id="remember" name="remember" type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button id = "signinBtn" class="btn btn-lg btn-primary btn-block" type="button">Sign in</button>
      
      </form>

    </div> <!-- /container -->


  </body>
</html>