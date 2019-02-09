package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;


/**
 * Lists all persons in the address book to the user.
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Lists the persons in address book sorted by alphabetical order.\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = new ArrayList<>(addressBook.getAllPersons().immutableListView());
        Collections.sort(allPersons, new Comparator<>() {
            @Override
            public int compare(final ReadOnlyPerson person1, final ReadOnlyPerson person2) {
                return person1.getName().toString().compareTo(person2.getName().toString());
            }
        });
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }
}
