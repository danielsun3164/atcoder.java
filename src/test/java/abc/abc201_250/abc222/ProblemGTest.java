package abc.abc201_250.abc222;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemGTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "1\n" + "7\n" + "10\n" + "999983", "1" + LF + "6" + LF + "-1" + LF + "999982");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc222/G");
	}
}
