/*
 * Link : https://www.geeksforgeeks.org/linkedhashmap-removeeldestentry-method-in-java/?ref=lbp
 * Video : Udemy(personal) java 253 section
 */
package queue;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    public static void main(String[] args) 
    {
        LinkedHashMap<Integer,String> lhm=new LinkedHashMap<>(5,0.75f,true){
            
            protected boolean removeEldestEntry(Map.Entry e)
            {
                return size()>5;
            }
        };
        
        lhm.put(1,"A");
        lhm.put(2,"B");
        lhm.put(3,"C");
        lhm.put(4,"D");
        lhm.put(5,"E");
        lhm.get(5);
        lhm.get(1);
        lhm.put(6,"F");
        lhm.put(2,"G");
        
        lhm.forEach((k,v)->System.out.println(k+" "+v));
        
    }   
}

