package abc.abc151_200.abc180;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("2\n" + "0 0 0\n" + "1 2 3", "9");
	}

	@Test
	void case2() {
		check("3\n" + "0 0 0\n" + "1 1 1\n" + "-1 -1 -1", "10");
	}

	@Test
	void case3() {
		check("17\n" + "14142 13562 373095\n" + "-17320 508075 68877\n" + "223606 -79774 9979\n"
				+ "-24494 -89742 783178\n" + "26457 513110 -64591\n" + "-282842 7124 -74619\n"
				+ "31622 -77660 -168379\n" + "-33166 -24790 -3554\n" + "346410 16151 37755\n" + "-36055 51275 463989\n"
				+ "37416 -573867 73941\n" + "-3872 -983346 207417\n" + "412310 56256 -17661\n"
				+ "-42426 40687 -119285\n" + "43588 -989435 -40674\n" + "-447213 -59549 -99579\n" + "45825 7569 45584",
				"6519344");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC180/E");
	}
}
