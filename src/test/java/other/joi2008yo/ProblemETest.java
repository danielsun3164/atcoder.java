package other.joi2008yo;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("2 5\n" + "0 1 0 1 0\n" + "1 0 0 0 1", "9");
	}

	@Test
	void case2() {
		check("3 6\n" + "1 0 0 0 1 0\n" + "1 1 1 0 1 0\n" + "1 0 1 1 0 1", "15");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("joi2008yo/E");
	}
}
