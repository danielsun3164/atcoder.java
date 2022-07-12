package abc.abc151_200.abc169;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("2 5", "10");
	}

	@Test
	void case2() {
		check("100 100", "10000");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC169/A");
	}
}
