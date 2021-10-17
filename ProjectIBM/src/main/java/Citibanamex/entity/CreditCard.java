package Citibanamex.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Credit_Cards")
@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreditCard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private long id;
	
	@Column(name = "your_Passion", nullable = false, length = 150)
	private String yourPassion;
	
	@Column(name = "monthly_Salary_Min", nullable = false)
	private double monthlySalaryMin;
	
	@Column(name = "monthly_Salary_Max", nullable = false)
	private double monthlySalaryMax;
	
	@Column(name = "age_Min", nullable = false)
	private double ageMin;
	
	@Column(name = "age_Max", nullable = false)
	private double ageMax;
	
	@Column(name = "credit_Card", nullable = false, length = 150)
	private String creditCard;
}