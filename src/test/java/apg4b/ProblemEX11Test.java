package apg4b;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemEX11Test extends TestBase {

	@Test
	void case1() {
		in.input("3\n" + "2\n" + "+ 1\n" + "* 3\n" + "/ 2");
		ProblemEX11.main(null);
		assertResultIs("1:3" + LF + "2:9" + LF + "3:4");
	}

	@Test
	void case2() {
		in.input("2\n" + "3\n" + "/ 2\n" + "/ 2");
		ProblemEX11.main(null);
		assertResultIs("1:1" + LF + "2:0");
	}

	@Test
	void case3() {
		in.input("4\n" + "3\n" + "+ 1\n" + "/ 0\n" + "* 2\n" + "- 10");
		ProblemEX11.main(null);
		assertResultIs("1:4" + LF + "error");
	}

	@Test
	void case4() {
		in.input("7\n" + "10\n" + "* 10\n" + "* 10\n" + "* 10\n" + "* 10\n" + "* 10\n" + "* 10\n" + "* 10");
		ProblemEX11.main(null);
		assertResultIs("1:100" + LF + "2:1000" + LF + "3:10000" + LF + "4:100000" + LF + "5:1000000" + LF + "6:10000000"
				+ LF + "7:100000000");
	}
}
