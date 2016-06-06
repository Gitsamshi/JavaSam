package crazyjava;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularLearning {

	public static void main(String[] args) {
		
		//match general words \\d\\s\\w .
		/*System.out.println("Any:"+"a".matches("."));
		System.out.println("Digit:"+"1".matches("\\d"));
		System.out.println("Nondigit:"+"a".matches("\\D"));
		System.out.println("Blank:"+"\n".matches("\\s"));
		System.out.println("NonBlank:"+"\n".matches("\\s"));
		System.out.println("Word:"+"w".matches("\\w"));
		System.out.println("Nonword:"+"#".matches("\\W"));
		*/
		
		//number of words{}
		/*System.out.println("<=1, ?:"+"a".matches("\\w?"));
		System.out.println("0or>1, *:"+"".matches("\\d*")+"22".matches("\\d*"));
		System.out.println(">=1, +:"+"a".matches("\\D+"));
		System.out.println("n, {n}"+"\n\r\n".matches("\\s{3}"));
		System.out.println("n~m, {n,m}:"+"1232132".matches("\\d{1,9}"));
		System.out.println(">=n, {n,}:"+"www".matches("\\w{2,}"));
		*/
		
		//range of one position
		/*System.out.println("[xxx]"+"a".matches("[abv]"));
		System.out.println("[x-x]"+"3".matches("[1-9]"));
		System.out.println("[^xx]"+"a".matches("[^bc]"));*/
		
		Scanner scan = new Scanner(System.in);
//		String phone = scan.next();
//		phoneChk(phone);
//		String telephone =scan.next();
//		teleChk(telephone);
//		String ran = scan.nextLine();
//		splitWd(ran);
//		String ran = scan.nextLine();
//		splitDupWd(ran);
		String org = scan.nextLine();
		findWd2(org);
		scan.close();
		
	}

	public static void teleChk(String telephone) {
		System.out.print(telephone+":"+(telephone.matches("0\\d{2,3}-[1-9]\\d{6,7}")?"Valid":"Invalid"));
	}

	public static void phoneChk(String phone) {
		System.out.print(phone+":"+(phone.matches("1[3578]\\d{9}")?"Valid":"Invalid"));
	}
	
	public static void splitWd(String ran){
	    String[] res=ran.split(" +");
	    System.out.println(ran+Arrays.toString(res));
	}
	
	public static void splitDupWd(String dupwd){
		String[] resp=dupwd.split("(.)\\1+");
		System.out.println(dupwd+Arrays.toString(resp));
	}
	
	public static void replaceWd(String org)
	{
		String reg = "1[3,4,5,7,8][0-9]{9}";
		String ret = org.replaceAll(reg, "****");
		System.out.println(ret);
	}
	
	public static void findWd(String org)
	{
		String reg = "[a-zA-Z0-9]\\w{2,17}@\\w+(\\.(com|cn|net|edu)){1,2}";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(org);
		while(m.find()){
			System.out.println(m.group());
		}
	}
	
	public static void findWd2(String org)
	{
		String reg = "\\b[a-zA-Z]{3}\\b";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(org);
		while(m.find())
		{
			System.out.println(m.group());
		}
	}

}
