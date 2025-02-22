package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PRESCRIPTION_1;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.AddPrescriptionCommand;
import seedu.address.model.tag.Tag;

public class AddPrescriptionCommandParserTest {
    private AddPrescriptionCommandParser parser = new AddPrescriptionCommandParser();
    @Test
    public void parse_validArgs_returnsAddPrescriptionCommand() {
        assertParseSuccess(parser, "1 t\\CoughSyrup",
                new AddPrescriptionCommand(INDEX_FIRST_PERSON,
                        new Tag(VALID_PRESCRIPTION_1)));
    }

    @Test
    public void parse_noPrescription_throwsParseException() {
        assertParseFailure(parser, "1",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                        AddPrescriptionCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_invalidIndex_throwsParseException() {
        assertParseFailure(parser, "a t\\CoughSyrup",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                        AddPrescriptionCommand.MESSAGE_USAGE));
    }
}
