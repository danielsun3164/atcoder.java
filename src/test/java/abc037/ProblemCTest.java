package abc037;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("5 3\n" + "1 2 4 8 16");
		ProblemC.main(null);
		assertResultIs("49");
	}

	@Test
	void test_Case2() {
		in.input("20 10\n"
				+ "100000000 100000000 98667799 100000000 100000000 100000000 100000000 99986657 100000000 100000000 100000000 100000000 100000000 98995577 100000000 100000000 99999876 100000000 100000000 99999999");
		ProblemC.main(null);
		assertResultIs("10988865195");
	}

	@Test
	void test_Case3() {
		in.input("3 3\n" + "1 2 3");
		ProblemC.main(null);
		assertResultIs("6");
	}
}
