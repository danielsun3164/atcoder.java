package abc.abc101_150.abc141;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "3 6 5", "12");
	}

	@Test
	void case2() {
		check("4\n" + "23 36 66 65", "188");
	}

	@Test
	void case3() {
		check("20\n"
				+ "1008288677408720767 539403903321871999 1044301017184589821 215886900497862655 504277496111605629 972104334925272829 792625803473366909 972333547668684797 467386965442856573 755861732751878143 1151846447448561405 467257771752201853 683930041385277311 432010719984459389 319104378117934975 611451291444233983 647509226592964607 251832107792119421 827811265410084479 864032478037725181",
				"2012721721873704572");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC141/F");
	}
}
