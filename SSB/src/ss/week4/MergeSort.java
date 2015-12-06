package ss.week4;

import java.util.*;

public class MergeSort {
	
	//private <E extends Comparable<E>> List<E> list;
		
    public static <E extends Comparable<E>>
           void mergesort(List<E> list) {
    	
    	List<E> fst;
    	List<E> snd;
    	List<E> res = new ArrayList<E>();
    	int fi = 0;
    	int si = 0;

    	if (list.size() > 1) {
    		fst = list.subList(0, list.size() / 2);
    		snd = list.subList(list.size() / 2, list.size());
    		mergesort(fst);
    		mergesort(snd);
    		res.clear();
    		while (fi < fst.size() && si < snd.size()) {
    			if (fst.get(fi).compareTo(snd.get(si)) < 0) {
    				res.add(fst.get(fi));
    				fi++;
    			} else {
    				res.add(snd.get(si));
    				si++;
    			}
    		}
    		if (fi < fst.size()) {
    			res.addAll(fst.subList(fi, fst.size()));
    		} else if (si < snd.size()) {
    			res.addAll(snd.subList(si, snd.size()));
    		}
    		list = res;
    		System.out.println(res);
    	}
    }
}
