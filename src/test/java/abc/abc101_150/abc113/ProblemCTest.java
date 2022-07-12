package abc.abc101_150.abc113;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2 3\n" + "1 32\n" + "2 63\n" + "1 12", "000001000002" + LF + "000002000001" + LF + "000001000001");
	}

	@Test
	void case2() {
		check("2 3\n" + "2 55\n" + "2 77\n" + "2 99", "000002000001" + LF + "000002000002" + LF + "000002000003");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC113/C");
	}
}
