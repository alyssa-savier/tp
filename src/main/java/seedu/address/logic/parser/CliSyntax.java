package seedu.address.logic.parser;

/**
 * Contains Command Line Interface (CLI) syntax definitions common to multiple commands
 */
public class CliSyntax {

    /* Prefix definitions */
    public static final Prefix PREFIX_NAME = new Prefix("n/");
    public static final Prefix PREFIX_EMAIL = new Prefix("e/");
    public static final Prefix PREFIX_TAG = new Prefix("t/");

    /* Prefix definitions exclusive to Staff */
    public static final Prefix PREFIX_STAFF_ID = new Prefix("sid/");
    public static final Prefix PREFIX_PHONE = new Prefix("p/");
    public static final Prefix PREFIX_ADDRESS = new Prefix("a/");

    /* Prefix definitions exclusive to Guest */
    public static final Prefix PREFIX_ROOM_NUMBER = new Prefix("r/");
    public static final Prefix PREFIX_PASSPORT_NUMBER = new Prefix("pn/");

}
