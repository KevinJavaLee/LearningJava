package Service;

import Dao.Dao;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-25-15:57
 */
public class CollectLinks {

    public static String post = "http://www.tsc.edu.cn/column.jsp?id=";
    public static String UserAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.61 Safari/537.36";
    public static void main(String[] args) {
        String post = "";
        List<HashMap<String, Object>> list = new ArrayList<>();
        HashMap<String, Object> map = new LinkedHashMap<>();
        map.put("id", "1421216920727");
        map.put("current", 111);
        list.add(map);
        HashMap<String, Object> map1 = new LinkedHashMap<>();
        map1.put("id","1421216934829");
        map1.put("current",154);
        list.add(map1);
        HashMap<String, Object> map2 = new LinkedHashMap<>();
        map2.put("id","1421216950554");
        map2.put("current",211);
        list.add(map2);
        HashMap<String, Object> map3 = new LinkedHashMap<>();
        map3.put("id","1460378852305");
        map3.put("current",14);
        list.add(map3);
        Iterator<HashMap<String, Object>> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println();
            getLink(iterator.next());
        }

    }

    public static void getLink(HashMap hashMap) {

        String url = "";
        String NextUrl = "";
        Collection values = hashMap.values();
        Iterator iterator = values.iterator();
        String id = (String) iterator.next();
        int current = (int) iterator.next();
        url = post + id;
        System.out.println(id);
        System.out.println(current);

        for (int i = 1; i <= current-1; i++) {
            NextUrl = url + "&current=" + i;
            getUrlLink(NextUrl);
        }
    }

    public static void getUrlLink(String url)  {
        HashMap<String,Object> map = new HashMap();
        Document document = null;
        try {
            document = Jsoup.connect(url).timeout(30000).userAgent(UserAgent).get();
            //得到所有标签
            Elements list_con = document.getElementsByClass("list_con");
            Element list = list_con.get(0);
            Elements aTags = list.getElementsByTag("a");
//            System.out.println("_____________________-");
//            System.out.println(aTags.size());
            for (int i = 0; i < 15; i++) {
                Element element = aTags.get(i);
                String href = element.attr("href");
                String title = element.attr("title");
                map.put("linkname", href);
                map.put("title",title);
                Dao.insertObj("t_link", map);
//                System.out.println(title);
//                System.out.println(href);
            }




        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
