package abc.abc201_250.abc245;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("8\n" + "0 3 2 6 2 1 0 0", "4");
	}

	@Test
	void case2() {
		check("3\n" + "2000 2000 2000", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc245/B");
	}
}
