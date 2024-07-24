package abc.abc201_250.abc230;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("3", "5");
	}

	@Test
	void case2() {
		check("10000000000", "231802823220");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc230/E");
	}
}
