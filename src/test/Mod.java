package test;

public class Mod {
public static void main(String[] args) {
	System.out.println(-6%5);
	/**
	 *  (-6%5) ＝ -6 - (-6/5)*5
     	(-6%5) = -6 - (-1)*5
    	(-6%5) = -6 - (-5)
    	(-6%5) = -6+5
    	(-6%5) = -1
    */
	System.out.println(5%-6);
	/**
	 *  (5%-6) =   5 - (5/-6)*(-6)
    	(5%-6) =   5 - (0)*(-6)
    	(5%-6) =   5 - 0
    	(5%-6) =   5
    */
	
	System.out.println(-5%-6);
	/**
	 *  (-5%-6)= -5 - (-5/-6)*(-6)
    	(-5%-6)= -5 - (0)*(-6)
    	(-5%-6)= -5 - 0
    	(-5%-6)= -5
    */
	
	System.out.println(6%-5);
	/**
	 *  (6%-5) =   6 - (6/-5)*(-5)
    	(6%-5) =   6 - (-1)*(-5)
    	(6%-5) =   6 - 5
    	(6%-5) =   1
    */
	
	System.out.println(30%5);
	/**
	 *  (30%5) =   30 - (30/5)*(5)
    	(30%5) =   30 - (6)*(5)
    	(30%5) =   30 - 30
    	(30%5) =   0
    */
	//System.out.println(4.0/9.0);
}
}
