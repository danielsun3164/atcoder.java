package other.math_and_algorithm;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem052Test extends TestBase {

	@Test
	void case1() {
		check("3 3", "2");
	}

	@Test
	void case2() {
		check("2 2", "0");
	}

	@Test
	void case3() {
		check("999999 999999", "151840682");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC145/D");
	}
}
