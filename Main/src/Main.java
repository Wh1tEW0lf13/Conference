public class Main {
    public static void main(String[] args) {
        Registration register = new Registration();
        Meeting meeting = new Meeting();
        register.FileReader();
        meeting.FindNewFriend(register.guests);

    }
}
