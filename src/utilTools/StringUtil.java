package utilTools;
/**
 * 字符串工具类
 * @author CHENWENLONG
 *
 */
public class StringUtil {
	/**
	 * 判断是否为空
	 * @param str
	 * @return
	 */
	public static boolean IsEmpty(String str){
		if(str==null || "".equals(str.trim())){
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 * 判断是否不是空
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str){
		if(str!=null && !"".equals(str.trim())){
			return true;
		}
		else {
			return false;
		}
	}
}
