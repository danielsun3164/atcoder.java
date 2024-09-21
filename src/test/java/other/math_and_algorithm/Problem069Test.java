package other.math_and_algorithm;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem069Test extends TestBase {

	@Test
	void case1() {
		check("1 2 1 1", "2");
	}

	@Test
	void case2() {
		check("3 5 -4 -2", "-6");
	}

	@Test
	void case3() {
		check("-1000000000 0 -1000000000 0", "1000000000000000000");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC178/B");
	}
}
