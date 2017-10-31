package org.ruler.demo;

import org.ruler.demo.calc.RandomGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

//required, otherwised run() is not called
@Component
//@EnableAutoConfiguration
public class CalcApplication implements CommandLineRunner {

	@Autowired(required=true)
	private RandomGenerator rg;
	
	//@Autowired(required=true)
	//public void setRandomGenerator(RandomGenerator randomGenerator) {
	//	System.out.println("RG setter called "+randomGenerator);
	//	this.rg = randomGenerator;
	//}
	
	//prevented autowiring by instantiation of a custom CalCapplication object 
	//within a main method
	@Override
	public void run(String... args) throws Exception {
		demo();
	}	 

	public void demo() {
		System.out.println("random generator: "+rg);
		int i = rg.getRandomInt();
		System.out.println("***********************");
		System.out.printf("Generated Integer: %d%n", i);
		System.out.println("***********************");
	}
}
