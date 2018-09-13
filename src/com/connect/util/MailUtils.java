package com.connect.util;

import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import com.sun.mail.util.MailSSLSocketFactory;





public class MailUtils {

	public static void sendMail(String email, String emailMsg)
			throws AddressException, MessagingException {
		String from="luchaoyi9527@qq.com";
		String host="smtp.qq.com";
		// 1.閸掓稑缂撴稉锟芥稉顏嗏柤鎼村繋绗岄柇顔绘閺堝秴濮熼崳銊ょ窗鐠囨繂顕挒锟� Session
      
		Properties props = new Properties();
		//鐠佸墽鐤嗛崣鎴︼拷浣烘畱閸楀繗顔�
		props.setProperty("mail.transport.protocol", "SMTP");
		
		//鐠佸墽鐤嗛崣鎴︼拷渚�鍋栨禒鍓佹畱閺堝秴濮熼崳锟�
		props.setProperty("mail.host", host);
		props.setProperty("mail.smtp.auth", "true");// 閹稿洤鐣炬宀冪槈娑撶皪rue
		// 閸掓稑缂撴宀冪槈閸ｏ拷
		MailSSLSocketFactory sf;
		try {
			sf = new MailSSLSocketFactory();
			sf.setTrustAllHosts(true);
			props.put("mail.smtp.ssl.enable", "true");
			props.put("mail.smtp.ssl.socketFactory", sf);
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				//鐠佸墽鐤嗛崣鎴︼拷浣锋眽閻ㄥ嫬绗庨崣宄版嫲鐎靛棛鐖�
				return new PasswordAuthentication("luchaoyi9527@qq.com", "gvwmnctfdrvnhbjf");
			}
		};

		Session session = Session.getInstance(props, auth);

		// 2.閸掓稑缂撴稉锟芥稉鐙筫ssage閿涘苯鐣犻惄绋跨秼娴滃孩妲搁柇顔绘閸愬懎顔�
		Message message = new MimeMessage(session);

		//鐠佸墽鐤嗛崣鎴︼拷浣斤拷锟�
		message.setFrom(new InternetAddress(from));

		//鐠佸墽鐤嗛崣鎴︼拷浣规煙瀵繋绗岄幒銉︽暪閼帮拷
		message.setRecipient(RecipientType.TO, new InternetAddress(email)); 

		//鐠佸墽鐤嗛柇顔绘娑撳顣�
		message.setSubject("閻€劍鍩涘┑锟藉ú锟�");
		// message.setText("鏉╂瑦妲告稉锟界亸浣圭负濞插鍋栨禒璁圭礉鐠囷拷<a href='#'>閻愮懓鍤�</a>");

		String url="http://localhost:8080/myProductManager/UserServlet?action=active&code="+emailMsg;
		String content="<h1>来自聚美优品的激活邮件!激活请点击以下链接!</h1><h3><a href='"+url+"'>"+url+"</a></h3>";
		//鐠佸墽鐤嗛柇顔绘閸愬懎顔�
		message.setContent(content, "text/html;charset=utf-8");

		// 3.閸掓稑缂� Transport閻€劋绨亸鍡涘仏娴犺泛褰傞柅锟�
		Transport.send(message);
		}
		
	public static void main(String[] args) throws AddressException, MessagingException {
		MailUtils.sendMail("luchaoyi9527@163.com", "qeqweqwe");
		System.out.println("OK");
		
	}
}
