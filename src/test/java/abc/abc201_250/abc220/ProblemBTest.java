package abc.abc201_250.abc220;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("2\n" + "1011 10100", "220");
	}

	@Test
	void case2() {
		check("7\n" + "123 456", "15642");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc220/B");
	}
}
