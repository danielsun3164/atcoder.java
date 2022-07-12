package abc.abc101_150.abc143;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "3 1 2", "11");
	}

	@Test
	void case2() {
		check("7\n" + "5 0 7 8 3 3 2", "312");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC143/B");
	}
}
