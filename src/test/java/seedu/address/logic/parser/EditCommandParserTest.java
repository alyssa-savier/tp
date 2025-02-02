//package seedu.address.logic.parser;
//
//import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
//import static seedu.address.logic.commands.CommandTestUtil.EMAIL_DESC_ALICE;
//import static seedu.address.logic.commands.CommandTestUtil.INVALID_ADDRESS_DESC;
//import static seedu.address.logic.commands.CommandTestUtil.INVALID_EMAIL_DESC;
//import static seedu.address.logic.commands.CommandTestUtil.INVALID_NAME_DESC;
//import static seedu.address.logic.commands.CommandTestUtil.INVALID_PHONE_DESC;
//import static seedu.address.logic.commands.CommandTestUtil.INVALID_TAG_DESC;
//import static seedu.address.logic.commands.CommandTestUtil.NAME_DESC_ALICE;
//import static seedu.address.logic.commands.CommandTestUtil.PHONE_DESC_BOB;
//import static seedu.address.logic.commands.CommandTestUtil.TAG_DESC_FRIEND;
//import static seedu.address.logic.commands.CommandTestUtil.TAG_DESC_HUSBAND;
//import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
//import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_ALICE;
//import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
//import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
//import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
//
//import org.junit.jupiter.api.Test;
//
//import seedu.address.logic.commands.EditCommand;
//import seedu.address.model.person.Address;
//import seedu.address.model.person.Email;
//import seedu.address.model.person.Name;
//import seedu.address.model.person.Phone;
//import seedu.address.model.tag.Tag;
//
//public class EditCommandParserTest {
//
//    private static final String TAG_EMPTY = " " + PREFIX_TAG;
//
//    private static final String MESSAGE_INVALID_FORMAT =
//            String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditCommand.MESSAGE_USAGE);
//
//    private EditCommandParser parser = new EditCommandParser();
//
//    @Test
//    public void parse_missingParts_failure() {
//        // no index specified
//        assertParseFailure(parser, VALID_NAME_ALICE, MESSAGE_INVALID_FORMAT);
//
//        // no field specified
//        assertParseFailure(parser, "1", EditCommand.MESSAGE_NOT_EDITED);
//
//        // no index and no field specified
//        assertParseFailure(parser, "", MESSAGE_INVALID_FORMAT);
//    }
//
//    @Test
//    public void parse_invalidPreamble_failure() {
//        // negative index
//        assertParseFailure(parser, "-5" + NAME_DESC_ALICE, MESSAGE_INVALID_FORMAT);
//
//        // zero index
//        assertParseFailure(parser, "0" + NAME_DESC_ALICE, MESSAGE_INVALID_FORMAT);
//
//        // invalid arguments being parsed as preamble
//        assertParseFailure(parser, "1 some random string", MESSAGE_INVALID_FORMAT);
//
//        // invalid prefix being parsed as preamble
//        assertParseFailure(parser, "1 i/ string", MESSAGE_INVALID_FORMAT);
//    }
//
//    @Test
//    public void parse_invalidValue_failure() {
//        assertParseFailure(parser, "1" + INVALID_NAME_DESC, Name.MESSAGE_CONSTRAINTS); // invalid name
//        assertParseFailure(parser, "1" + INVALID_PHONE_DESC, Phone.MESSAGE_CONSTRAINTS); // invalid phone
//        assertParseFailure(parser, "1" + INVALID_EMAIL_DESC, Email.MESSAGE_CONSTRAINTS); // invalid email
//        assertParseFailure(parser, "1" + INVALID_ADDRESS_DESC, Address.MESSAGE_CONSTRAINTS); // invalid address
//        assertParseFailure(parser, "1" + INVALID_TAG_DESC, Tag.MESSAGE_CONSTRAINTS); // invalid tag
//
//        // invalid phone followed by valid email
//        assertParseFailure(parser, "1" + INVALID_PHONE_DESC + EMAIL_DESC_ALICE, Phone.MESSAGE_CONSTRAINTS);
//
//        // valid phone followed by invalid phone. The test case for invalid phone followed by valid phone
//        // is tested at {@code parse_invalidValueFollowedByValidValue_success()}
//        assertParseFailure(parser, "1" + PHONE_DESC_BOB + INVALID_PHONE_DESC, Phone.MESSAGE_CONSTRAINTS);
//
//        // while parsing {@code PREFIX_TAG} alone will reset the tags of the {@code Person} being edited,
//        // parsing it together with a valid tag results in error
//        assertParseFailure(parser, "1" + TAG_DESC_FRIEND + TAG_DESC_HUSBAND + TAG_EMPTY, Tag.MESSAGE_CONSTRAINTS);
//        assertParseFailure(parser, "1" + TAG_DESC_FRIEND + TAG_EMPTY + TAG_DESC_HUSBAND, Tag.MESSAGE_CONSTRAINTS);
//        assertParseFailure(parser, "1" + TAG_EMPTY + TAG_DESC_FRIEND + TAG_DESC_HUSBAND, Tag.MESSAGE_CONSTRAINTS);
//
//        // multiple invalid values, but only the first invalid value is captured
//        assertParseFailure(parser, "1" + INVALID_NAME_DESC + INVALID_EMAIL_DESC + VALID_ADDRESS_BOB + VALID_PHONE_BOB,
//                Name.MESSAGE_CONSTRAINTS);
//    }
//
//    //    // Edit Command Parser Tests for Guests
//    //    @Test
//    //    public void parse_allFieldsSpecified_success() {
//    //        UniqueIdentifier targetIdentifier = STAFF_ID_FIRST_PERSON;
//    //        String userInput = targetIdentifier + PHONE_DESC_BOB + TAG_DESC_HUSBAND
//    //                + EMAIL_DESC_AMY + ADDRESS_DESC_AMY + NAME_DESC_AMY + TAG_DESC_FRIEND;
//    //
//    //        EditPersonDescriptor descriptor = new EditPersonDescriptorBuilder()
//    //                .withStaffId("123").withName(VALID_NAME_AMY)
//    //                .withPhone(VALID_PHONE_BOB).withEmail(VALID_EMAIL_AMY).withAddress(VALID_ADDRESS_AMY)
//    //                .withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND).build();
//    //        EditCommand expectedCommand = new EditCommand(targetIdentifier, descriptor);
//    //
//    //        assertParseSuccess(parser, userInput, expectedCommand);
//    //    }
//    //
//    //    @Test
//    //    public void parse_someFieldsSpecified_success() {
//    //        UniqueIdentifier targetIdentifier = STAFF_ID_FIRST_PERSON;
//    //        String userInput = targetIdentifier + PHONE_DESC_BOB + EMAIL_DESC_AMY;
//    //
//    //        EditPersonDescriptor descriptor = new EditPersonDescriptorBuilder().withPhone(VALID_PHONE_BOB)
//    //                .withEmail(VALID_EMAIL_AMY).build();
//    //        EditCommand expectedCommand = new EditCommand(targetIdentifier, descriptor);
//    //
//    //        assertParseSuccess(parser, userInput, expectedCommand);
//    //    }
//    //
//    //    @Test
//    //    public void parse_oneFieldSpecified_success() {
//    //        // name
//    //        UniqueIdentifier targetIdentifier = STAFF_ID_SECOND_PERSON;
//    //        String userInput = targetIdentifier + NAME_DESC_AMY;
//    //        EditPersonDescriptor descriptor = new EditPersonDescriptorBuilder().withName(VALID_NAME_AMY).build();
//    //        EditCommand expectedCommand = new EditCommand(targetIdentifier, descriptor);
//    //        assertParseSuccess(parser, userInput, expectedCommand);
//    //
//    //        // phone
//    //        userInput = targetIdentifier + PHONE_DESC_AMY;
//    //        descriptor = new EditPersonDescriptorBuilder().withPhone(VALID_PHONE_AMY).build();
//    //        expectedCommand = new EditCommand(targetIdentifier, descriptor);
//    //        assertParseSuccess(parser, userInput, expectedCommand);
//    //
//    //        // email
//    //        userInput = targetIdentifier + EMAIL_DESC_AMY;
//    //        descriptor = new EditPersonDescriptorBuilder().withEmail(VALID_EMAIL_AMY).build();
//    //        expectedCommand = new EditCommand(targetIdentifier, descriptor);
//    //        assertParseSuccess(parser, userInput, expectedCommand);
//    //
//    //        // address
//    //        userInput = targetIdentifier + ADDRESS_DESC_AMY;
//    //        descriptor = new EditPersonDescriptorBuilder().withAddress(VALID_ADDRESS_AMY).build();
//    //        expectedCommand = new EditCommand(targetIdentifier, descriptor);
//    //        assertParseSuccess(parser, userInput, expectedCommand);
//    //
//    //        // tags
//    //        userInput = targetIdentifier + TAG_DESC_FRIEND;
//    //        descriptor = new EditPersonDescriptorBuilder().withTags(VALID_TAG_FRIEND).build();
//    //        expectedCommand = new EditCommand(targetIdentifier, descriptor);
//    //        assertParseSuccess(parser, userInput, expectedCommand);
//    //    }
//    //
//    //    @Test
//    //    public void parse_multipleRepeatedFields_acceptsLast() {
//    //        UniqueIdentifier targetIdentifier = STAFF_ID_FIRST_PERSON;
//    //        String userInput = targetIdentifier + PHONE_DESC_AMY + ADDRESS_DESC_AMY + EMAIL_DESC_AMY
//    //                + TAG_DESC_FRIEND + PHONE_DESC_AMY + ADDRESS_DESC_AMY + EMAIL_DESC_AMY + TAG_DESC_FRIEND
//    //                + PHONE_DESC_BOB + ADDRESS_DESC_BOB + EMAIL_DESC_BOB + TAG_DESC_HUSBAND;
//    //
//    //        EditPersonDescriptor descriptor = new EditPersonDescriptorBuilder().withPhone(VALID_PHONE_BOB)
//    //                .withEmail(VALID_EMAIL_BOB).withAddress(VALID_ADDRESS_BOB)
//    //                .withTags(VALID_TAG_FRIEND, VALID_TAG_HUSBAND).build();
//    //        EditCommand expectedCommand = new EditCommand(targetIdentifier, descriptor);
//    //
//    //        assertParseSuccess(parser, userInput, expectedCommand);
//    //    }
//    //
//    //    @Test
//    //    public void parse_invalidValueFollowedByValidValue_success() {
//    //        // no other valid values specified
//    //        UniqueIdentifier targetIdentifier = STAFF_ID_FIRST_PERSON;
//    //        String userInput = targetIdentifier + INVALID_PHONE_DESC + PHONE_DESC_BOB;
//    //        EditPersonDescriptor descriptor = new EditPersonDescriptorBuilder().withPhone(VALID_PHONE_BOB).build();
//    //        EditCommand expectedCommand = new EditCommand(targetIdentifier, descriptor);
//    //        assertParseSuccess(parser, userInput, expectedCommand);
//    //
//    //        // other valid values specified
//    //        userInput = targetIdentifier + EMAIL_DESC_BOB + INVALID_PHONE_DESC + ADDRESS_DESC_BOB
//    //                + PHONE_DESC_BOB;
//    //        descriptor = new EditPersonDescriptorBuilder().withPhone(VALID_PHONE_BOB).withEmail(VALID_EMAIL_BOB)
//    //                .withAddress(VALID_ADDRESS_BOB).build();
//    //        expectedCommand = new EditCommand(targetIdentifier, descriptor);
//    //        assertParseSuccess(parser, userInput, expectedCommand);
//    //    }
//    //
//    //    @Test
//    //    public void parse_resetTags_success() {
//    //        UniqueIdentifier targetIdentifier = STAFF_ID_SECOND_PERSON;
//    //        String userInput = targetIdentifier + TAG_EMPTY;
//    //
//    //        EditPersonDescriptor descriptor = new EditPersonDescriptorBuilder().withTags().build();
//    //        EditCommand expectedCommand = new EditCommand(targetIdentifier, descriptor);
//    //
//    //        assertParseSuccess(parser, userInput, expectedCommand);
//    //    }
//
//    // Edit Command Parser Tests for Staff
//}
