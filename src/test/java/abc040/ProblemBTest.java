package abc040;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("26");
		ProblemB.main(null);
		assertResultIs("1");
	}

	@Test
	void test_Case2() {
		in.input("41");
		ProblemB.main(null);
		assertResultIs("4");
	}

	@Test
	void test_Case3() {
		in.input("100000");
		ProblemB.main(null);
		assertResultIs("37");
	}
}
