package de.eldecker.dhbw.spring.linkshortener.db;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repo-Interface für Zugriff auf {@link Kurzlink}-Objekte.
 */
public interface KurzlinkRepo extends MongoRepository<Kurzlink, ObjectId>{

}
