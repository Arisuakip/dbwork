package tools;

public class StringUtil {
    public static boolean isEmpty(String str){
        return str==null || "".equals(str);
    }
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }
    public static boolean anyEmpty(String...arrs) {
        for(int i=0;i<arrs.length;i++){
            if(arrs[i]==null || "".equals(arrs[i])){
                return true;
            }
        }
        return false;
    }
}
