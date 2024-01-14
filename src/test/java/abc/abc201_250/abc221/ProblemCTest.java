package abc.abc201_250.abc221;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("123", "63");
	}

	@Test
	void case2() {
		check("1010", "100");
	}

	@Test
	void case3() {
		check("998244353", "939337176");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc221/C");
	}
}
