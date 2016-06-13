import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
	public static void main(String[] args) {
		p("asdsfdfagf@adsdsfd.com".matches("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+"));// true

		// matches() find() lookingAt()
		Pattern p = Pattern.compile("\\d{3,5}");
		Matcher m = p.matcher("123-34345-234-00");

		// 将整个"123-34345-234-00"用正则表达式引擎查找匹配，当到第一个"-"不匹配了，就停止，
		// 但不会将不匹配的"-"吐出来
		p(m.matches());
		// 将不匹配的"-"吐出来
		//m.reset();

		// 1:当前面有p(m.matches());查找子字符串从"...34345-234-00"开始
		// 将会是第1,2两个查到"34345"和"234" 后面2个查不到为false
		// 2:当前面有p(m.matches());和m.reset();查找子字符串从"123-34345-234-00"开始
		// 将为true,true,true,false
		p(m.find());
		p(m.start() + "---" + m.end());
		p(m.find());
		p(m.start() + "---" + m.end());
		p(m.find());
		p(m.start() + "---" + m.end());
		p(m.find());
		// 要是没找到就会报异常java.lang.IllegalStateException
		// p(m.start()+"---"+m.end());

		p(m.lookingAt());
		p(m.start() + "---" + m.end());
		p(m.lookingAt());
		p(m.start() + "---" + m.end());
		p(m.lookingAt());
		p(m.lookingAt());
	}
	public static void p(Object a){
		System.out.println(a);
	}
	public static void p(boolean a){
		System.out.println(a);
	}
}