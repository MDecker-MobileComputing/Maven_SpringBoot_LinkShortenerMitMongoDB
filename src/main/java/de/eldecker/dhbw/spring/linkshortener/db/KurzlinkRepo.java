package de.eldecker.dhbw.spring.linkshortener.db;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


/**
 * Repo-Interface für Zugriff auf {@link KurzlinkDocument}-Objekte.
 */
public interface KurzlinkRepo extends MongoRepository<KurzlinkDocument, ObjectId> {

    Optional<KurzlinkDocument> findByKuerzel( String kuerzel );


    List<KurzlinkDocument> findAllByOrderByZeitpunktAsc();


    /**
     * Gibt alle Kurzlink-Dokumente zurück, deren URL mit "http://" beginnt.
     * Methode ist über Annotation mit MQL-Query versehen.
     */
    @Query("{ 'url_lang': { $regex: '^http://', $options: '' } }")
    List<KurzlinkDocument> findAllWithUrlStartingWithHttp();

}
