package past201912;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		in.input("FisHDoGCaTAAAaAAbCAC");
		ProblemF.main(null);
		assertResultIs("AAAaAAbCACCaTDoGFisH");
	}

	@Test
	void case2() {
		in.input("AAAAAjhfgaBCsahdfakGZsZGdEAA");
		ProblemF.main(null);
		assertResultIs("AAAAAAAjhfgaBCsahdfakGGdEZsZ");
	}

	@Test
	void case3() {
		in.input("AAABAAAC");
		ProblemF.main(null);
		assertResultIs("AAAAABAC");
	}
}
