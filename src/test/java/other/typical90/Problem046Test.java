package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem046Test extends TestBase {

	@Test
	void case1() {
		check("3\n" + "10 13 93\n" + "5 27 35\n" + "55 28 52", "3");
	}

	@Test
	void case2() {
		check("3\n" + "10 56 102\n" + "16 62 108\n" + "20 66 112", "27");
	}

	@Test
	void case3() {
		check("20\n" + "238 395 46 238 264 114 354 52 324 14 472 64 307 280 209 24 165 194 179 248\n"
				+ "270 83 377 332 173 21 362 75 66 342 229 117 124 481 48 235 376 13 420 74\n"
				+ "175 427 76 278 486 169 311 47 348 225 41 482 355 356 263 95 170 156 340 289", "183");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/046");
	}
}
