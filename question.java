public interface ConfigProvider {
    /**
     * @return latest/updated config instance model
     */
    @NonNull
    Config get();

    /**
     * Hints the provider loading mechanism to update it's cache. can't be blocked.
     */
    void configChanged();
}

class Config {
    // all config
}


public class DefaultConfigProvider implements ConfigProvider {

    @Override
    public Config get() {
        return ConfigFactory.get();
    }
    
    @Override
    public void configChanged() {
    }
}
