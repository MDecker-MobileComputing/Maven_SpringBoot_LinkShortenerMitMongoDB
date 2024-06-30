package de.eldecker.dhbw.spring.linkshortener.logik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import de.eldecker.dhbw.spring.linkshortener.db.KurzlinkRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component
public class DemoDatenImporter implements ApplicationRunner {
    
    private final static Logger LOG = LoggerFactory.getLogger( DemoDatenImporter.class );

    /** Repo-Objekt für Zugriff auf Mongodb-Collection mit Kurzlinks. */
    @Autowired
    private KurzlinkRepo _kurzlinkRepo; 
    
    public void run( ApplicationArguments args ) throws Exception {

        final long anzahlAlt = _kurzlinkRepo.count();
        if ( anzahlAlt > 0 ) {
            
            LOG.info( "Es sind schon {} Kurzlinks in der DB gespeichert, lade keine Demo-Daten.", 
                      anzahlAlt );            
        } else {
                                    
            final long anzahlNeu = _kurzlinkRepo.count();
            LOG.info( "Es sind jetzt {} Kurzlinks in der DB gespeichert.", anzahlNeu );             
        }
    }
    
}
