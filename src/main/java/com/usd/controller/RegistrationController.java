package com.usd.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.usd.entity.User;
import com.usd.exception.UserNotFoundException;
import com.usd.service.RegistrationService;

import net.bytebuddy.utility.RandomString;

@RestController
//@CrossOrigin(origins="http://localhost:4200")
public class RegistrationController {

	@Autowired
	private RegistrationService service;
	
	@Autowired
	private JavaMailSender mailSender;

	/*
	 * REGISTRATION AND LOGIN CODE
	 */

	@PostMapping("/registeruser")
	public User registerUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmailId();
		if (tempEmailId != null && !"".equals(tempEmailId)) {
			User userObj = service.fetchUserByEmailId(tempEmailId);
			if (userObj != null) {
				throw new Exception("User with " + tempEmailId + " is already exist");
			}
		}
		User userObj = null;
		userObj = service.saveUser(user);
		return userObj;
	}

	@PostMapping("/login")
	public String loginUser(@RequestBody User user) throws Exception {

		String tempEmailId = user.getEmailId();
		String tempPass = user.getPassword();
		User userObj = null;
		if (tempEmailId != null && tempPass != null) {
			userObj = service.fetchUserByEmailIdAndPassword(tempEmailId, tempPass);
		}
		if (userObj == null) {
			throw new Exception("User does not exist");
		}
		return userObj.getUserName()+" is succefully logged in..!!" ;
	}

	/*
	 * 
	 * END OF REGISTRATION AND LOGIN CODE
	 * 
	 */

	@PostMapping("/forgot_password")
	public String forgotResetPassword(HttpServletRequest request, ModelMap model) {
		String email = request.getParameter("email");
	//	String email = getPrincipal();
		String token = RandomString.make(45);
		try {
			service.updateResetPassword(token, email);
			String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password?token=" + token;
			sendEmail(email, resetPasswordLink);
		//	System.out.println(resetPasswordLink);
		} catch (UserNotFoundException e) {
			model.addAttribute("Error", e.getMessage());

		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}
		System.out.println("Email :" + email);
		System.out.println("token :" + token);
		return null;

	}

	public void sendEmail(String recipientEmail, String link) throws MessagingException, UnsupportedEncodingException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		helper.setFrom("contact@shopme.com", "Shopme Support");
		helper.setTo(recipientEmail);

		String subject = "Here's the link to reset your password";

		String content = "<p>Hello,</p>" + "<p>You have requested to reset your password.</p>"
				+ "<p>Click the link below to change your password:</p>" + "<p><a href=\"" + link
				+ "\">Change my password</a></p>" + "<br>" + "<p>Ignore this email if you do remember your password, "
				+ "or you have not made the request.</p>";

		helper.setSubject(subject);

		helper.setText(content, true);

		mailSender.send(message);
	}

	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
	
	@PostMapping("/reset_password")
	public String processResetPassword(HttpServletRequest request, Model model) {
	    String token = request.getParameter("token");
	    String password = request.getParameter("password");
	     
	    User user = service.getByResetPasswordToken(token);
	    model.addAttribute("title", "Reset your password");
	     
	    if (user == null) {
	        model.addAttribute("message", "Invalid Token");
	        return "message";
	    } else {           
	    	service.updatePassword(user, password);
	         
	        model.addAttribute("message", "You have successfully changed your password.");
	    }
	     
	    return "message";
	}

}
