package abc.abc201_250.abc219;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemE別回答1Test extends TestBase {

	@Test
	void case1() {
		check("1 0 0 0\n" + "0 0 1 0\n" + "0 0 0 0\n" + "1 0 0 0", "1272");
	}

	@Test
	void case2() {
		check("1 1 1 1\n" + "1 1 1 1\n" + "1 1 1 1\n" + "1 1 1 1", "1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc219/E");
	}
}
