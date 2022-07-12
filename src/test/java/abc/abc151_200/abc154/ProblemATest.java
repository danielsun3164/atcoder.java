package abc.abc151_200.abc154;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("red blue\n" + "3 4\n" + "red", "2 4");
	}

	@Test
	void case2() {
		check("red blue\n" + "5 5\n" + "blue", "5 4");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC154/A");
	}
}
