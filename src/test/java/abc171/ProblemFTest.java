package abc171;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		in.input("5\n" + "oof");
		ProblemF.main(null);
		assertResultIs("575111451");
	}

	@Test
	void case2() {
		in.input("37564\n" + "whydidyoudesertme");
		ProblemF.main(null);
		assertResultIs("318008117");
	}
}
