package abc.abc201_250.abc226;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemG別回答1Test extends TestBase {

	@Test
	void case1() {
		check("3\n" + "5 1 0 0 1\n" + "0 0 0 2 1\n" + "0 3 0 0 0\n" + "0 0 2 0 0\n" + "10000000000000000 0 0 0 0\n"
				+ "0 0 0 0 2000000000000000", "Yes" + LF + "No" + LF + "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc226/G");
	}
}
