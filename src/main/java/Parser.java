import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class Parser {
    public static Command parse(String input) throws PaggroException {
        String[] inputArr = input.split(" ", 2);
        String command = inputArr[0];
        if (command.equals("list")) {
            return new Command(Command.CommandType.LIST);
        } else if (command.equals("mark")) {
            try {
                String parameters = inputArr[1];
                return new Command(Command.CommandType.MARK, parameters);
            } catch (ArrayIndexOutOfBoundsException e) { // no parameter given
                throw new PaggroException("    Really? mark has to be used with a number... =.=");
            }
        } else if (command.equals("unmark")) {
            try {
                String parameters = inputArr[1];
                int i = Integer.parseInt(parameters);
                return new Command(Command.CommandType.UNMARK, parameters);
            } catch (NumberFormatException e) { // parameter was not a number
                throw new PaggroException("    Really? Can you input an actual number this time... =.=");
            } catch (ArrayIndexOutOfBoundsException e) { // no parameter given
                throw new PaggroException("    Really? unmark has to be used with a number... =.=");
            }
        } else if (command.equals("todo")) {
            try {
                String parameters = inputArr[1];
                return new Command(Command.CommandType.TODO, parameters);
            } catch (ArrayIndexOutOfBoundsException e) { // no description given
                throw new PaggroException("    Really? The description of a todo cannot be empty... =.=");
            }
        } else if (command.equals("deadline")) {
            try {
                String parameters = inputArr[1];
                return new Command(Command.CommandType.DEADLINE, parameters);
            } catch (ArrayIndexOutOfBoundsException e) { // no description given
                throw new PaggroException("    Really? The description of a deadline cannot be empty... =.=");
            }
        } else if (command.equals("event")) {
            try {
                String parameters = inputArr[1];
                return new Command(Command.CommandType.EVENT, parameters);
            } catch (ArrayIndexOutOfBoundsException e) { // no description given
                throw new PaggroException("    Really? The description of an event cannot be empty... =.=");
            }
        } else if (command.equals("delete")) {
            try {
                String parameters = inputArr[1];
                int i = Integer.parseInt(parameters);
                return new Command(Command.CommandType.DELETE, parameters);
            } catch (NumberFormatException e) { // parameter was not a number
                throw new PaggroException("    Really? Can you input an actual number this time... =.=");
            } catch (ArrayIndexOutOfBoundsException e) { // no parameter given
                throw new PaggroException("    Really? delete has to be used with a number... =.=");
            }
        } else if (command.equals("listOnDate")) {
            try {
                String dateString = inputArr[1];
                return new Command(Command.CommandType.LISTONDATE, dateString);
            } catch (ArrayIndexOutOfBoundsException e) { // no description given
                throw new PaggroException("    Really? The date of a listOnDate cannot be empty... =.=");
            }
        } else if (command.equals("bye")) {
            return new Command(Command.CommandType.BYE);
        } else { // command not recognised
            throw new PaggroException("    Come on... You don't actually expect me to understand that right... =.=");
        }
    }
}
