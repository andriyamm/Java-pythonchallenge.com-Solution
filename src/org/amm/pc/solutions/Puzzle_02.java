package org.amm.pc.solutions;

public class Puzzle_02 {

	public static void main(String[] args) {
		
		String s1 = "g fmnc wms bgblr rpylqjyrc gr zw fylb. rfyrq ufyr amknsrcpq ypc dmp. bmgle gr gl zw fylb gq glcddgagclr ylb rfyr'q ufw rfgq rcvr gq qm jmle. sqgle qrpgle.kyicrpylq() gq pcamkkclbcb. lmu ynnjw ml rfc spj.";
		String s2 = "map";
		
		StringBuffer sb = solution_0(s1);
		System.out.println(sb);
		sb = solution_0(s2);
		System.out.println(sb);
	}
	
	public static StringBuffer solution_0(String s){
		char c;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if (c >= 'a' && c <= 'x')
				c = (char) ((int) c + 2);
			else if (c == 'y')
				c = 'a';
			else if (c == 'z')
				c = 'b';
			sb.append(c);
		}
		return sb;
	}
}
