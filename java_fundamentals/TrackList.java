import java.util.*;
public class TrackList {
    public static void main(String[] args) {
       HashMap<String, String> trackList = new HashMap<String, String>();  
       trackList.put("jj", "heeeee");
       trackList.put("ss", "ttttttt");
       trackList.put("hh", "hhhhhh");
       trackList.put("jh", "jjjjjj");
       System.out.println(trackList.get("ss"));
       Set<String> keys = trackList.keySet();
       for(String key : keys){
        System.out.println(key);
        System.out.println(trackList.get(key));
       }
    }
}
