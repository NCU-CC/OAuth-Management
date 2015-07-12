package tw.edu.ncu.cc.manage.dao;

import java.util.List;

import tw.edu.ncu.cc.manage.domain.BlacklistClient;
import tw.edu.ncu.cc.manage.domain.Client;

public interface IBlacklistClientDao {

	List<BlacklistClient> search(Client dto);

	BlacklistClient create(BlacklistClient client);

	void delete(BlacklistClient client);

}
