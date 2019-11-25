package apg4b;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemEX24Test extends TestBase {

	@Test
	void case1() {
		in.input("0 0 0\n" + "90");
		ProblemEX24.main(null);
		assertResultIs("00:00:00" + LF + "00:01:30");
	}

	@Test
	void case2() {
		in.input("0 0 0\n" + "-5");
		ProblemEX24.main(null);
		assertResultIs("00:00:00" + LF + "23:59:55");
	}

	@Test
	void case3() {
		in.input("23 59 30\n" + "30");
		ProblemEX24.main(null);
		assertResultIs("23:59:30" + LF + "00:00:00");
	}

	@Test
	void case4() {
		in.input("6 57 9\n" + "-4195");
		ProblemEX24.main(null);
		assertResultIs("06:57:09" + LF + "05:47:14");
	}
}
