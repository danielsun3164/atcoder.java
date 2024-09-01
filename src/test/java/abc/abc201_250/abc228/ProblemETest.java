package abc.abc201_250.abc228;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("2 2 2", "16");
	}

	@Test
	void case2() {
		check("3 14 15926535", "109718301");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc228/E");
	}
}
