package org.ruler.demo.calc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.ruler.demo.CalcApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

@Configuration
//default in boot
//@PropertySource("classpath:application.properties")
@ImportResource("classpath:beans.xml")
@ComponentScan("org.ruler.demo.calc")
public class CalcConfig {

	//beans.xml
	@Autowired
	@Qualifier("bound")
	private int myBound;
	
	@Bean
	@Primary
	//default value using propeties file
	RandomGenerator randomDefaultGenerator(@Value("${seedConfig}") long seed) {
	//RandomGenerator randomDefaultGenerator() {
		System.out.println("myRG1");
		RandomGenerator rg = new RandomGenerator(seed);
		rg.setBound(myBound);
		return rg;
	}
	
	@Bean
	RandomGenerator random2HGenerator() {
		System.out.println("myRG2");
		return new RandomGenerator(200L);
	}

}
