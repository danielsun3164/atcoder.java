package other.joi2006yo;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "A a\n" + "0 5\n" + "5 4\n" + "10\n" + "A\n" + "B\n" + "C\n" + "0\n" + "1\n" + "4\n" + "5\n"
				+ "a\n" + "b\n" + "A", "aBC5144aba");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("joi2006yo/B");
	}
}
