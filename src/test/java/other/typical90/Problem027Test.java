package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem027Test extends TestBase {

	@Test
	void case1() {
		check("5\n" + "e869120\n" + "atcoder\n" + "e869120\n" + "square1001\n" + "square1001",
				"1" + LF + "2" + LF + "4");
	}

	@Test
	void case2() {
		check("4\n" + "taro\n" + "hanako\n" + "yuka\n" + "takashi", "1" + LF + "2" + LF + "3" + LF + "4");
	}

	@Test
	void case3() {
		check("10\n" + "square869120\n" + "square869120\n" + "square869120\n" + "square869120\n" + "square869120\n"
				+ "square869120\n" + "square869120\n" + "square869120\n" + "square869120\n" + "square869120", "1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/027");
	}
}
