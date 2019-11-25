package apg4b;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemEX10Test extends TestBase {

	@Test
	void case1() {
		in.input("5 9");
		ProblemEX10.main(null);
		assertResultIs("A:]]]]]" + LF + "B:]]]]]]]]]");
	}

	@Test
	void case2() {
		in.input("0 20");
		ProblemEX10.main(null);
		assertResultIs("A:" + LF + "B:]]]]]]]]]]]]]]]]]]]]");
	}
}
