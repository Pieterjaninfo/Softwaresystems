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
    	//List<E> olist = list;
//		System.out.println("olist: " + olist);

    	/* other way that doesnt work yet
    	if (list.size() > 1) {
    		fst = olist.subList(0, olist.size() / 2);
    		snd = olist.subList(olist.size() / 2, olist.size());
    		mergesort(fst);
    		mergesort(snd);
    		while (fi < fst.size() && si < snd.size()) {
    			if (fst.get(fi).compareTo(snd.get(si)) < 0) {
    				list.set(fi + si, fst.get(fi));
    				fi++;
    			} else {
    				list.set(fi + si, snd.get(si));
    				si++;
    			}
    		}
    	}*/
    	

    	// Correct working way without proper return...
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
    		for (int i = 0; i < list.size(); i++) {
        		list.set(i, res.get(i));
    		}
    	}
    }
}
