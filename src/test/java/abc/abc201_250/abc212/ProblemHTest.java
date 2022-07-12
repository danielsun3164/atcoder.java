package abc.abc201_250.abc212;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemHTest extends TestBase {

	@Test
	void case1() {
		check("2 2\n" + "1 2", "4");
	}

	@Test
	void case2() {
		check("100 3\n" + "3 5 7", "112184936");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc212/H");
	}
}
