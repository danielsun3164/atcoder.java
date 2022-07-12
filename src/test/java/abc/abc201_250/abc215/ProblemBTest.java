package abc.abc201_250.abc215;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("6", "2");
	}

	@Test
	void case2() {
		check("1", "0");
	}

	@Test
	void case3() {
		check("1000000000000000000", "59");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc215/B");
	}
}
