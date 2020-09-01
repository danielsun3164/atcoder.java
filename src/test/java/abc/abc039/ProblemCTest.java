package abc.abc039;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("WBWBWWBWBWBWWBWBWWBW", "Do");
	}

	@Test
	void case2() {
		check("WWBWBWWBWBWBWWBWBWW", "Si");
	}
}
