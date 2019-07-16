package abc040;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("5 4\n" + "1 2 2000\n" + "2 3 2004\n" + "3 4 1999\n" + "4 5 2001\n" + "3\n" + "1 2000\n" + "1 1999\n"
				+ "3 1995");
		ProblemD.main(null);
		assertResultIs("1" + LF + "3" + LF + "5");
	}

	@Test
	void test_Case2() throws IOException {
		in.input("4 5\n" + "1 2 2005\n" + "3 1 2001\n" + "3 4 2002\n" + "1 4 2004\n" + "4 2 2003\n" + "5\n" + "1 2003\n"
				+ "2 2003\n" + "1 2001\n" + "3 2003\n" + "4 2004");
		ProblemD.main(null);
		assertResultIs("3" + LF + "3" + LF + "4" + LF + "1" + LF + "1");
	}

	@Test
	void test_Case3() {
		in.input("4 5\n" + "1 2 10\n" + "1 2 1000\n" + "2 3 10000\n" + "2 3 100000\n" + "3 1 200000\n" + "4\n" + "1 0\n"
				+ "2 10000\n" + "3 100000\n" + "4 0");
		ProblemD.main(null);
		assertResultIs("3" + LF + "3" + LF + "2" + LF + "1");
	}
}
