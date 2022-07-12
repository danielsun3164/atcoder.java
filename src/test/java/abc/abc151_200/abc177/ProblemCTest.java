package abc.abc151_200.abc177;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1 2 3", "11");
	}

	@Test
	void case2() {
		check("4\n" + "141421356 17320508 22360679 244949", "437235829");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC177/C");
	}
}
