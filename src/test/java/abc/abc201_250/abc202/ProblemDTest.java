package abc.abc201_250.abc202;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("2 2 4", "baab");
	}

	@Test
	void case2() {
		check("30 30 118264581564861424", "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc202/D");
	}
}
