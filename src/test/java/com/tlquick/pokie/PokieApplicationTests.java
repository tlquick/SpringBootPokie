package com.tlquick.pokie;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import static org.junit.jupiter.api.Assertions.assertFalse;

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
	private Pokie pokie;


	@Test
	void testPlayerInit() {
		 Player player =  pokie.player();
		 assertEquals(player.getBalance(), 0.0);
	     assertThat(player.toString(), equalTo("Player: bet $0.0 balance $0.0 games played 0"));
	}
	@Test
	void testPlayerBalance() {
		 Player player =  pokie.player();
		 assertEquals(player.getBalance(), 0.0);
		 player.updateBalance(100);
		 assertEquals(player.getBalance(), 100.0);
		 player.collect();
		 assertEquals(player.getBalance(), 0.0);
	}
	@Test
	void testPlayerBet() {
		 Player player =  pokie.player();
		 assertTrue(player.noBet());
		 player.setBet(1);
		 assertEquals(player.getBet(), 1.0);
		 assertFalse(player.canBet(1));
		 player.updateBalance(100);
		 assertTrue(player.canBet(1));
		 player.placeBet(1);
		 assertThat(player.toString(), equalTo("Player: bet $1.0 balance $99.0 games played 1"));
	}
	@Test
	void testPokie_BetSpin() {

		pokie.addCredit(100);
		pokie.bet(1);
		pokie.betLines(3);
		pokie.spin();
		assertEquals(pokie.getResult().length(), 12);
		assertEquals(pokie.spins(), 1);
		assertEquals(pokie.turnover(), 3);
	}
	@Test
	void testReel() {
		Reel reel = new Reel(1,1);
		reel.spin();
		assertThat(reel.getResult(0), anyOf(is("J"), is("C"), is("O"), is("L")));
	}
	@Test
	void testLine() {
		Line line = new Line(1);
		assertEquals(line.payOff(), 200);
	}
}
