package abc.abc201_250.abc216;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("2\n" + "3 1\n" + "1 2", "2");
	}

	@Test
	void case2() {
		check("2\n" + "1 1\n" + "2 2", "0");
	}

	@Test
	void case3() {
		check("20\n"
				+ "1937 3980 2689 1208 3640 1979 581 2271 4229 3948 3708 1522 4161 4661 3797 96 3388 3395 2920 2247\n"
				+ "4485 2580 174 1156 3770 3396 3558 3500 3494 479 269 3383 1230 1711 3545 3919 134 475 3796 1017",
				"476");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc216/F");
	}
}
