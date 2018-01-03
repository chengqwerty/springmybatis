package som.make.common.config;

import org.ehcache.CacheManager;
import org.ehcache.config.Configuration;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.xml.XmlConfiguration;
import org.springframework.beans.factory.FactoryBean;

import java.net.URL;

public class EhcacheFactoryBean implements FactoryBean {
    public String classConfigPath;

    public String getClassConfigPath() {
        return classConfigPath;
    }

    public void setClassConfigPath(String classConfigPath) {
        this.classConfigPath = classConfigPath;
    }

    @Override
    public CacheManager getObject() throws Exception {
        URL configUrl = getClass().getResource(classConfigPath);
        Configuration xmlConfig = new XmlConfiguration(configUrl);
        CacheManager cacheManager = CacheManagerBuilder.newCacheManager(xmlConfig);
        cacheManager.init();
        return cacheManager;
    }

    @Override
    public Class<?> getObjectType() {
        return CacheManager.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
