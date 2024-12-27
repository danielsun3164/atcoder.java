package abc.abc201_250.abc239;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("0 0 3 3", "Yes");
	}

	@Test
	void case2() {
		check("0 1 2 3", "No");
	}

	@Test
	void case3() {
		check("1000000000 1000000000 999999999 999999999", "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc239/C");
	}
}
