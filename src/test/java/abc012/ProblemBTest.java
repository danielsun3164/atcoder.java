package abc012;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("3661");
		ProblemB.main(null);
		assertResultIs("01:01:01");
	}

	@Test
	void case2() {
		in.input("86399");
		ProblemB.main(null);
		assertResultIs("23:59:59");
	}
}
