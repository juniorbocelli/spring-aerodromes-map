package com.juniorbocelli.xmobotscase.aerodrome.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.juniorbocelli.xmobotscase.aerodrome.domain.entities.Coordinates;

public class CoordenateTools {
    private final Pattern firstPattern = Pattern.compile("^\\d{6}S/\\d{7}W$");
    private final Pattern secondPattern = Pattern.compile("^\\d{6}.\\d{2}S/\\d{7}.\\d{2}W$");
    private final Pattern thirdPattern = Pattern.compile("^\\d{6},\\d{2}S/\\d{7},\\d{2}W$");

    private String customText;

    public CoordenateTools(String customText) {
        this.customText = customText;
    }

    public Matcher getMatcherFromFirst() {
        return firstPattern.matcher(this.customText);
    }

    public boolean isFisrtPattern() {
        return this.getMatcherFromFirst().find();
    }

    public Matcher getMatcherFromSecond() {
        return secondPattern.matcher(this.customText);
    }

    public boolean isSecondPattern() {
        return this.getMatcherFromSecond().find();
    }

    public Matcher getMatcherFromThird() {
        return thirdPattern.matcher(this.customText);
    }

    public boolean isThirdPattern() {
        return this.getMatcherFromThird().find();
    }

    public Coordinates dmsToCoordinates(int hoursS, int minutesS, int secondsS, int hoursW, int minutesW, int secondsW) {
        
    }

    // *** Getters ans Setters
    public String getCustomText() {
        return customText;
    }

    public void setCustomText(String customText) {
        this.customText = customText;
    }
}
