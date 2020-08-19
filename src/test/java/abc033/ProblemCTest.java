package abc033;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("0+0+2*0", "0");
	}

	@Test
	void case2() {
		check("3*1+1*2", "2");
	}

	@Test
	void case3() {
		check("3*1*4+0+2*0+5*2+9*8*6+1+3", "5");
	}
}
