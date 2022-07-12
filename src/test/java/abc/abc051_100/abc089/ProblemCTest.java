package abc.abc051_100.abc089;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "MASHIKE\n" + "RUMOI\n" + "OBIRA\n" + "HABORO\n" + "HOROKANAI", "2");
	}

	@Test
	void case2() {
		check("4\n" + "ZZ\n" + "ZZZ\n" + "Z\n" + "ZZZZZZZZZZ", "0");
	}

	@Test
	void case3() {
		check("5\n" + "CHOKUDAI\n" + "RNG\n" + "MAKOTO\n" + "AOKI\n" + "RINGO", "7");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC089/C");
	}
}
