package abc.abc201_250.abc248;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("023456789", "1");
	}

	@Test
	void case2() {
		check("459230781", "6");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc248/A");
	}
}
