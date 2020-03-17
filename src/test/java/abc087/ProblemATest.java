package abc087;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("1234\n" + "150\n" + "100");
		ProblemA.main(null);
		assertResultIs("84");
	}

	@Test
	void case2() {
		in.input("1000\n" + "108\n" + "108");
		ProblemA.main(null);
		assertResultIs("28");
	}

	@Test
	void case3() {
		in.input("579\n" + "123\n" + "456");
		ProblemA.main(null);
		assertResultIs("0");
	}

	@Test
	void case4() {
		in.input("7477\n" + "549\n" + "593");
		ProblemA.main(null);
		assertResultIs("405");
	}
}
