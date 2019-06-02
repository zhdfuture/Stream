import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TestStream {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        Collections.addAll(list,"Zhangsan","LisI","Wangwu","Like","zhangyi","want");
        list.forEach(s-> System.out.println(s));
        System.out.println("===>");
        list.forEach(System.out::println);  //方法引用
        System.out.println("===>");
       // System.out.println(list.size());
    System.out.println(list.stream().count());
    List<String> newlist=new ArrayList<>();
        for (String item : list) {
            if (item.contains("Li")) {    //foreach循环
                newlist.add(item);
            }
        }
        System.out.println(newlist);
        System.out.println(list.stream().filter(s->s.contains("Li")).count());  //过滤出包含li的然后计算
//将字符串转换为小写，然后过滤出含有l的并且长度大于2 的字符串
        System.out.println(list.stream().map(String::toLowerCase).filter(s -> s.contains("l")).filter(s -> s.length() > 2).collect(Collectors.toList()));
        System.out.println(list.stream().skip(2).limit(3).filter(s->s.contains("i")).collect(Collectors.toList()));
    }
}
