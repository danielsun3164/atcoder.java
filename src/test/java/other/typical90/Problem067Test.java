package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem067Test extends TestBase {

	@Test
	void case1() {
		check("21 1", "15");
	}

	@Test
	void case2() {
		check("1330 1", "555");
	}

	@Test
	void case3() {
		check("2311640221315 15", "474547");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/067");
	}
}
