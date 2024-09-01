package abc.abc201_250.abc233;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("80 94", "2");
	}

	@Test
	void case2() {
		check("1000 63", "0");
	}

	@Test
	void case3() {
		check("270 750", "48");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc233/A");
	}
}
