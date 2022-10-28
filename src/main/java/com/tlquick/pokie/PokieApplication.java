package com.tlquick.pokie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication

@RestController //reponseBody+controller component

public class PokieApplication {

	public static void main(String[] args) {
	SpringApplication.run(PokieApplication.class, args);
	
	}	
	@Autowired
    private Pokie pokie;
 
    @GetMapping("/index")
    public ModelAndView viewHomePage() {
    	 return  getModelAndView(); 
    }
	
	  @GetMapping("/addCredit") 
	  public ModelAndView addCredit() {
		  pokie.player().updateBalance(20); 
		  return  getModelAndView(); 
	  }
	  @GetMapping("/collect") 
	  public ModelAndView collect() { 
		  pokie.player().collect(); 
		  return  getModelAndView(); 
	  }
	  @GetMapping("/credits/{id}") 
	  public ModelAndView credits(@PathVariable int id) { 
		  pokie.player().setBet(id); 
		  return  getModelAndView(); 
	  }
	  @GetMapping("/lines/{id}") 
	  public ModelAndView lines(@PathVariable int id) { 
		  pokie.betLines(id); 
		  return  getModelAndView(); 
	  }
	  @GetMapping("/spin") 
	  public ModelAndView spin(Model model) { 

		  if(pokie.player().canBet(pokie.getBetLines()))
		  {
			  pokie.spin(); 
		      pokie.payOut();
		  }
		  return  getModelAndView(); 
	  }
	  public ModelAndView getModelAndView()
	  {
		  ModelAndView mav = new ModelAndView("index");
		  mav.addObject("playerBalance", pokie.player().getBalance()); 
		  mav.addObject("turnOver", pokie.turnover());
		  mav.addObject("payOuts", pokie.payouts());
		  mav.addObject("spins", pokie.spins());
		  mav.addObject("betLines", pokie.getBetLines());
		  mav.addObject("bet", pokie.player().getBet());
		  mav.addObject("msg", pokie.getMsg());
		  mav.addObject("images", pokie.lines().getResultImages());
		  return  mav; 
	  }
	
}
