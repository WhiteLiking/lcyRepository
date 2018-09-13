<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
  <div id="footer_container" class="footer_white" style="padding-top:5px;background: none;border-top: none;">
    <div class="footer_con" id="footer_copyright">
        <p class="footer_copy_con">
            Copyright © 2010-2015 北京创锐文化传媒有限公司 Jumei.com 保留一切权利。客服热线：400-123-8888 <br>
            京公网安备 11010102001226 号 | <a href="http://www.miibeian.gov.cn" target="_blank" rel="nofollow">京ICP证111033号</a> | 食品流通许可证 SP1101051110165515（1-1）
            | <a href="http://mp5.jmstatic.com/mobile/pc/chuangrui.jpg" target="_blank" rel="nofollow">营业执照</a>
            | <a href="http://f1.jmstatic.com/static_account/dist/v1.0.85067/images/other/zhidu.pdf" target="_blank" rel="nofollow">公示制度</a>
        </p>
        <p>
            <a href="javascript:void(0)" class="footer_copy_logo logo01" rel="nofollow"></a>
            <a href="https://www.itrust.org.cn/yz/pjwx.asp?wm=1693268180" target="_blank" class="footer_copy_logo logo02" rel="nofollow"></a>
            <a href="javascript:void(0)" class="footer_copy_logo logo03" rel="nofollow"></a>
            <a href="javascript:void(0)" class="footer_copy_logo logo04" rel="nofollow"></a>
            <a href="https://ss.cnnic.cn/verifyseal.dll?sn=e12070911010031011307708&amp;ct=df&amp;pa=453163" target="_blank" class="footer_copy_logo logo05" rel="nofollow"></a>
        </p>
        <script>
         function change_urlknet(eleId){
             var str=document.getElementById(eleId).href;
             var str1=str.substring(0,(str.length-6));
             str1+=RndNum(6);
             document.getElementById(eleId).href=str1;
         }
         function RndNum(k){
             var rnd="";
             for (var i=0;i<k;i++) {
                 rnd+=Math.floor(Math.random()*10);
             }
             return rnd;
         }
        	</script>
    	</div>
	</div>
  </body>
</html>

