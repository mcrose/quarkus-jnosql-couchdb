/**
 * 
 */
package py.com.icarusdb.quarkus.jnosql.couchdb.service;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

import org.jnosql.artemis.document.DocumentTemplate;

/**
 * @author Roberto Gamarra [rgamarra@ingenia.io]
 *
 */
public abstract class DatabaseInstance {

    protected SeContainer container;
    protected DocumentTemplate template;
    
    abstract Logger getLogger();
    
    @PostConstruct
    private void init() {
        getLogger().info("init service...");
        try {
            container = SeContainerInitializer.newInstance().initialize();
            container.select(DocumentTemplate.class).get();
            getLogger().info("done!");
        }
        catch (Exception e) {
            getLogger().severe(e.getMessage());
        }
    }
    
    
}
