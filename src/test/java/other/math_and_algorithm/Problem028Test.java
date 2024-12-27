package other.math_and_algorithm;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem028Test extends TestBase {

	@Test
	void case1() {
		check("4\n" + "10 30 40 20", "30");
	}

	@Test
	void case2() {
		check("2\n" + "10 10", "0");
	}

	@Test
	void case3() {
		check("6\n" + "30 10 60 10 60 50", "40");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("dp/A");
	}
}
