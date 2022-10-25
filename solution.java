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

    map = {
        11: {} 
        22: {}
    }
    
    @Override
    public Config get() {
        let mostUpdatedTS = null
        // get most update ts key from map
        if (Object.keys(map)) {
            mostUpdatedTS = Object.keys(map).sort()[0]
        } else {
            mostUpdatedTS = new Date()
        }
        map[mostUpdatedTS] = ConfigFactory.get();    // 1m
        return map[mostUpdatedTS]
    }
    
    @Override
    public void configChanged() {
        this.map[new Date()] = true
    }
}


DefaultConfigProvider.get() // 1m   11
DefaultConfigProvider.configChanged()   // 1s
DefaultConfigProvider.get() // 1m   22
