package abc.abc151_200.abc171;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2", "b");
	}

	@Test
	void case2() {
		check("27", "aa");
	}

	@Test
	void case3() {
		check("123456789", "jjddja");
	}

	@Test
	void case4() {
		check("1000000000000001", "gbdpxgrzxjm");
	}

	@Test
	void case5() {
		check("26", "z");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC171/C");
	}
}
