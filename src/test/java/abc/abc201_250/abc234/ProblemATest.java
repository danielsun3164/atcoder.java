package abc.abc201_250.abc234;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("0", "1371");
	}

	@Test
	void case2() {
		check("3", "722502");
	}

	@Test
	void case3() {
		check("10", "1111355571");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc234/A");
	}
}
