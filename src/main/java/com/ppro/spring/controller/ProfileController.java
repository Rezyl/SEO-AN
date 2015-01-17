package com.ppro.spring.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ppro.spring.model.Profile;
import com.ppro.spring.model.SearchResult;
import com.ppro.spring.model.User;
import com.ppro.spring.service.api.ProfileService;
import com.ppro.spring.service.api.UserService;
import com.ppro.spring.utils.AppUtils;

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
        Map<String, List<SearchResult>> mapResults = profileService.getSearchResults(profile);
        mav.addObject("profile", profile);
        mav.addObject("mapResults", mapResults);

        if (subject != null) {
            mav.addObject("subject", subject);
        } else if (!mapResults.isEmpty()){
            mav.addObject("subject", mapResults.keySet().toArray()[0]);
        }
        return AppUtils.goToPageByModelAndView(mav, "profile");
    }

    @RequestMapping(value = "/klicova_slova", method = RequestMethod.GET)
    public ModelAndView getProfileKeywords(@RequestParam("profileID") Long profileID, @RequestParam(value = "subject", required = false) String subject) {
        ModelAndView mav = new ModelAndView();
        Profile profile = profileService.getByID(profileID);
        Map<String, List<SearchResult>> mapResults = profileService.getSearchResults(profile);
        mav.addObject("profile", profile);
        mav.addObject("mapResults", mapResults);

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
        Map<String, List<SearchResult>> mapResults = profileService.getSearchResults(profile);
        mav.addObject("profile", profile);
        mav.addObject("mapResults", mapResults);

        if (subject != null) {
            mav.addObject("subject", subject);
        } else if (!mapResults.isEmpty()){
            mav.addObject("subject", mapResults.keySet().toArray()[0]);
        }
        return AppUtils.goToPageByModelAndView(mav, "profile_keyword");
    }
/*
    @RequestMapping(value = "/stranky", method = RequestMethod.GET)
    public ModelAndView getProfilePages(@RequestParam("profileID") String profileID, @RequestParam(value = "subject", required = false) String subject) {
        ModelAndView mav = new ModelAndView();
        Profile profile = profileService.getByID(profileID);
        Map<String, List<SearchResult>> mapResults = profileService.getSearchResults(profile);
        mav.addObject("profile", profile);
        mav.addObject("mapResults", mapResults);

        if (subject != null) {
            mav.addObject("subject", subject);
        } else if (!mapResults.isEmpty()){
            mav.addObject("subject", mapResults.keySet().toArray()[0]);
        }
        return AppUtils.goToPageByModelAndView(mav, "profile_pages");
    }
*/
}
