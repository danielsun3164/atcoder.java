package abc004;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("1");
		ProblemC.main(null);
		assertResultIs("213456");
	}

	@Test
	void case2() {
		in.input("5");
		ProblemC.main(null);
		assertResultIs("234561");
	}

	@Test
	void case3() {
		in.input("22");
		ProblemC.main(null);
		assertResultIs("615234");
	}

	@Test
	void case4() {
		in.input("100000000");
		ProblemC.main(null);
		assertResultIs("345612");
	}
}
