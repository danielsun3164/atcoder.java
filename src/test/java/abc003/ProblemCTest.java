package abc003;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("2 2\n" + "1000 1500");
		ProblemC.main(null);
		assertResultIs(1000.0d);
	}

	@Test
	void test_Case2() {
		in.input("2 1\n" + "1000 1500");
		ProblemC.main(null);
		assertResultIs(750.0d);
	}

	@Test
	void test_Case3() {
		in.input("10 5\n" + "2604 2281 3204 2264 2200 2650 2229 2461 2439 2211");
		ProblemC.main(null);
		assertResultIs(2820.03125d);
	}
}
