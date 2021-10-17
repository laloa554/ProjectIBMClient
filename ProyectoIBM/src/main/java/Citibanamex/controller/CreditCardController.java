package Citibanamex.controller;

import java.util.List;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Citibanamex.service.CreditCardService;
import lombok.extern.slf4j.Slf4j;
import Citibanamex.entity.CreditCard;
import Citibanamex.message.Message;
import Citibanamex.model.CreditCardModel;

@RestController
@RequestMapping("/Citibanamex")
@CrossOrigin(origins = "*")
@Slf4j
public class CreditCardController {
	@Autowired
	CreditCardService CreditCardService;
	
	@GetMapping("/CreditCards")
    public ResponseEntity<List<CreditCard>> getCreditCards(){
    	List<CreditCard> creditCards = CreditCardService.list();
    	return ResponseEntity.ok(creditCards);
    }
	
	@PostMapping("/CreditCardType")
	public  ResponseEntity<?> CreditCardType(@Valid @RequestBody CreditCardModel model, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			log.warn("something is wrong");
            return  new ResponseEntity<Message>(new Message ("Something is wrong"),HttpStatus.BAD_REQUEST);
        }
		List<CreditCard> creditCards = CreditCardService.findByYourPassion(model.getYourPassion())
				.stream().filter(x -> 
				   model.getMonthlySalary() >=x.getMonthlySalaryMin() 
				&& model.getMonthlySalary() <= x.getMonthlySalaryMax()
				&& model.getAge() >= x.getAgeMin() 
				&& model.getAge() <= x.getAgeMax()
				)
				.collect(Collectors.toList());
		
		List<String> CreCar = creditCards.stream().map(x -> x.getCreditCard()).collect(Collectors.toList());
		log.info("return a credit card list");
		return CreCar.isEmpty()? new ResponseEntity<Message>(new Message ("No matches, sorry"),HttpStatus.OK):ResponseEntity.ok(CreCar);
	}
}
