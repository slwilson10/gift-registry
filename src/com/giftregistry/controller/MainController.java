package com.giftregistry.controller;


import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;


import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.giftregistry.model.*;
import com.giftregistry.service.*;
 
@Controller
public class MainController {
	
	private GiftService giftService;
	private UserService userService;
	
	@Autowired(required=true)
	@Qualifier(value="giftService")
	public void setGiftService(GiftService gs){
		this.giftService = gs;
	}
	
	@Autowired(required=true)
	@Qualifier(value="userService")
	public void setUserService(UserService us){
		this.userService = us;
	}
	
	
	//When search reads "/" or "welcome" return hello.jsp, title and message
	/*@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView defaultPage() {
 
	  ModelAndView model = new ModelAndView();
	  model.addObject("title", "Spring Security Login Form - Database Authentication");
	  model.addObject("message", "This is default page!");
	  model.setViewName("hello");
	  return model;
 
	}*/
	
	@RequestMapping (value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public ModelAndView listGifts(@RequestParam Map<String,String> pathVars, 
			@RequestParam(value = "price", required = false) String price,
			@RequestParam(value = "store", required = false) String store,
			@RequestParam(value = "whofor", required = false) String whofor) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String curuser = auth.getName();
		String boughtMsg = pathVars.get("boughtMsg");
		ModelAndView model = new ModelAndView("list");
		model.addObject("gift", new Gift());
		model.addObject("whoforlist", this.giftService.listWhoFors());
		model.addObject("storeslist", this.giftService.listStores());
		model.addObject("listGifts", this.giftService.listGifts(whofor,store,price));
		//model.addObject("listBoughtByYou", this.giftService.listBoughtByYou(curuser));
		return model;
	}
	
	@RequestMapping (value = "/cart", method =  RequestMethod.GET )
	public ModelAndView cartGifts(@RequestParam Map<String,String> pathVars, 
			@RequestParam(value = "price", required = false) String price,
			@RequestParam(value = "store", required = false) String store,
			@RequestParam(value = "whofor", required = false) String whofor) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String curuser = auth.getName();
		ModelAndView model = new ModelAndView("cart");
		model.addObject("gift", new Gift());
		model.addObject("whoforlist", this.giftService.listWhoFors());
		model.addObject("storeslist", this.giftService.listStores());
		model.addObject("listGifts", this.giftService.listGifts(whofor,store,price));
		model.addObject("listBoughtByYou", this.giftService.listBoughtByYou(curuser));
		return model;
	}
	
	@RequestMapping (value = "/buy/{id}", method =  RequestMethod.GET )
	public ModelAndView buyGift(@RequestParam Map<String,String> pathVars, 
			@RequestParam(value = "price", required = false) String price,
			@RequestParam(value = "store", required = false) String store,
			@RequestParam(value = "whofor", required = false) String whofor, 
			@PathVariable("id") int id) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String curuser = auth.getName();
		ModelAndView model = new ModelAndView("buy");
		model.addObject("gift", this.giftService.getGiftById(id));
		model.addObject("whoforlist", this.giftService.listWhoFors());
		model.addObject("storeslist", this.giftService.listStores());
		model.addObject("listGifts", this.giftService.listGifts(whofor,store,price));
		return model;
	}
	
	
	
	//When search reads /admin anything return amdin.jsp
//	@RequestMapping(value = "/admin", method = RequestMethod.GET)
//	public String adminPage(Model model) {
// 
//	  model.addAttribute("gift", new Gift());
//	  model.addAttribute("listGifts", this.giftService.listGifts());
//	  model.addAttribute("listWhoFors", this.giftService.listWhoFors());
//	  model.addAttribute("listStores", this.giftService.listStores());
//	  model.addAttribute("listUsers", this.giftService.listUsers());
//	  return "admin";
//	}
	
	//For add person 
    @RequestMapping(value= "/admin/add", method = RequestMethod.POST)
    public String addGift(@ModelAttribute("gift") Gift g){
         
        if(g.getId() == 0){
            //new person, add it
        	System.out.print(g);
            this.giftService.addGift(g);
        }else{
            //existing person, call update
            this.giftService.updateGift(g);
        }
         
        return "redirect:/admin";
         
    }
    
    @RequestMapping(value= "/user/add", method = RequestMethod.POST)
    public String addUser(@Valid User u, @Valid User_Roles r, BindingResult result){
    	System.out.print("This is username"+ u.getUsername());
    	System.out.print("This is password"+u.getPassword());
    	
    	if(result.hasErrors()){
        	System.out.print(u);
            return "redirect:/login1?createFailMsg";

    	}else{
        
    		this.userService.addUser(u);
    		this.userService.addUserRole(r);
    		return "redirect:/login1?createSuccessMsg";}
         
    }
     
    @RequestMapping("/admin/remove/{id}")
    public String removeGift(@PathVariable("id") int id){
        this.giftService.removeGift(id);
        return "redirect:/admin";
    }
  
//    @RequestMapping(value = "/admin/edit/{id}", method = RequestMethod.GET)
//    public String editGift(@PathVariable("id") int id, Model model){
//        model.addAttribute("gift", this.giftService.getGiftById(id));
//        model.addAttribute("listWhoFors", this.giftService.listWhoFors());
//        model.addAttribute("listStores", this.giftService.listStores());
//        model.addAttribute("listGifts", this.giftService.listGifts());
//        model.addAttribute("listUsers", this.giftService.listUsers());
//        return "edit";
//    }
    
    @RequestMapping(value = "/admin/edit", method = RequestMethod.POST)
    public String editedGift(@ModelAttribute("gift") Gift g){
        giftService.editGift(g);
        return "redirect:/admin";
    }
    
    @RequestMapping(value = "/list/buy/{id}/{username}/{wholist}/{status}/", method = RequestMethod.POST)
    @ResponseBody
    public void buyGift(@PathVariable("id") int id, @PathVariable("username") String username, 
    		HttpServletRequest request, @PathVariable("status") Boolean status, 
    		@PathVariable("wholist") String wholist){
		    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
				String curuser = auth.getName();
    			giftService.buyGift(id, username);
    			giftService.listBoughtByYou(curuser);

    }
    
//    @RequestMapping(value = "/list/buy/{id}/{username}/{wholist}/{boughtMsg}")
//    public ModelAndView buyGift(@PathVariable("id") int id, @PathVariable("username") String username, 
//    		HttpServletRequest request, @PathVariable("boughtMsg") Boolean boughtMsg, 
//    		@PathVariable("wholist") String wholist){
//    	ModelAndView model = new ModelAndView(new RedirectView("/list"+"?"+ wholist, true));
//	    	if(giftService.checkStatus(id, username)){
//		    	giftService.buyGift(id, username);
//		    	return model;
//	    	}else{
//		    	model.addObject("boughtMsg", "Sorry. Item has already been bought.");
//		    	return model ;
//		    }
//    		
//
//    }
	
	//When search reads /login return login.jsp
	@RequestMapping(value = { "/","/login1"}, method = RequestMethod.GET)
	//Get error and logout as variables
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout,
		@RequestParam(value = "createSuccessMsg", required = false) String createSuccessMsg,
		@RequestParam(value = "createFailMsg", required = false) String createFailMsg){
		
	//If user has logged out or there is an error reported in the submitted form addObject
	  ModelAndView model = new ModelAndView();
	  model.addObject("user", new User());

	  if (error != null) {
		model.addObject("error", "Invalid username or password");
	  }
	  
	  if (createSuccessMsg != null) {
			model.addObject("createSuccessMsg", "You have been created.");
		  }
	  
	  if (createFailMsg != null) {
			model.addObject("createFailMsg","Invalid username or password.");
		  }
 
	  if (logout != null) {
		model.addObject("msg", "You've been logged out successfully");
	  }
	  model.setViewName("login1");
 
	  return model;
 
	}
 
	//for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {
 
	  ModelAndView model = new ModelAndView();
 
	  //check if user is login
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  if (!(auth instanceof AnonymousAuthenticationToken)) {
		UserDetails userDetail = (UserDetails) auth.getPrincipal();	
		model.addObject("username", userDetail.getUsername());
	  }
 
	  model.setViewName("403");
	  return model;
 
	}
	
 
}
