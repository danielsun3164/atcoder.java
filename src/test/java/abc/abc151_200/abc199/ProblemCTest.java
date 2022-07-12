package abc.abc151_200.abc199;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2\n" + "FLIP\n" + "2\n" + "2 0 0\n" + "1 1 4", "LPFI");
	}

	@Test
	void case2() {
		check("2\n" + "FLIP\n" + "6\n" + "1 1 3\n" + "2 0 0\n" + "1 1 2\n" + "1 2 3\n" + "2 0 0\n" + "1 1 4", "ILPF");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc199/C");
	}
}
