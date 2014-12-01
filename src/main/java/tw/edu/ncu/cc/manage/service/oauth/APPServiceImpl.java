package tw.edu.ncu.cc.manage.service.oauth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import tw.edu.ncu.cc.manage.entity.oauth.APPInfo;

@Service
public class APPServiceImpl implements IAPPService{

    public List<APPInfo> getAllAPPsByUserId(String id) {
        // TODO Auto-generated method stub
//        return null;
        return mock();
    }
    
    private List<APPInfo> mock(){
        List<APPInfo> list = new ArrayList<APPInfo>();
        APPInfo appInfo = new APPInfo();
        appInfo.setId("123");
        appInfo.setSecret("xxxx");
        appInfo.setDescription("aaa");
        appInfo.setName("name");
        appInfo.setAppURL("http://www.facebook.com/");
        appInfo.setCallback("http://www.google.com/");
        list.add(appInfo);
        
        appInfo = new APPInfo();
        appInfo.setId("123");
        appInfo.setSecret("xxxx");
        appInfo.setDescription("aaa");
        appInfo.setName("name");
        appInfo.setAppURL("http://www.facebook.com/");
        appInfo.setCallback("http://www.google.com/");
        list.add(appInfo);
        
        appInfo = new APPInfo();
        appInfo.setId("123");
        appInfo.setSecret("xxxx");
        appInfo.setDescription("aaa");
        appInfo.setName("name");
        appInfo.setAppURL("http://www.facebook.com/");
        appInfo.setCallback("http://www.google.com/");
        list.add(appInfo);
        return list;
    }

    public APPInfo getAPPbyAPPId(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    public APPInfo updateAPP(APPInfo app) {
        // TODO Auto-generated method stub
        return null;
    }

    public APPInfo removeAPP(APPInfo app) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
