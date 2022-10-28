package com.tlquick.pokie;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ContextConfiguration(classes=PokieApplication.class)
@ExtendWith(SpringExtension.class)
public class ReelTest {
	
	@Test
	void testReel() {
		Reel reel = new Reel(1,1);
		reel.spin();
		assertThat(reel.getResult(0), anyOf(is("J"), is("C"), is("O"), is("L")));
	}
}
