package abc033;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("0+0+2*0");
		ProblemC.main(null);
		assertResultIs("0");
	}

	@Test
	void test_Case2() {
		in.input("3*1+1*2");
		ProblemC.main(null);
		assertResultIs("2");
	}

	@Test
	void test_Case3() {
		in.input("3*1*4+0+2*0+5*2+9*8*6+1+3");
		ProblemC.main(null);
		assertResultIs("5");
	}
}
