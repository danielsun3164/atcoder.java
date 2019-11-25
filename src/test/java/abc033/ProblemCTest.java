package abc033;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("0+0+2*0");
		ProblemC.main(null);
		assertResultIs("0");
	}

	@Test
	void case2() {
		in.input("3*1+1*2");
		ProblemC.main(null);
		assertResultIs("2");
	}

	@Test
	void case3() {
		in.input("3*1*4+0+2*0+5*2+9*8*6+1+3");
		ProblemC.main(null);
		assertResultIs("5");
	}
}
