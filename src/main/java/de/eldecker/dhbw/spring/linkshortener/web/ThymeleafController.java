package de.eldecker.dhbw.spring.linkshortener.web;

import static java.lang.String.format;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import de.eldecker.dhbw.spring.linkshortener.db.KurzlinkDocument;
import de.eldecker.dhbw.spring.linkshortener.db.KurzlinkRepo;


/**
 * Controller für Thymeleaf-Templates. 
 */
@Controller
@RequestMapping( "/app/" )
public class ThymeleafController {
    
    private final static Logger LOG = LoggerFactory.getLogger( ThymeleafController.class );

    /** Repo-Bean für Zugriff auf MongoDB-Collection mit Kurzlinks. */
    @Autowired
    private KurzlinkRepo _kurzlinkRepo;
    
    
    /**
     * Seite für Auflösen von URL-Kürzel.
     *  
     * @param kuerzel URL-Kürzel
     * 
     * @param model Objekt, in dem die Werte für die Platzhalter in der 
     *              Template-Datei definiert werden.
     * 
     * @return Name der Template-Datei ohne Datei-Endung {@code .html}
     */
    @GetMapping( "/link/{kuerzel}" )
    public String linkAufloesen( @PathVariable("kuerzel") String kuerzel,
                                 Model model ) {
        
        final Optional<KurzlinkDocument> kurzlinkOptional = _kurzlinkRepo.findByKuerzel( kuerzel );
        if ( kurzlinkOptional.isEmpty() ) {
            
            final String meldung = format( 
                    "Keinen Short-Link mit Kürzel \"%s\" gefunden.", kuerzel );
            
            LOG.warn( meldung );
            
            model.addAttribute( "fehlermeldung", meldung );
            
            return "fehler";
        }
        
        final KurzlinkDocument kurzlink = kurzlinkOptional.get();
                
        model.addAttribute( "kurzlink", kurzlink );
        kurzlink.inkrementZaehler();
        
        _kurzlinkRepo.save( kurzlink );
        
        LOG.info( "Link-Kürzel \"{}\" aufgelöst: {}", 
                  kurzlink.getKuerzel(), kurzlink.getUrl() );
        
        return "link-aufgeloest";
    }
    
}
