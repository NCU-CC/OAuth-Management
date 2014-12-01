package tw.edu.ncu.cc.manage.service.oauth;

import java.util.List;

import tw.edu.ncu.cc.manage.entity.oauth.APPInfo;

public interface IAPPService {
    List<APPInfo> getAllAPPsByUserId (String id);
    APPInfo getAPPbyAPPId(String id);
    APPInfo updateAPP(APPInfo app);
    APPInfo removeAPP(APPInfo app);
}
