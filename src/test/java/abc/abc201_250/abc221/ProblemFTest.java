package abc.abc201_250.abc221;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "1 2\n" + "1 3\n" + "1 4\n" + "4 5", "2");
	}

	@Test
	void case2() {
		check("4\n" + "1 2\n" + "1 3\n" + "1 4", "4");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc221/F");
	}
}
