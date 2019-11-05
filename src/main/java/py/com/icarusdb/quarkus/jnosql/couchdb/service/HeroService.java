/**
 * 
 */
package py.com.icarusdb.quarkus.jnosql.couchdb.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.jnosql.artemis.DatabaseQualifier;
import org.jnosql.artemis.demo.se.Hero;
import org.jnosql.artemis.demo.se.HeroRepository;

/**
 * @author Roberto Gamarra [rgamarra@ingenia.io]
 *
 */
@ApplicationScoped
public class HeroService extends DatabaseInstance {
    
    private static final Logger LOG = Logger.getLogger(HeroService.class.getName());
            
            
    @Override
    Logger getLogger() {
        return LOG;
    }

    
    
    @Transactional(value = TxType.REQUIRES_NEW)
    public String create(Hero hero) {
        //
        HeroRepository repository = container.select(
                                            HeroRepository.class, DatabaseQualifier.ofDocument()
                                    ).get();
        repository.save(hero);
        
        return hero.getName(); // the hidden ID
    }
    
    
    public static final String IRONMAN_ID = "iron_man";
    
    @Transactional(value = TxType.REQUIRES_NEW)
    public void createIronMan() {
        //
        LOG.info("create Iron Man document");
        Hero ironMan = Hero.builder().withRealName("Tony Stark")
                                     .withName(IRONMAN_ID)
                                     .withAge(34)
                                     .withPowers(Collections.singleton("rich"))
                                     .build();
        template.insert(ironMan);        
        LOG.info("done!");
    }
    
    @Transactional(value = TxType.REQUIRES_NEW)
    public void updateIronMan() {
        //
        LOG.info("update Iron Man document");
        Hero ironMan = Hero.builder().withRealName("Tony Stark")
                                     .withName(IRONMAN_ID)
                                     .withAge(34)
                                     .withPowers(new HashSet<>(Arrays.asList("rich", "extra-smart")))
                                     .build();
        template.update(ironMan);
        LOG.info("done!");
    }

}
