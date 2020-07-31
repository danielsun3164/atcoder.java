package abc171;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("2");
		ProblemC.main(null);
		assertResultIs("b");
	}

	@Test
	void case2() {
		in.input("27");
		ProblemC.main(null);
		assertResultIs("aa");
	}

	@Test
	void case3() {
		in.input("123456789");
		ProblemC.main(null);
		assertResultIs("jjddja");
	}

	@Test
	void case4() {
		in.input("1000000000000001");
		ProblemC.main(null);
		assertResultIs("gbdpxgrzxjm");
	}

	@Test
	void case5() {
		in.input("26");
		ProblemC.main(null);
		assertResultIs("z");
	}
}
