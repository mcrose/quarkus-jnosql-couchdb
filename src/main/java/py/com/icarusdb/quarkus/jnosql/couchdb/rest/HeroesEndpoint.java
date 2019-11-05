/**
 * 
 */
package py.com.icarusdb.quarkus.jnosql.couchdb.rest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jnosql.artemis.demo.se.Hero;

import py.com.icarusdb.quarkus.jnosql.couchdb.service.HeroDataRepository;
import py.com.icarusdb.quarkus.jnosql.couchdb.service.HeroService;

/**
 * @author Roberto Gamarra [rgamarra@ingenia.io]
 *
 */
@RequestScoped
@Path("heroes")
@Produces(MediaType.APPLICATION_JSON)
public class HeroesEndpoint {
    
    private static final Logger LOG = Logger.getLogger(HeroesEndpoint.class.getName());
    
    @Inject HeroService service;
    
    @Inject HeroDataRepository dataRepository; 
    
    
    @GET
    @Path("create-iron-man")
    public List<Hero> createIronMan() {
        //
        LOG.info("endpoint: create Iron Man...");
        service.createIronMan();

        return dataRepository.getHeroById(HeroService.IRONMAN_ID);
    }
    
    @GET
    @Path("udpate-iron-man")
    public List<Hero> udpateIronMan() {
        //
        LOG.info("endpoint: udpate Iron Man...");
        service.updateIronMan();

        return dataRepository.getHeroByName("Tony Stark");
    }
    
    
    @GET
    @Path("blackwidow")
    public void blackwidow() {
        //
        LOG.info("endpoint: blackwidow...");
        
        List<String> powers = Arrays.asList("Master in the covert arts of espionage",
                                            "infiltration ", "subterfuge", 
                                            "Expert martial artist");
        
        Hero blackwidow = Hero.builder().withRealName("Natasha Alianova Romanova")
                                        .withName("black_widow")
                                        .withAge(27)
                                        .withPowers(new HashSet<>(powers))
                                        .build();
        
        String ID = service.create(blackwidow);
        
        dataRepository.showRepositoryExample(ID);
        
    }

}
