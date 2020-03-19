package abc089;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("5\n" + "MASHIKE\n" + "RUMOI\n" + "OBIRA\n" + "HABORO\n" + "HOROKANAI");
		ProblemC.main(null);
		assertResultIs("2");
	}

	@Test
	void case2() {
		in.input("4\n" + "ZZ\n" + "ZZZ\n" + "Z\n" + "ZZZZZZZZZZ");
		ProblemC.main(null);
		assertResultIs("0");
	}

	@Test
	void case3() {
		in.input("5\n" + "CHOKUDAI\n" + "RNG\n" + "MAKOTO\n" + "AOKI\n" + "RINGO");
		ProblemC.main(null);
		assertResultIs("7");
	}
}
