package abc.abc171;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "oof", "575111451");
	}

	@Test
	void case2() {
		check("37564\n" + "whydidyoudesertme", "318008117");
	}
}
