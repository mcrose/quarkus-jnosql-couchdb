/**
 * 
 */
package py.com.icarusdb.quarkus.jnosql.couchdb.service;

import static org.jnosql.diana.api.document.query.DocumentQueryBuilder.select;

import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;

import org.jnosql.artemis.DatabaseQualifier;
import org.jnosql.artemis.PreparedStatement;
import org.jnosql.artemis.demo.se.Hero;
import org.jnosql.artemis.demo.se.HeroRepository;
import org.jnosql.diana.api.document.DocumentQuery;

/**
 * @author Roberto Gamarra [rgamarra@ingenia.io]
 *
 */
@RequestScoped
public class HeroDataRepository extends DatabaseInstance {
    
    private static final Logger LOG = Logger.getLogger(HeroDataRepository.class.getName());

    @Override
    Logger getLogger() {
        return LOG;
    }
    
    
    public List<Hero> getHeroById(String heroId) {
        //
        DocumentQuery query = select().from("Hero").where("_id").eq(heroId).build();
        List<Hero> heroes = template.select(query);
        
        return heroes;
    }

    
    public List<Hero> getHeroByName(String heroName) {
        //
        PreparedStatement prepare = template.prepare("select * from Hero where realName =@name");
        List<Hero> heroes = prepare.bind("name", heroName).getResultList();
        return heroes;
    }
    
    
    public void showRepositoryExample(String heroId) {
        //
        HeroRepository repository = container.select(
                HeroRepository.class, DatabaseQualifier.ofDocument()
        ).get();

        System.out.println(repository.findByName(heroId));
        System.out.println(repository.findByAgeGreaterThan(30));
        System.out.println(repository.findByAgeLessThan(40));
    }
    
}
