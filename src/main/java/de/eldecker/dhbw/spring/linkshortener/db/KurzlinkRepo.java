package de.eldecker.dhbw.spring.linkshortener.db;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repo-Interface für Zugriff auf {@link KurzlinkDocument}-Objekte.
 */
public interface KurzlinkRepo extends MongoRepository<KurzlinkDocument, ObjectId> {

}
