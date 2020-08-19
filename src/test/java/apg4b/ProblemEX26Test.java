package apg4b;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemEX26Test extends TestBase {

	@Test
	void case1() {
		check("4\n" + "int x = 1 + 2 ;\n" + "print_int x + 3 ;\n" + "vec a = [ 1 , 2 , x ] ;\n"
				+ "print_vec a + [ 4 , 5 , 6 ] ;", "6" + LF + "[ 5 7 9 ]");
	}

	@Test
	void case2() {
		check("2\n" + "print_int 1 - 2 ;\n" + "print_vec [ 1 , 2 , 3 ] - [ 3 , 2 , 1 ] ;", "-1" + LF + "[ -2 0 2 ]");
	}

	@Test
	void case3() {
		check("1\n" + "print_int 5 ;", "5");
	}

	@Test
	void case4() {
		check("1\n" + "print_vec [ 1 , 2 ] ;", "[ 1 2 ]");
	}

	@Test
	void case5() {
		check("2\n" + "int x = 1 ;\n" + "print_int x ;", "1");
	}

	@Test
	void case6() {
		check("2\n" + "vec a = [ 3 , 4 ] ;\n" + "print_vec a ;", "[ 3 4 ]");
	}

	@Test
	void case7() {
		check("4\n" + "int x = 1 ;\n" + "int y = 2 ;\n" + "int z = 3 ;\n" + "print_int x + y + z ;", "6");
	}

	@Test
	void case8() {
		check("4\n" + "vec a = [ 1 , 2 , 3 ] ;\n" + "vec b = [ 4 , 5 , 6 ] ;\n" + "vec c = [ 7 , 8 , 9 ] ;\n"
				+ "print_vec a + b + c ;", "[ 12 15 18 ]");
	}

	@Test
	void case9() {
		check("6\n" + "vec a = [ 1 , 2 ] ;\n" + "vec b = a + [ 3 , 4 ] ;\n" + "vec c = a - [ 5 , 6 ] ;\n"
				+ "print_vec a ;\n" + "print_vec b ;\n" + "print_vec c ;",
				"[ 1 2 ]" + LF + "[ 4 6 ]" + LF + "[ -4 -4 ]");
	}

	@Test
	void case10() {
		check("10\n" + "int d = 9 + 1 + 2 - 3 + 1 ;\n" + "int x = d - 3 - 2 + 1 + d ;\n"
				+ "int k = x - d + d + x - x ;\n" + "vec c = [ d , x , k , 1 , x ] ;\n" + "vec u = [ 8 , 9 ] ;\n"
				+ "vec n = [ 1 , 2 , 3 , 4 , 5 ] ;\n" + "vec s = [ 6 , 7 ] ;\n" + "print_vec u + s + u + s - u ;\n"
				+ "print_vec n - c - c - c + n ;\n" + "print_int x + k + k - d + x ;",
				"[ 20 23 ]" + LF + "[ -28 -44 -42 5 -38 ]" + LF + "54");
	}

	@Test
	void case11() {
		check("10\n" + "int l = 7 - 6 - 5 - 4 + 8 ;\n" + "vec q = [ l , l , l , l ] ;\n"
				+ "int e = 9 + 9 + 9 + 9 + 9 ;\n"
				+ "print_vec [ 9 , 5 , 3 ] + [ 2 , 4 , 6 ] - [ 8 , 8 , 8 ] - [ 2 , 2 , 2 ] ;\n"
				+ "print_int 8 + 8 + 8 ;\n" + "int z = e + e + e + e + e ;\n" + "int b = z + z + z + z + z ;\n"
				+ "print_vec q + [ e , z , z , z ] ;\n" + "int r = b + b + b + b + b ;\n"
				+ "print_int r + z + b + e + l ;", "[ 1 -1 -1 ]" + LF + "24" + LF + "[ 45 225 225 225 ]" + LF + "7020");
	}

	@Test
	void case12() {
		check("10\n" + "vec j = [ 3 , 3 , 4 ] ;\n" + "vec a = [ 2 , 8 ] ;\n" + "vec s = [ 5 , 2 , 6 , 3 ] ;\n"
				+ "vec t = [ 1 , 1 , 1 , 1 ] - s - s - s - s ;\n" + "vec o = [ 2 , 2 , 2 , 2 ] - s - s - s - s ;\n"
				+ "print_vec s ;\n" + "print_vec a + a + [ 9 , 9 ] - a ;\n" + "print_int 7 ;\n"
				+ "print_vec [ 2 , 5 , 2 , 5 ] ;\n" + "print_vec s - o - o - o + s ;",
				"[ 5 2 6 3 ]" + LF + "[ 11 17 ]" + LF + "7" + LF + "[ 2 5 2 5 ]" + LF + "[ 64 22 78 36 ]");
	}
}
