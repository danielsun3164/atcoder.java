package abc.abc151_200.abc188;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("3 5", "Yes");
	}

	@Test
	void case2() {
		check("16 2", "No");
	}

	@Test
	void case3() {
		check("12 15", "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC188/A");
	}
}
