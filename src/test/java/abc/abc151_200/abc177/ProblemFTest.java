package abc.abc151_200.abc177;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("4 4\n" + "2 4\n" + "1 1\n" + "2 3\n" + "2 4", "1" + LF + "3" + LF + "6" + LF + "-1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC177/F");
	}
}
