package com.ppro.spring.controller;

import com.ppro.spring.model.Page;
import com.ppro.spring.model.Profile;
import com.ppro.spring.model.SearchResult;
import com.ppro.spring.model.User;
import com.ppro.spring.service.api.CRUDService;
import com.ppro.spring.service.api.ProfileService;
import com.ppro.spring.service.api.UserService;
import com.ppro.spring.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: lukas
 * Date: 1.1.15
 */
@Controller
public class ProfileController {

    @Autowired
    @Qualifier(value = "ProfileService")
    private ProfileService profileService;

    @Autowired
    @Qualifier(value = "SearchResultService")
    private CRUDService<SearchResult> searchResultService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/profily", method = RequestMethod.GET)
    public ModelAndView getAllProfiles() {
        ModelAndView mav = new ModelAndView();
        //all profiles only for logged user
        User actualUser = userService.getUserByName(AppUtils.getActualLoggedUser());
        final Set<Profile> profiles = actualUser.getProfiles();
        mav.addObject("searchResult", profiles);
        return AppUtils.goToPageByModelAndView(mav, "profiles");
    }

    @RequestMapping(value = "/profil", method = RequestMethod.GET)
    public ModelAndView getDetailOfProfile(@RequestParam("profileID") Long profileID, @RequestParam(value = "subject", required = false) String subject) {
        ModelAndView mav = new ModelAndView();
        Profile profile = profileService.getByID(profileID);
        Map<String, Set<SearchResult>> mapResults = profileService.getSearchResults(profile);
        mav.addObject("profile", profile);
        mav.addObject("mapResults", mapResults);

        if (subject != null) {
            mav.addObject("subject", subject);
        } else if (!mapResults.isEmpty()){
            mav.addObject("subject", mapResults.keySet().toArray()[0]);
        }
        return AppUtils.goToPageByModelAndView(mav, "profile");
    }

    @RequestMapping(value = "/odstranitProfil", method = RequestMethod.GET)
    public String deleteProfile(Model model, @RequestParam("profileID") Long profileID) {
        profileService.delete(profileID);
        model.addAttribute("deleted", true);
        return "redirect:profily";
    }


    @RequestMapping(value = "/klicova_slova", method = RequestMethod.GET)
    public ModelAndView getProfileKeywords(@RequestParam("profileID") Long profileID, @RequestParam(value = "subject", required = false) String subject) {
        ModelAndView mav = new ModelAndView();
        Profile profile = profileService.getByID(profileID);
        Map<String, Set<SearchResult>> mapResults = profileService.getSearchResults(profile);
        mav.addObject("profile", profile);
        mav.addObject("mapResults", mapResults);
        //TODO
//        mav.addObject("lastSearchDate", mapResults);


        if (subject != null) {
            mav.addObject("subject", subject);
        } else if (!mapResults.isEmpty()){
            mav.addObject("subject", mapResults.keySet().toArray()[0]);
        }
        return AppUtils.goToPageByModelAndView(mav, "profile_keywords");
    }

    @RequestMapping(value = "/klicove_slovo", method = RequestMethod.GET)
    public ModelAndView getProfileKeyword(@RequestParam("profileID") Long profileID, @RequestParam(value = "subject", required = false) String subject) {
        ModelAndView mav = new ModelAndView();
        Profile profile = profileService.getByID(profileID);
        Map<String, Set<SearchResult>> mapResults = profileService.getSearchResults(profile);
        mav.addObject("profile", profile);
        mav.addObject("mapResults", mapResults);

        if (subject != null) {
            mav.addObject("subject", subject);
        } else if (!mapResults.isEmpty()){
            mav.addObject("subject", mapResults.keySet().toArray()[0]);
        }
        return AppUtils.goToPageByModelAndView(mav, "profile_keyword");
    }

    @RequestMapping(value = "/odstranitKlicoveSlovo", method = RequestMethod.GET)
    public String deleteKeyWord(RedirectAttributes model, @RequestParam("profileID") Long profileID, @RequestParam(value = "keyWord") String keyWord) {

        final Profile profile = profileService.getByID(profileID);
        final List<SearchResult> searchResultsToDelete = profileService.getSearchedResultForSubject(profile,keyWord);
        for (SearchResult searchResult : searchResultsToDelete) {
            searchResultService.delete(searchResult.getSearchResultID());
        }
        model.addFlashAttribute("deleted", true);
        return "redirect:profily";
    }

    @RequestMapping(value = "/stranky", method = RequestMethod.GET)
    public ModelAndView getProfilePages(@RequestParam("profileID") Long profileID) {
        ModelAndView mav = new ModelAndView();
        Profile profile = profileService.getByID(profileID);
        final Set<Page> pages = profile.getPages();
        mav.addObject("profile", profile);
        mav.addObject("mapPages", pages);
        return AppUtils.goToPageByModelAndView(mav, "profile_pages");
    }

    @RequestMapping(value = "/profil_index", method = RequestMethod.GET)
    public String getProfileIndex(@RequestParam("profileID") Long profileID) {
        ModelAndView mav = new ModelAndView();
        Profile profile = profileService.getByID(profileID);
        return "redirect:/index_zpracuj?url="+profile.getUrl();
    }

    @RequestMapping(value = "/profil_klicove_slovo", method = RequestMethod.GET)
    public String getProfileKeyword(@RequestParam("profileID") Long profileID) {
        ModelAndView mav = new ModelAndView();
        Profile profile = profileService.getByID(profileID);
        return "redirect:/pozice?url="+profile.getUrl();
    }

    @RequestMapping(value = "/profil_stranka", method = RequestMethod.GET)
    public String getProfilePage(@RequestParam("profileID") Long profileID) {
        ModelAndView mav = new ModelAndView();
        Profile profile = profileService.getByID(profileID);
        return "redirect:/mapa?url="+profile.getUrl();
    }


    //TODO dodelat detail stanek
}
