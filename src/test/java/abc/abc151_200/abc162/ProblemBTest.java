package abc.abc151_200.abc162;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("15", "60");
	}

	@Test
	void case2() {
		check("1000000", "266666333332");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC162/B");
	}
}
