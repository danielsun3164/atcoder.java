package abc.abc201_250.abc216;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("3 5\n" + "100 50 102", "502");
	}

	@Test
	void case2() {
		check("2 2021\n" + "2 3", "9");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc216/E");
	}
}
