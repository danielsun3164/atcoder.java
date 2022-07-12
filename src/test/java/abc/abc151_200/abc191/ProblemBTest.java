package abc.abc151_200.abc191;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("5 5\n" + "3 5 6 5 4", "3 6 4");
	}

	@Test
	void case2() {
		check("3 3\n" + "3 3 3", "");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC191/B");
	}
}
