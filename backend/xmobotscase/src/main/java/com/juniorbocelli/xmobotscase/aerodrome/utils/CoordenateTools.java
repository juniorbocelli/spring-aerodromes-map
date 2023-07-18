package com.juniorbocelli.xmobotscase.aerodrome.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CoordenateTools {
    private final Pattern firstPattern = Pattern.compile("(\\d{6})(S|N)/(\\d{7})(W|E)");
    private final Pattern secondPattern = Pattern.compile("(\\d{6}).(\\d{2})(S|N)/(\\d{7}).(\\d{2})(W|E)");
    private final Pattern thirdPattern = Pattern.compile("(\\d{6}),(\\d{2})(S|N)/(\\d{7}),(\\d{2})(W|E)");

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

    public String getDmsStringFromFirstPattern() {
        Matcher matcher = this.getMatcherFromFirst();
        matcher.find();

        return matcher.group(0);
    }

    public Matcher getMatcherFromSecond() {
        return secondPattern.matcher(this.customText);
    }

    public boolean isSecondPattern() {
        return this.getMatcherFromSecond().find();
    }

    public String getDmsStringFromSecondPattern() {
        Matcher matcher = this.getMatcherFromSecond();
        matcher.find();

        return matcher.group(0);
    }

    public Matcher getMatcherFromThird() {
        return thirdPattern.matcher(this.customText);
    }

    public boolean isThirdPattern() {
        return this.getMatcherFromThird().find();
    }

    public String getDmsStringFromThirdPattern() {
        Matcher matcher = this.getMatcherFromThird();
        matcher.find();

        return matcher.group(0);
    }

    public String getDmsString() {
        if (this.isFisrtPattern()) {
            return this.getDmsStringFromFirstPattern();
        } else if (this.isSecondPattern()) {
            return this.getDmsStringFromSecondPattern();
        } else if (this.isThirdPattern()) {
            return this.getDmsStringFromThirdPattern();
        }

        return null;
    }

    // *** Getters ans Setters
    public String getCustomText() {
        return customText;
    }

    public void setCustomText(String customText) {
        this.customText = customText;
    }
}
