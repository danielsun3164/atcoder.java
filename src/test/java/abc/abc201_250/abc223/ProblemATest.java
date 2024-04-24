package abc.abc201_250.abc223;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("500", "Yes");
	}

	@Test
	void case2() {
		check("40", "No");
	}

	@Test
	void case3() {
		check("0", "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc223/A");
	}
}
