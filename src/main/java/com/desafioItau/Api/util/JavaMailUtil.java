package com.desafioItau.Api.util;

import javax.mail.PasswordAuthentication;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import ch.qos.logback.classic.Logger;

public class JavaMailUtil {

	public static void sendMail(String mensagem) throws MessagingException {
		
		System.out.println("preparando envio");
		
		Properties properties = new Properties();
		
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
	
		String contaEmail = "aluysio8812@gmail.com";
		
		// na vers�o 2.0 a conta de email e senha ser� colocado em um propierts separado da aplica��o
		String password = "75BEdg522@";
		
		Session session = Session.getInstance(properties, new Authenticator() {
		  
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(contaEmail, password);
						
				
			}
		
		});
		
		Message message = prepararMensagem(session, contaEmail, mensagem);
		
		Transport.send(message);
		
	}
	
       public static Message prepararMensagem(Session session, String contaEmail, String mensagem)	{
    	 try {
    	   
    	   Message message = new MimeMessage(session);
           
    	   message.setFrom(new InternetAddress(contaEmail));
    	   
    	   message.setRecipient(Message.RecipientType.TO, new InternetAddress(mensagem));
    	   
    	   message.setSubject("Envio da oferta");
    	   
    	   message.setText("ol� seu contrato ser� expirado em 4 dias voc� quer renovar?");
    
    	   System.out.println("enviado");
    	   
    	   
    	   return message;
    	 } catch (Exception ex) {
		
    	 }
    	  
    	 
    	   return null;
    	   
       }
	
}
