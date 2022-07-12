package abc.abc151_200.abc181;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("2", "White");
	}

	@Test
	void case2() {
		check("5", "Black");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC181/A");
	}
}
