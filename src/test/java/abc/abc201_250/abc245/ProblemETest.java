package abc.abc201_250.abc245;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("2 3\n" + "2 4\n" + "3 2\n" + "8 1 5\n" + "2 10 5", "Yes");
	}

	@Test
	void case2() {
		check("2 2\n" + "1 1\n" + "2 2\n" + "100 1\n" + "100 1", "No");
	}

	@Test
	void case3() {
		check("1 1\n" + "10\n" + "100\n" + "100\n" + "10", "No");
	}

	@Test
	void case4() {
		check("1 1\n" + "10\n" + "100\n" + "10\n" + "100", "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc245/E");
	}
}
