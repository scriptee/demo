package org.ruler.demo.calc;

import java.util.Random;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

@Component
public class RandomGenerator {
		
	private Random random;
	private int bound;

	
	public RandomGenerator() { 
		System.out.println("default constructor");
	}
		
	public RandomGenerator(long seed) {
		this.random = new Random(seed);
	}
	
	//creates exception if setter injection not possible
	//@Required
	public void setBound(int bound) {
		System.out.println("random generator bound: "+bound);
		this.bound = bound;
	}
	
	public int getRandomInt() {
		return random.nextInt(bound);
	}

}
