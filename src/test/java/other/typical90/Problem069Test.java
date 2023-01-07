package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem069Test extends TestBase {

	@Test
	void case1() {
		check("2 3", "6");
	}

	@Test
	void case2() {
		check("10 2", "0");
	}

	@Test
	void case3() {
		check("2021 617", "53731843");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/069");
	}
}
