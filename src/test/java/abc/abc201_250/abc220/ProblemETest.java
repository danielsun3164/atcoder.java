package abc.abc201_250.abc220;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("3 2", "14");
	}

	@Test
	void case2() {
		check("14142 17320", "11284501");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc220/E");
	}
}
