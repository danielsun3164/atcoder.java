package abc.abc151_200.abc155;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "6 7 9 10 31", "APPROVED");
	}

	@Test
	void case2() {
		check("3\n" + "28 27 24", "DENIED");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC155/B");
	}
}
