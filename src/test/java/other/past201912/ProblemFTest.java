package other.past201912;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

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
