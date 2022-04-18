package com.gur.login.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import com.gur.login.dao.AccRepo;
import com.gur.login.model.Account;
/**
 * @implNote: Login Controller
 * @author gurms
 *
 */
@Controller
public class AccController {

	
	@Autowired
	AccRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "LoginUltimate.jsp";
	}

	
	//add account
	@RequestMapping("/addacnt")
	public String addAccount(ModelMap errors, Account acnt) {
		
		for(int i=0;i<fetchaccountList().size();i++) {
			if(fetchaccountList().get(i).getUid().contentEquals(acnt.getUid())){
				{	
					errors.put("errorsignupMsg", "This account already exists");
					return "LoginUltimate.jsp";
				}
			 }
			}
		errors.put("correctsignupMsg", "Account Created Successfully");
		repo.save(acnt);
		return "LoginUltimate.jsp";
			
	}

	public String welcomeAccount(Account acnt) {
		for(int i=0;i<fetchaccountList().size();i++)
		{	//password check
			if(fetchaccountList().get(i).getUid().contentEquals(acnt.getUid())&&fetchaccountList().get(i).getPword().contentEquals(acnt.getPword())) {
				acnt.setName(fetchaccountList().get(i).getName());
				break;
			}	
		}
		return "WelcomeUlt.jsp";
	}
	
	//from h2 database to a list
	ArrayList<Account> fetchaccountList() {
		return (ArrayList<Account>) repo.findAll();
	}
	
	@RequestMapping("/loginacnt")
	private String Login(ModelMap errors, Account acnt) {
		if(findbyPassword(acnt.getUid(),acnt.getPword()))
		{	
			return welcomeAccount( acnt);
		}
		else{
			errors.put("errorMsg","Please provide with Correct User-ID or Password");
			return "LoginUltimate.jsp";
		}
	}
	
	Boolean findbyPassword(String uid, String psword) {
		Boolean flag=false;
		for(int i=0;i<fetchaccountList().size();i++)
		{
			if(fetchaccountList().get(i).getUid().contentEquals(uid)&&fetchaccountList().get(i).getPword().contentEquals(psword)) {
				flag=true;
				break;
			}
		}
		return flag;
	}

	@RequestMapping("/forgotpswrd")
	public String changePass( ModelMap errors, String uid,String name,String pswrd1, String pswrd2) {
	  for(int i=0;i<fetchaccountList().size();i++) {
		  if(fetchaccountList().get(i).getUid().contentEquals(uid)&&fetchaccountList().get(i).getName().contentEquals(name)){	
			  if(pswrd1.equals(pswrd2))
					{ 	
				  		fetchaccountList().get(i).setPword(pswrd1);
						repo.save(fetchaccountList().get(i));
						errors.put("correctforgotMsg", "Your Password has been changed");
						return "forgotpassult.jsp";
					}
		  }
	  }	
	  errors.put("errorforgotMsg","Please provide the Correct Details");
	  return "forgotpassult.jsp";
	}
}