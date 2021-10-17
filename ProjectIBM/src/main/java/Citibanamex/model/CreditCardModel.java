package Citibanamex.model;

import javax.validation.constraints.NotBlank;
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
	
	@NotBlank(message = "Your passion is requered")
	private String yourPassion;
	@NotNull(message = "Your monthly salary is requered")
	private double monthlySalary;
	@NotNull(message = "Your age is requered")
	private double age;
}