var username;
			var passw;
		     $(function(){
		     	var shuru1=$("#shuru1");
		     	var shuru2=$("#shuru2");
		     	$(".btn-img1").click(function(){
		     		if (shuru1.display="none") {
		     			shuru2.attr("style","display: none;")
		     			shuru1.attr("style","display: block;")
		     			$(".btn-img1").attr("style","color: red;");
		     			$(".btn-img2").attr("style","color: black;");
		     		} 
		     	});
		     	$(".btn-img2").click(function(){
		     		if (shuru2.display="none") {
		     			shuru1.attr("style","display: none;");
		     			shuru2.attr("style","display: block;");
		     			$(".btn-img2").attr("style","color: red;");
		     			$(".btn-img1").attr("style","color: black;");
		     		} 
		     	});
		     	username = $("#uer").get(0);
				passw=$("#pas").get(0);
				
		     });
		     function trim(txt){
				var afterTrimTxt=txt.replace(/^\S*/,"").replace(/\S*$/,"");
				return afterTrimTxt;
			}
		     function isSetpssword(setpassword) { 
   				var regExp= /^[A-Za-z]+[0-9]+[A-Za-z0-9]*|[0-9]+[A-Za-z]+[A-Za-z0-9]*$/;
 			    var flag =regExp.test(setpassword)	;
 			    return flag;
			}
		    function checkUsername(){
				var username1=username.value;
				var mySpan=username.nextSibling;
				mySpan.innerHTML="";
				if (!trim(username1)=="") {
					mySpan.innerHTML="请输入用户名"
					mySpan.className="error";
				}else if(username1.valueOf()==""){
					mySpan.innerHTML="用户名不能为空"
					mySpan.className="error";
				}else{
					mySpan.className="success";
				}
			}
			function checkSetpassword(){
				var setpassword=passw.value;
				var mySpan=passw.nextSibling;
				mySpan.innerHTML="";
					if(setpassword.valueOf()==""){
						alert("密码不能为空");
						mySpan.className="error";
					}else if (isSetpssword(setpassword)) {
						mySpan.className="success";
					} else{
					    alert("密码格式不正确");
						mySpan.className="error";
					}
			}