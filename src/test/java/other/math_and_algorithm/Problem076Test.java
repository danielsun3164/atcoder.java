package other.math_and_algorithm;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem076Test extends TestBase {

	@Test
	void case1() {
		check("3\n" + "5 1 2", "8");
	}

	@Test
	void case2() {
		check("5\n" + "31 41 59 26 53", "176");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC186/D");
	}
}
