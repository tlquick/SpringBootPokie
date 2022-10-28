package com.tlquick.pokie;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class ReelsTest {
	
	@Test
	void testReels() {
		Reels reels = new Reels(3,3);
		assertThat(reels.getResult(1), anyOf(containsString("J"), containsString("C"), containsString("O"), containsString("L")));
	}
}
