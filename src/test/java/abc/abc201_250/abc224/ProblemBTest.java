package abc.abc201_250.abc224;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3 3\n" + "2 1 4\n" + "3 1 3\n" + "6 4 1", "Yes");
	}

	@Test
	void case2() {
		check("2 4\n" + "4 3 2 1\n" + "5 6 7 8", "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc224/B");
	}
}
