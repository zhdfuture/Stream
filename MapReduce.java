package Price;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class MapReduce {
    public static void main(String[] args) {
        List<Order> oderlist = new ArrayList<>();
        oderlist.add(new Order("Iphone", 8999.99, 10));
        oderlist.add(new Order("外星人笔记本", 12999.99, 5));
        oderlist.add(new Order("MacBookPro", 18999.99, 5));
        oderlist.add(new Order("Java从入门到放弃.txt", 9.99, 20000));
        oderlist.add(new Order("中性笔", 1.99, 200000));
         double totalPrice=0.0D;
         for(Order od:oderlist){
             totalPrice+= od.getPrice()*od.getAmount();
         }
        System.out.println("总钱数为："+totalPrice);
        System.out.println("===>方法");
        Double totalPrice1=oderlist.stream().map(order -> order.getAmount() * order.getPrice()).reduce((sum, x) -> sum + x).get();
        Double totalPrice2 = oderlist.stream().map(order -> order.getAmount() * order.getPrice()).reduce(Double::sum).orElseGet(()->0.0D);//方法引用
        Double totalPrice3 = oderlist.stream().mapToDouble(order -> order.getAmount() * order.getPrice()).reduce(Double::sum).orElseGet(()->0.0D);
        System.out.println(totalPrice1);
        System.out.println(totalPrice2);
        System.out.println(totalPrice3);
        System.out.println("====>");
        DoubleSummaryStatistics statistics = oderlist.stream().mapToDouble(order -> order.getPrice() * order.getAmount()).summaryStatistics();
        System.out.println("总订单数：" + statistics.getCount());
        System.out.println("总金额：" + statistics.getSum());
        System.out.println("最大金额：" + statistics.getMax());
        System.out.println("最小金额：" + statistics.getMin());
        System.out.println("平均金额：" + statistics.getAverage());
    }
}