package abc.abc201_250.abc202;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("7\n" + "1 1 2 2 4 2\n" + "4\n" + "1 2\n" + "7 2\n" + "4 1\n" + "5 5",
				"3" + LF + "1" + LF + "0" + LF + "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc202/E");
	}
}
