package abc070;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("2\n" + "2\n" + "3");
		ProblemC.main(null);
		assertResultIs("6");
	}

	@Test
	void case2() {
		in.input("5\n" + "2\n" + "5\n" + "10\n" + "1000000000000000000\n" + "1000000000000000000");
		ProblemC.main(null);
		assertResultIs("1000000000000000000");
	}
}
