package com.sam.githubmobile.Data;

import com.sam.githubmobile.BaseData.UserGithub;
import com.sam.githubmobile.R;

import java.util.ArrayList;

public class ArrayLists {
    private static String[] personName = {
            "Jake Wharton",
            "Amit Shekhar",
            "Romain Guy",
            "Chris Banes",
            "David",
            "Ravi Tamada",
            "Deny Prasetyo",
            "Budi Oktaviyan",
            "Hendi Santika",
            "Sidiq Permana"
    };
    private static String[] userName = {
            "JakeWharton",
            "amitshekhariitbhu",
            "romainguy",
            "chrisbanes",
            "tipsy",
            "ravi8x",
            "jasoet",
            "budioktaviyan",
            "hendisantika",
            "sidiqpermana"
    };
    private static String[] address = {
            "Pittsburgh, PA, USA",
            "New Delhi, India",
            "California",
            "Sydney, Australia",
            "Trondheim, Norway",
            "India",
            "Kotagede, Yogyakarta, Indonesia",
            "Jakarta, Indonesia",
            "Bojongsoang - Bandung Jawa Barat",
            "Jakarta Indonesia"
    };
    private static String[] repository = {
            "102",
            "37",
            "9",
            "30",
            "56",
            "28",
            "44",
            "110",
            "1064",
            "65"
    };
    private static String[] company = {
            "Google, Inc.",
            "MindOrksOpenSource",
            "Google",
            "Google working on @android",
            "Working Group Two",
            "AndroidHive | Droid5",
            "gojek-engineering",
            "KotlinID",
            "JVMDeveloperID @KotlinID @IDDevOps",
            "Nusantara Beta Studio"
    };
    private static String[] followers = {
            "56995",
            "5153",
            "7972",
            "14725",
            "788",
            "18628",
            "277",
            "178",
            "428",
            "465"
    };
    private static String[] following = {
            "12",
            "2",
            "0",
            "1",
            "0",
            "3",
            "39",
            "23",
            "61",
            "10"
    };
    private static int[] userPictures = {
            R.mipmap.user1,
            R.mipmap.user2,
            R.mipmap.user3,
            R.mipmap.user4,
            R.mipmap.user5,
            R.mipmap.user6,
            R.mipmap.user7,
            R.mipmap.user8,
            R.mipmap.user9,
            R.mipmap.user10
    };
    private static String[] linkGithub = {
            "https://github.com/JakeWharton",
            "https://github.com/amitshekhariitbhu",
            "https://github.com/romainguy",
            "https://github.com/chrisbanes",
            "https://github.com/tipsy",
            "https://github.com/ravi8x",
            "https://github.com/jasoet",
            "https://github.com/budioktaviyan",
            "https://github.com/hendisantika",
            "https://github.com/sidiqpermana"
    };

    public static ArrayList<UserGithub> getUserData() {
        ArrayList<UserGithub> userLists = new ArrayList<>();
        for (int position = 0; position < personName.length; position++) {
            UserGithub userGithub = new UserGithub();
            userGithub.setPersonName(personName[position]);
            userGithub.setUserName(userName[position]);
            userGithub.setAddress(address[position]);
            userGithub.setRepository(repository[position]);
            userGithub.setCompany(company[position]);
            userGithub.setFollowers(followers[position]);
            userGithub.setFollowing(following[position]);
            userGithub.setUserPict(userPictures[position]);
            userGithub.setUrlGithub(linkGithub[position]);
            userLists.add(userGithub);
        }
        return userLists;
    }
}
