package other.math_and_algorithm;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem088Test extends TestBase {

	@Test
	void case1() {
		check("1 2 3", "18");
	}

	@Test
	void case2() {
		check("1000000000 987654321 123456789", "951633476");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC107/A");
	}
}
