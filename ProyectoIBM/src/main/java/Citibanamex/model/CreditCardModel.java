package Citibanamex.model;


import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardModel {
	
	@NotNull
	private String yourPassion;
	@NotNull
	private double monthlySalary;
	@NotNull
	private double age;
}
