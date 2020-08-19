package past201912;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("FisHDoGCaTAAAaAAbCAC", "AAAaAAbCACCaTDoGFisH");
	}

	@Test
	void case2() {
		check("AAAAAjhfgaBCsahdfakGZsZGdEAA", "AAAAAAAjhfgaBCsahdfakGGdEZsZ");
	}

	@Test
	void case3() {
		check("AAABAAAC", "AAAAABAC");
	}
}
