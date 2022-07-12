package abc.abc101_150.abc134;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "2\n" + "1\n" + "4\n" + "5\n" + "3", "2");
	}

	@Test
	void case2() {
		check("4\n" + "0\n" + "0\n" + "0\n" + "0", "4");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC134/E");
	}
}
