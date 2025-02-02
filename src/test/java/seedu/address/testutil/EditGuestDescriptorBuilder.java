package seedu.address.testutil;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.commands.EditCommand.EditGuestDescriptor;
import seedu.address.model.person.Email;
import seedu.address.model.person.Guest;
import seedu.address.model.person.Name;
import seedu.address.model.person.PassportNumber;
import seedu.address.model.person.RoomNumber;
import seedu.address.model.tag.Tag;

/**
 * A utility class to help with building EditPersonDescriptor objects.
 */
public class EditGuestDescriptorBuilder {

    private EditGuestDescriptor descriptor;

    public EditGuestDescriptorBuilder() {
        descriptor = new EditGuestDescriptor();
    }

    public EditGuestDescriptorBuilder(EditGuestDescriptor descriptor) {
        this.descriptor = new EditGuestDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditGuestDescriptor} with fields containing {@code guest}'s details
     */
    public EditGuestDescriptorBuilder(Guest guest) {
        descriptor = new EditGuestDescriptor();
        descriptor.setName(guest.getName());
        descriptor.setEmail(guest.getEmail());
        descriptor.setTags(guest.getTags());
        descriptor.setPassportNumber(guest.getPassportNumber());
        descriptor.setRoomNumber(guest.getRoomNumber());
    }

    /**
     * Sets the {@code Name} of the {@code EditGuestDescriptor} that we are building.
     */
    public EditGuestDescriptorBuilder withName(String name) {
        descriptor.setName(new Name(name));
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code EditGuestDescriptor} that we are building.
     */
    public EditGuestDescriptorBuilder withEmail(String email) {
        descriptor.setEmail(new Email(email));
        return this;
    }

    /**
     * Sets the {@code RoomNumber} of the {@code EditGuestDescriptor} that we are building.
     */
    public EditGuestDescriptorBuilder withRoomNumber(String roomNumber) {
        descriptor.setRoomNumber(new RoomNumber(roomNumber));
        return this;
    }

    /**
     * Sets the {@code PassportNumber} of the {@code EditGuestDescriptor} that we are building.
     */
    public EditGuestDescriptorBuilder withPassportNumber(String passportNumber) {
        descriptor.setPassportNumber(new PassportNumber(passportNumber));
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code EditGuestDescriptor}
     * that we are building.
     */
    public EditGuestDescriptorBuilder withTags(String... tags) {
        Set<Tag> tagSet = Stream.of(tags).map(Tag::new).collect(Collectors.toSet());
        descriptor.setTags(tagSet);
        return this;
    }

    public EditGuestDescriptor build() {
        return descriptor;
    }
}
