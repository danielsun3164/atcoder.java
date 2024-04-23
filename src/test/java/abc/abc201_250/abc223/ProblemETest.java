package abc.abc201_250.abc223;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("3 3 2 2 3", "Yes");
	}

	@Test
	void case2() {
		check("3 3 4 4 1", "No");
	}

	@Test
	void case3() {
		check("1000000000 1000000000 1000000000000000000 1000000000000000000 1000000000000000000", "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc223/E");
	}
}
