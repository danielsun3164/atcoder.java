package abc.abc201_250.abc215;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3 12\n" + "6 1 5", "3" + LF + "1" + LF + "7" + LF + "11");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc215/D");
	}
}
