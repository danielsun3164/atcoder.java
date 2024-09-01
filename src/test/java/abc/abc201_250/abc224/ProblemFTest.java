package abc.abc201_250.abc224;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("1234", "1736");
	}

	@Test
	void case2() {
		check("1", "1");
	}

	@Test
	void case3() {
		check("31415926535897932384626433832795", "85607943");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc224/F");
	}
}
