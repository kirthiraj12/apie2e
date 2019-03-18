package com.karlin.testing.acceptance.test.test;

public enum AcceptanceTags {

    SMOKE_TAG("@smoke"),
    CLEANUP_TAG("@cleanup"),
    DATASETUP_TAG("@datasetup"),
    ACPT_TAG("@acpttest");

    private final String tag;

    AcceptanceTags(String tag) {
        this.tag = tag;
    }

    /**
     * AcceptanceTags constructor.
     *
     * @param string value for the tag
     * @return AcceptanceTags from the name
     */
    public static AcceptanceTags fromString(String string) {
        for (AcceptanceTags tag : AcceptanceTags.values()) {
            if (tag.tag.equals(string.toLowerCase())) {
                return tag;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.tag;
    }

}
