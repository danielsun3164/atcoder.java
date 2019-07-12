package abc039;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("WBWBWWBWBWBWWBWBWWBW");
		ProblemC.main(null);
		assertResultIs("Do");
	}

	@Test
	void test_Case2() {
		in.input("WWBWBWWBWBWBWWBWBWW");
		ProblemC.main(null);
		assertResultIs("Si");
	}
}
