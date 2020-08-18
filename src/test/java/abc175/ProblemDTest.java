package abc175;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("5 2\n" + "2 4 5 1 3\n" + "3 4 -10 -8 8");
		ProblemD.main(null);
		assertResultIs("8");
	}

	@Test
	void case2() {
		in.input("2 3\n" + "2 1\n" + "10 -7");
		ProblemD.main(null);
		assertResultIs("13");
	}

	@Test
	void case3() {
		in.input("3 3\n" + "3 1 2\n" + "-1000 -2000 -3000");
		ProblemD.main(null);
		assertResultIs("-1000");
	}

	@Test
	void case4() {
		in.input("10 58\n" + "9 1 6 7 8 4 3 2 10 5\n"
				+ "695279662 988782657 -119067776 382975538 -151885171 -177220596 -169777795 37619092 389386780 980092719");
		ProblemD.main(null);
		assertResultIs("29507023469");
	}
}
