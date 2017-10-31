package org.ruler.demo;

import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ruler.demo.calc.RandomGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application.properties ")
@ImportResource("classpath:beans.xml")
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Value("${seedConfig}")
	public int mySeed;
	
	@Autowired
	@Qualifier("bound")
	private int myBound;
	
	@Test
	public void testSeedValue() {
		assertNotNull(mySeed);
		assertTrue(mySeed > 0);
	}
	
	@Test
	public void testBoundValue() {
		assertTrue(myBound > 0);
	}
	
	@Test
	public void testGenerateInt() {
		RandomGenerator rg = new RandomGenerator(mySeed);
		rg.setBound(myBound);
		assertTrue(rg.getRandomInt() > 0);
	}
}
