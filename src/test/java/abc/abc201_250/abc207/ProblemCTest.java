package abc.abc201_250.abc207;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1 1 2\n" + "2 2 3\n" + "3 2 4", "2");
	}

	@Test
	void case2() {
		check("19\n" + "4 210068409 221208102\n" + "4 16698200 910945203\n" + "4 76268400 259148323\n"
				+ "4 370943597 566244098\n" + "1 428897569 509621647\n" + "4 250946752 823720939\n"
				+ "1 642505376 868415584\n" + "2 619091266 868230936\n" + "2 306543999 654038915\n"
				+ "4 486033777 715789416\n" + "1 527225177 583184546\n" + "2 885292456 900938599\n"
				+ "3 264004185 486613484\n" + "2 345310564 818091848\n" + "1 152544274 521564293\n"
				+ "4 13819154 555218434\n" + "3 507364086 545932412\n" + "4 797872271 935850549\n"
				+ "2 415488246 685203817", "102");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc207/C");
	}
}
