package abc.abc201_250.abc227;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("KEY\n" + "1", "3");
	}

	@Test
	void case2() {
		check("KKEE\n" + "2", "4");
	}

	@Test
	void case3() {
		check("KKEEYY\n" + "1000000000", "90");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc227/E");
	}
}
