package abc077;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("10");
		ProblemB.main(null);
		assertResultIs("9");
	}

	@Test
	void case2() {
		in.input("81");
		ProblemB.main(null);
		assertResultIs("81");
	}

	@Test
	void case3() {
		in.input("271828182");
		ProblemB.main(null);
		assertResultIs("271821169");
	}
}
