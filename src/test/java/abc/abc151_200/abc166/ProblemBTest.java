package abc.abc151_200.abc166;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3 2\n" + "2\n" + "1 3\n" + "1\n" + "3", "1");
	}

	@Test
	void case2() {
		check("3 3\n" + "1\n" + "3\n" + "1\n" + "3\n" + "1\n" + "3", "2");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC166/B");
	}
}
