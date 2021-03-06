package com.ppro.spring.service.api;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ppro.spring.model.Profile;
import com.ppro.spring.model.SearchResult;
import com.ppro.spring.model.Server;

/**
 * Created with IntelliJ IDEA.
 * User: lukas
 * Date: 2.1.15
 */
public interface ProfileService extends CRUDService<Profile> {

    /**
     * Create new @class Profile if does not exist.
     * Checking by @param profile.displayName
     */
    Profile loadProfile(String url);

    /**
     * Add new search to Profile
     */
    void addSearchResult(Profile profileID, String subject, Integer position, Server server);

    List<SearchResult> getSearchedResultForSubject(Profile profile, String subject);

    /**
     * Get map of search results where key is subject and values is history of search
     */
    Map<String, List<SearchResult>> getSearchResults(Profile profile);

    void addMapPages(String url, Set<String> result, int level);
}
