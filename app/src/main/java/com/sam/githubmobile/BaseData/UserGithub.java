package com.sam.githubmobile.BaseData;

import android.os.Parcel;
import android.os.Parcelable;

public class UserGithub implements Parcelable {

    private String personName;
    private String userName;
    private String address;
    private String repository;
    private String company;
    private String followers;
    private String following;
    private String urlGithub;
    private int userPictures;

    protected UserGithub(Parcel in) {
        personName = in.readString();
        userName = in.readString();
        address = in.readString();
        repository = in.readString();
        company = in.readString();
        followers = in.readString();
        following = in.readString();
        userPictures = in.readInt();
        urlGithub = in.readString();
    }

    public static final Creator<UserGithub> CREATOR = new Creator<UserGithub>() {
        @Override
        public UserGithub createFromParcel(Parcel in) {
            return new UserGithub(in);
        }

        @Override
        public UserGithub[] newArray(int size) {
            return new UserGithub[size];
        }
    };

    public UserGithub() {
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRepository() {
        return repository;
    }

    public void setRepository(String repository) {
        this.repository = repository;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getUrlGithub() {
        return urlGithub;
    }

    public void setUrlGithub(String urlGithub) {
        this.urlGithub = urlGithub;
    }

    public int getUserPict() {
        return userPictures;
    }

    public void setUserPict(int userPict) {
        this.userPictures = userPict;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(personName);
        parcel.writeString(userName);
        parcel.writeString(address);
        parcel.writeString(repository);
        parcel.writeString(company);
        parcel.writeString(followers);
        parcel.writeString(following);
        parcel.writeInt(userPictures);
        parcel.writeString(urlGithub);
    }
}
