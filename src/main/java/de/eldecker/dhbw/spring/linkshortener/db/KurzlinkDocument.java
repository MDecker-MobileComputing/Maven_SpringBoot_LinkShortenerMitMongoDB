package de.eldecker.dhbw.spring.linkshortener.db;

import static java.time.LocalDateTime.now;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Objects;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


/**
 * Klasse für Kurzlink-Objekte, die in der MongoDB gespeichert werden. 
 */
@Document( collection = "kurzlinks" )
public class KurzlinkDocument {

    /** Primärschlüssel in MongoDB. */
    @Id
    private ObjectId id;

    /** Kürzel der Kurzl-URL */
    @Field( "url_kuerzel" )
    private String kuerzel;

    /** Lang-URL */
    @Field( "url_lang" )
    private URL url;

    /** Zeitpunkt, zu dem der Kurzlink erzeugt wurde. */
    @Field( "erzeugt_am" )
    private LocalDateTime zeitpunkt;

    /** Anzahl Zugriffe auf den Kurzlink. */
    @Field( "anzahl_zugriffe" )
    private int zaehler;

    
    /** Default-Konstruktor. */
    public KurzlinkDocument() {}


    /**
     * Konstruktor, um neuen Shortlink anzulegen.
     */
    public KurzlinkDocument( String kuerzel, URL url ) {

        this.kuerzel = kuerzel;
        this.url     = url;

        this.zeitpunkt = now();
        this.zaehler   = 0;
    }
    
    /**
     * Convenience-Methode, um Kürzel mit URL als String zu erzeugen.  
     */
    public KurzlinkDocument( String kuerzel, String url ) 
           throws URISyntaxException, MalformedURLException {
        
        this( kuerzel, 
              new URI( url ).toURL() 
            );
    }

    public ObjectId getId() {

        return id;
    }

    public String getKuerzel() {

        return kuerzel;
    }

    public void setKuerzel( String kuerzel ) {

        this.kuerzel = kuerzel;
    }

    public URL getUrl() {

        return url;
    }

    public void setUrl( URL url ) {

        this.url = url;
    }

    public LocalDateTime getZeitpunkt() {

        return zeitpunkt;
    }

    public void setZeitpunkt( LocalDateTime zeitpunkt ) {

        this.zeitpunkt = zeitpunkt;
    }

    public int getZaehler() {

        return zaehler;
    }

    public void setZaehler( int zaehler ) {

        this.zaehler = zaehler;
    }

    
    /**
     * Objekt gibt String-Repräsentation des Objekts zurück.
     * 
     * @return String mit Kürzel und URL
     */
    @Override
    public String toString() {

        return "Kurzlink \"" + kuerzel + "\" für URL " + url;
    }

    
    /** 
     * Hashwert ("Fingerabdruck") für Objekt berechnen.
     * 
     * @return Hash-Code, in dessen Berechnung alle Attribute bis auf
     *         die ID eingegangen sind.
     */
    @Override
    public int hashCode() {
        
        return Objects.hash( kuerzel, url, zeitpunkt, zaehler );
    }


    /**
     * Vergleicht ein Objekt mit {@code obj}.
     * 
     * @return {@code true} gdw. wenn {@code obj} auch eine {@link KurzlinkDocument}-Objekt
     *         ist und alle Attribute bis auf die ID denselben Wert haben.  
     */
    @Override
    public boolean equals( Object obj ) {
        
        if ( obj == null ) { return false; }
        if ( obj == this ) { return true;  }
        
        if ( obj instanceof KurzlinkDocument anderes ) {
            
            return Objects.equals( kuerzel  , anderes.kuerzel   ) &&
                   Objects.equals( url      , anderes.url       ) &&
                   Objects.equals( zeitpunkt, anderes.zeitpunkt ) &&
                   Objects.equals( zaehler  , anderes.zaehler   );            
        } else {
            
            return false;
        }
    }
    
}
