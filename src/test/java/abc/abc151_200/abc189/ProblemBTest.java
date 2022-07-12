package abc.abc151_200.abc189;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("2 15\n" + "200 5\n" + "350 3", "2");
	}

	@Test
	void case2() {
		check("2 10\n" + "200 5\n" + "350 3", "2");
	}

	@Test
	void case3() {
		check("3 1000000\n" + "1000 100\n" + "1000 100\n" + "1000 100", "-1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC189/B");
	}
}
