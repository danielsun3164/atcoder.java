package abc174;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		in.input("2 3\n" + "7 9");
		ProblemE.main(null);
		assertResultIs("4");
	}

	@Test
	void case2() {
		in.input("3 0\n" + "3 4 5");
		ProblemE.main(null);
		assertResultIs("5");
	}

	@Test
	void case3() {
		in.input("10 10\n"
				+ "158260522 877914575 602436426 24979445 861648772 623690081 433933447 476190629 262703497 211047202");
		ProblemE.main(null);
		assertResultIs("292638192");
	}
}
