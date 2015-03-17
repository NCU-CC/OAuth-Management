package tw.edu.ncu.cc.manage.entity.oauth.application;

import java.util.Comparator;

public class ApplicationComparator implements Comparator<IdApplication>{    
    public int compare(IdApplication o1, IdApplication o2) {
        return o1.getId().compareTo(o2.getId());
    }
}