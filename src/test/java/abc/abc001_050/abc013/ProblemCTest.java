package abc.abc001_050.abc013;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("4 5\n" + "100 4 60 1 4", "160");
	}

	@Test
	void case2() {
		check("10 1\n" + "5000 2 2000 1 300", "20000");
	}

	@Test
	void case3() {
		check("9 23\n" + "170 8 120 5 12", "650");
	}

	@Test
	void case4() {
		check("653 314159\n" + "6728 123456 5141 41928 222222", "2818162");
	}
}
