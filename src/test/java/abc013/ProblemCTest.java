package abc013;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("4 5\n" + "100 4 60 1 4");
		ProblemC.main(null);
		assertResultIs("160");
	}

	@Test
	void case2() {
		in.input("10 1\n" + "5000 2 2000 1 300");
		ProblemC.main(null);
		assertResultIs("20000");
	}

	@Test
	void case3() {
		in.input("9 23\n" + "170 8 120 5 12");
		ProblemC.main(null);
		assertResultIs("650");
	}

	@Test
	void case4() {
		in.input("653 314159\n" + "6728 123456 5141 41928 222222");
		ProblemC.main(null);
		assertResultIs("2818162");
	}
}
