package Service;

import Dao.Dao;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-25-17:58
 */
public class GetInfo implements Runnable {


    public static String UserAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.61 Safari/537.36";
    public static String post = "http://www.tsc.edu.cn";
    @Override
    public void run() {
        String pageUrl = "";
        synchronized (GetInfo.class){
            String sql = "select linkname,title from t_link ";
            ArrayList<HashMap<String, Object>> query = Dao.query(sql);
            for (HashMap<String, Object> hashMap : query) {

                System.out.println(Thread.currentThread().getName());
                String linkname = (String)hashMap.get("linkname");
                String title = (String)hashMap.get("title");
                pageUrl = post + linkname;
                getData(pageUrl,title);

            }
        }


    }

    public void getData(String url,String title) {

        try {
            Document document = Jsoup.connect(url).timeout(30000).userAgent(UserAgent).get();
            Elements cmcss = document.getElementsByClass("cmcss");
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("title",title);
            hashMap.put("content",cmcss.toString());
            Dao.insertObj("t_content", hashMap);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
