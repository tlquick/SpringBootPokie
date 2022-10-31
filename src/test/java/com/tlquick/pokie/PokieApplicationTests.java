package com.tlquick.pokie;

import static org.junit.jupiter.api.Assertions.assertNotNull;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ContextConfiguration(classes=PokieApplication.class)
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class PokieApplicationTests {

	@Autowired
	PokieApplication app;
	
	
	@Test
	void testPokieApplicationIndex() {
		
		assertNotNull(app.viewHomePage());
	}
	
	@Test
	void testPokieApplicationAddCredit() {
		
		assertNotNull(app.addCredit());
	}
	@Test
	void testPokieApplicationCollect() {
		
		assertNotNull(app.collect());
	}
	@Test
	void testPokieCredits() {
		
		assertNotNull(app.credits(1));
	}
	@Test
	void testPokieApplicationLines() {
		
		assertNotNull(app.lines(1));
	}
	
}
