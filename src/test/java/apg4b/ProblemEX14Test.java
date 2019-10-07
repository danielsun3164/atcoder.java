package apg4b;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemEX14Test extends TestBase {

	@Test
	void test_Case1() {
		in.input("160 154 152");
		ProblemEX14.main(null);
		assertResultIs("8");
	}

	@Test
	void test_Case2() {
		in.input("200 200 200");
		ProblemEX14.main(null);
		assertResultIs("0");
	}

	@Test
	void test_Case3() {
		in.input("145 1 170");
		ProblemEX14.main(null);
		assertResultIs("169");
	}

	@Test
	void test_Case4() {
		in.input("150 190 160");
		ProblemEX14.main(null);
		assertResultIs("40");
	}
}
