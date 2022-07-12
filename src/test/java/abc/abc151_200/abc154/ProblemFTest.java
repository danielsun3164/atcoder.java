package abc.abc151_200.abc154;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("1 1 2 2", "14");
	}

	@Test
	void case2() {
		check("314 159 2653 589", "602215194");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC154/F");
	}
}
