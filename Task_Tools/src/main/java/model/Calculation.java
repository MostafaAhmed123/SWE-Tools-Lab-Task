package model;
import javax.persistence.*;

import javax.ejb.Stateless;

/**
 * Entity implementation class for Entity: Calculation
 *
 */
@Entity
@Stateless
public class Calculation{

	public Calculation() {}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private int Number1;
	private int Number2;
	private String Operation;
	private double Result;
	public void setNum1(int n) {
		Number1 = n;
	}
	public void setNum2(int n) {
		Number2 = n;
	}
	public void setOperation(String Op) {
		Operation = Op;
	}
	public void setResult(double r) {
		Result = r;
	}
	public int getId() {
		return id;
	}
	public int getNumber1() {
		return Number1;
	}
	public int getNumber2() {
		return Number2;
	}
	public String getOperation() {
		return Operation;
	}
	public double getResult() {
		return Result;
	}
}
