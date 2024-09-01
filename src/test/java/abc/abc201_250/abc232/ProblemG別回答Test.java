package abc.abc201_250.abc232;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemG別回答Test extends TestBase {

	@Test
	void case1() {
		check("4 12\n" + "10 11 6 0\n" + "8 7 4 1", "3");
	}

	@Test
	void case2() {
		check("10 1000\n" + "785 934 671 520 794 168 586 667 411 332\n" + "363 763 40 425 524 311 139 875 548 198",
				"462");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc232/G");
	}
}
