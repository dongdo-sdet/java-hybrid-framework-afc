package commons;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({ "file:EnvsList/${env}.properties" })
public interface IEnvironment extends Config {

	@Key("userUrl")
	String getUserUrl();

	@Key("adminUrl")
	String getAdminUrl();
}
