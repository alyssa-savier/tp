package seedu.address.testutil;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.commands.EditCommand.EditStaffDescriptor;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Staff;
import seedu.address.model.person.StaffId;
import seedu.address.model.tag.Tag;

/**
 * A utility class to help with building EditStaffDescriptor objects.
 */
public class EditStaffDescriptorBuilder {

    private EditStaffDescriptor descriptor;

    public EditStaffDescriptorBuilder() {
        descriptor = new EditStaffDescriptor();
    }

    public EditStaffDescriptorBuilder(EditStaffDescriptor descriptor) {
        this.descriptor = new EditStaffDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditStaffDescriptor} with fields containing {@code staff}'s details
     */
    public EditStaffDescriptorBuilder(Staff staff) {
        descriptor = new EditStaffDescriptor();
        descriptor.setName(staff.getName());
        descriptor.setEmail(staff.getEmail());
        descriptor.setTags(staff.getTags());
        descriptor.setPhone(staff.getPhone());
        descriptor.setAddress(staff.getAddress());
        descriptor.setStaffId(staff.getStaffId());
    }

    /**
     * Sets the {@code Name} of the {@code EditStaffDescriptor} that we are building.
     */
    public EditStaffDescriptorBuilder withName(String name) {
        descriptor.setName(new Name(name));
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code EditStaffDescriptor} that we are building.
     */
    public EditStaffDescriptorBuilder withPhone(String phone) {
        descriptor.setPhone(new Phone(phone));
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code EditStaffDescriptor} that we are building.
     */
    public EditStaffDescriptorBuilder withEmail(String email) {
        descriptor.setEmail(new Email(email));
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code EditStaffDescriptor} that we are building.
     */
    public EditStaffDescriptorBuilder withAddress(String address) {
        descriptor.setAddress(new Address(address));
        return this;
    }

    /**
     * Sets the {@code StaffId} of the {@code EditStaffDescriptor} that we are building.
     */
    public EditStaffDescriptorBuilder withStaffId(String staffId) {
        descriptor.setStaffId(new StaffId(staffId));
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code EditStaffDescriptor}
     * that we are building.
     */
    public EditStaffDescriptorBuilder withTags(String... tags) {
        Set<Tag> tagSet = Stream.of(tags).map(Tag::new).collect(Collectors.toSet());
        descriptor.setTags(tagSet);
        return this;
    }

    public EditStaffDescriptor build() {
        return descriptor;
    }
}
